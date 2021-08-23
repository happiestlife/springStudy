package Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerList {

    private static int customerNum = 0;
    private HashMap<String, CustomerInfo> customerList = new HashMap<>();
    @Autowired
    private PrintCustomerInfo printCustomerInfo;

    // store, get, modify data section
    public void insertCustomerInfo(BufferedReader br)throws IOException {
        System.out.println("input your name, phone number, age, security key, talk you want to say(no spacing)");
        StringTokenizer stk = new StringTokenizer(br.readLine());
        CustomerInfo newCustomer = new CustomerInfo(++customerNum, stk.nextToken(), stk.nextToken(), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), stk.nextToken());
        customerList.put(newCustomer.getName(), newCustomer);
    }
    CustomerInfo getCustomerInfo(String name){
        if(customerList.containsKey(name) == false){
            System.out.println("there is no data with name " + name);
            return null;
        }else {
            return customerList.get(name);
        }
    }
    public void modifyCustomerInfo(String name, BufferedReader br) throws IOException {
        CustomerInfo wantedData;
        if((wantedData = getCustomerInfo(name)) != null){
           System.out.println("what kind of data do you want change?");
           System.out.println("1. name");
           System.out.println("2. phoneNum");
           System.out.println("3. age");
           System.out.println("4. speak");
           System.out.println("5. securityKey");
           System.out.println(">> ");
           int type = Integer.parseInt(br.readLine());

           switch(type){
               case 1:
                   modifyMethodHelper_printType("name");
                   wantedData.setName(br.readLine());
                   break;
               case 2:
                   modifyMethodHelper_printType("phoneNum");
                   wantedData.setPhoneNum(br.readLine());
                   break;
               case 3:
                   modifyMethodHelper_printType("age");
                   wantedData.setAge(Integer.parseInt(br.readLine()));
                   break;
               case 4:
                   modifyMethodHelper_printType("speak");
                   wantedData.setSpeak(br.readLine());
                   break;
               case 5:
                   System.out.println("input securityKey");
                   if(Integer.parseInt(br.readLine()) == wantedData.getSecurityKey()){
                       modifyMethodHelper_printType("securityKey");
                       wantedData.setSecurityKey(Integer.parseInt(br.readLine()));
                   }
               default:
                   System.out.println("input wrong data");
                   return;
           }
           System.out.println("data updated");
        }
    }
    void modifyMethodHelper_printType(String type){
        System.out.println("insert data (" + type + ")");
        System.out.print(">> ");
    }
    public void deleteCustomerInfo(String name){
        if(customerList.containsKey(name) == true){
            customerList.remove(name);
            System.out.println("data deleted");
        }else
            System.out.println("there is no data with name " + name);
    }

    // print section
    public void printAllCustomerInfo(){
        Iterator<String> keys = customerList.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            printCustomerInfo.printInfo(customerList.get(key));
        }
    }
    public void printParticularCustomerInfo(String name){
        CustomerInfo wantedData;
        if((wantedData = getCustomerInfo(name)) != null){
            printCustomerInfo.printInfo(wantedData);
        }else
            System.out.println("there is no data with name " + name);
    }
}
