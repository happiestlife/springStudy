package Customer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Setting.AppSetting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static CustomerDao customerDao;
    public static void main(String args[]) throws IOException {
        System.out.println("build success");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppSetting.class);

        customerDao = ctx.getBean(CustomerDao.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("<<손님 저장 프로그램>>");
        int index = 0;
        while(index != 4) {
            printMenu();
            index = Integer.parseInt(br.readLine());
            switch (index) {
                case 1:
                    printAll();
                    break;
                case 2:
                    update(br);
                    break;
                case 3:
                    insert(br);
                    break;
            }
        }

        br.close();
    }
    static void printMenu(){
        System.out.println("\n메뉴를 고르세요");
        System.out.println("1. 전체 출력");
        System.out.println("2. 데이터 수정");
        System.out.println("3. 데이터 저장");
        System.out.println("4. 종료");

    }
    static void printAll(){
        System.out.println("PrintAll");

        System.out.println("전체 data 개수 : " + customerDao.count());
        List<CustomerInfo> customerList = customerDao.selectAll();
        for(CustomerInfo ci : customerList)
            System.out.printf("%d. %s(age : %d), %s, %s\n", ci.getId(), ci.getName(), ci.getAge(), ci.getPhoneNum(), ci.getEmail());
    }

    static void update(BufferedReader br) throws IOException {
        System.out.println("Update");
        if(customerDao.update(br));
            printAll();
    }

    static void insert(BufferedReader br) throws IOException {
        System.out.println("Insert");
        System.out.println("이름 나이 전화번호 이메일 순으로 각 항목을 띄어쓰기로 구분하여 입력하세요.");
        StringTokenizer stk = new StringTokenizer(br.readLine());

        CustomerInfo newCustomer = new CustomerInfo(
                stk.nextToken(),
                Integer.parseInt(stk.nextToken()),
                stk.nextToken(),
                stk.nextToken()
        );

        customerDao.insert(newCustomer);
        printAll();
    }
}
