package Customer;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

public class CustomerDao {
    JdbcTemplate jdbcTemplate;
    public CustomerDao(DataSource ds){
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public CustomerInfo selectByEmail(String email){
        List<CustomerInfo> result = jdbcTemplate.query(
                "select * from customer where email = ?",
                new RowMapper<CustomerInfo>() {
                    @Override
                    public CustomerInfo mapRow(ResultSet rs, int i) throws SQLException {
                        CustomerInfo customerInfo = new CustomerInfo(
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getString("phoneNum"),
                                rs.getString("email")
                        );
                        customerInfo.setId(rs.getInt("ID"));
                        return customerInfo;
                    }
                }, email);
        if(result.isEmpty())
            return null;
        else
            return result.get(0);
    }

    public List<CustomerInfo> selectAll(){
        List<CustomerInfo> results = jdbcTemplate.query(
                "select * from customer",
                new RowMapper<CustomerInfo>() {
                    @Override
                    public CustomerInfo mapRow(ResultSet rs, int i) throws SQLException {
                        CustomerInfo customerInfo = new CustomerInfo(
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getString("phoneNum"),
                                rs.getString("email")
                        );
                        customerInfo.setId(rs.getInt("ID"));
                        return customerInfo;
                    }
                }
        );
        if(results.isEmpty())
            return null;
        else
            return results;
    }

    public void insert(CustomerInfo customerInfo){
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(
                        "insert into customer (name, age, phoneNum, email)" + "values (?, ?, ?, ?)",
                        new String[]{"ID"}
                );
                ps.setString(1, customerInfo.getName());
                ps.setInt(2, customerInfo.getAge());
                ps.setString(3, customerInfo.getPhoneNum());
                ps.setString(4, customerInfo.getEmail());
                return ps;
            }
        }, keyholder);
        Number key = keyholder.getKey();
        customerInfo.setId(key.intValue());
    }

    @Transactional
    public boolean update(BufferedReader br) throws IOException {
        System.out.println("수정하고 싶은 손님의 이메일을 입력하세요.");
        String email = br.readLine();
        CustomerInfo data = selectByEmail(email);
        if(data == null){
            System.out.println(email+"에 해당하는 데이터 없음");
            return false;
        }
        System.out.println("이름 나이 전화번호 순으로 각 항목을 띄어쓰기로 구분하여 입력하세요.");
        StringTokenizer stk = new StringTokenizer(br.readLine());

        jdbcTemplate.update("update customer set name = ?, age = ?, phoneNum = ? where email = ?",
                            stk.nextToken(), Integer.parseInt(stk.nextToken()), stk.nextToken(), email);
        return true;
    }

    public int count(){
        Integer num = jdbcTemplate.queryForObject("select count(*) from customer", Integer.class);
        return num;
    }
}
