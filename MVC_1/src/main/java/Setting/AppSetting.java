package Setting;

import Customer.CustomerDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppSetting {
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("dlgustjd1234");
        ds.setInitialSize(1);
        ds.setMaxActive(3);
        return ds;
    }

    @Bean
    public CustomerDao customerDao(){
        CustomerDao customerDao = new CustomerDao(dataSource());
        return customerDao;
    }

    @Bean
    PlatformTransactionManager platformTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
}
