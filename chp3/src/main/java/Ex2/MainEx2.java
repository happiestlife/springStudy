package Ex2;
import Ex2.Customer.CustomerList;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class MainEx2 {
    public static void main(String args[]) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Setting2.class);

        CustomerList customerList = ctx.getBean(CustomerList.class);

        Scanner mainScanner = new Scanner(System.in);
        while(true){
            InfraClasses.printFirstMenu();
            int firstMenuType = mainScanner.nextInt();
            if(firstMenuType == 1){
                InfraClasses.printAboutCustomerInfo();
                int secondMenuType = mainScanner.nextInt();
                switch (secondMenuType){
                    case 1:
                        customerList.insertCustomerInfo();
                        break;
                    case 2:
                        System.out.print("input name\n>> ");
                        customerList.modifyCustomerInfo(mainScanner.nextLine());
                        break;
                    case 3:
                        System.out.print("input name\n>> ");
                        customerList.deleteCustomerInfo(mainScanner.nextLine());
                        break;
                    default:
                        System.out.println("input wrong data");
                }
            }else{
                InfraClasses.printAboutPrintInfo();
                int secondMenuType = mainScanner.nextInt();
                switch (secondMenuType){
                    case 1:
                        customerList.printAllCustomerInfo();
                        break;
                    case 2:
                        System.out.print("input name\n>> ");
                        customerList.printParticularCustomerInfo(mainScanner.nextLine());
                        break;
                    default:
                        System.out.println("input wrong data");
                }
            }
        }
    }
}
