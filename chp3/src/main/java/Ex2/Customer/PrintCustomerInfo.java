package Ex2.Customer;

import org.springframework.stereotype.Component;

@Component
public class PrintCustomerInfo {
    public PrintCustomerInfo(){}

    void printInfo(CustomerInfo customerInfo){
        System.out.println(customerInfo.getID() + " : " + customerInfo.getName() + "(" + customerInfo.getAge() +") " + customerInfo.getPhoneNum());
    }

    void printSummarizedInfo(CustomerInfo customerInfo){
        System.out.println(customerInfo.getID() + " : " + customerInfo.getName());
    }
}
