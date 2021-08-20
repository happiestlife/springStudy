package Ex2;

public class InfraClasses {
    static void printFirstMenu(){
        System.out.println("-----------------");
        System.out.println("1. About customerInfo");
        System.out.println("2. About printInfo");
        System.out.println("3. exit");
        System.out.print("-----------------\n>> ");
    }
    static void printAboutCustomerInfo(){
        System.out.println("-----------------");
        System.out.println("1. insert customer info");
        System.out.println("2. modify customer info");
        System.out.println("3. delete customer info");
        System.out.print("-----------------\n>> ");
    }
    static void printAboutPrintInfo(){
        System.out.println("-----------------");
        System.out.println("1. print all customers info");
        System.out.println("2. print particular customer info");
        System.out.print("-----------------\n>> ");
    }
}
