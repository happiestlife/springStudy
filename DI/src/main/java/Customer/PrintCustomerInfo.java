package Customer;

import org.springframework.stereotype.Component;

@Component
public class PrintCustomerInfo {
    public PrintCustomerInfo(){}

    void printInfo(CustomerInfo customerInfo){
        System.out.println(customerInfo.getID() + " : name. " + customerInfo.getName() + "(age. " + customerInfo.getAge()
                +") phone number. " + customerInfo.getPhoneNum());
    }

    void printSummarizedInfo(CustomerInfo customerInfo){
        System.out.println(customerInfo.getID() + " : " + customerInfo.getName());
    }
}
