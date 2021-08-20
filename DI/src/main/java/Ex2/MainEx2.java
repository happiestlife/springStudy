package Ex2;
import Ex2.Customer.CustomerList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainEx2 {
    public static void main(String args[]) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Setting2.class);

        CustomerList customerList = ctx.getBean(CustomerList.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            InfraClasses.printFirstMenu();
            int firstMenuType = Integer.parseInt(br.readLine());
            if(firstMenuType == 1){
                InfraClasses.printAboutCustomerInfo();
                int secondMenuType = Integer.parseInt(br.readLine());;
                switch (secondMenuType){
                    case 1:
                        customerList.insertCustomerInfo(br);
                        break;
                    case 2:
                        System.out.print("input name\n>> ");
                        customerList.modifyCustomerInfo(br.readLine(), br);
                        break;
                    case 3:
                        System.out.print("input name\n>> ");
                        customerList.deleteCustomerInfo(br.readLine());
                        break;
                    default:
                        System.out.println("input wrong data");
                }
            }else if(firstMenuType == 2){
                InfraClasses.printAboutPrintInfo();
                int secondMenuType = Integer.parseInt(br.readLine());
                switch (secondMenuType){
                    case 1:
                        customerList.printAllCustomerInfo();
                        break;
                    case 2:
                        System.out.print("input name\n>> ");
                        customerList.printParticularCustomerInfo(br.readLine());
                        break;
                    default:
                        System.out.println("input wrong data");
                }
            }else
                break;
        }
        br.close();
    }
}
