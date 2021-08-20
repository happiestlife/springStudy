package Ex2.Customer;

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

    private int customerNum = 0;
    private HashMap<Integer, CustomerInfo> customerList = new HashMap<>();
    @Autowired
    private PrintCustomerInfo printCustomerInfo;

    // store, get, modify data section
    public void insertCustomerInfo()throws IOException {
        System.out.println("input your name, phone number, age, security key, talk you want to say(no spacing)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        CustomerInfo newCustomer = new CustomerInfo(stk.nextToken(), stk.nextToken(), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), stk.nextToken());
        customerList.put(++customerNum, newCustomer);
        System.out.println("haseMoreToken : "+stk.hasMoreElements());
        br.close();
    }
    CustomerInfo getCustomerInfo(String name){
        if(customerList.containsKey(name) == false){
            System.out.println("there is no data with name " + name);
            return null;
        }else {
            return customerList.get(name);
        }
    }
    public void modifyCustomerInfo(String name){
        CustomerInfo wantedData;
        if((wantedData = getCustomerInfo(name)) != null){
           System.out.println("what kind of data do you want change?");
           System.out.println("1. name");
           System.out.println("2. phoneNum");
           System.out.println("3. age");
           System.out.println("4. speak");
           System.out.println("5. securityKey");
           System.out.println(">> ");
           Scanner subScanner = new Scanner(System.in);
           int type = subScanner.nextInt();

           switch(type){
               case 1:
                   modifyMethodHelper_printType("name");
                   wantedData.setName(subScanner.nextLine());
                   break;
               case 2:
                   modifyMethodHelper_printType("phoneNum");
                   wantedData.setPhoneNum(subScanner.nextLine());
                   break;
               case 3:
                   modifyMethodHelper_printType("age");
                   wantedData.setAge(subScanner.nextInt());
                   break;
               case 4:
                   modifyMethodHelper_printType("speak");
                   wantedData.setSpeak(subScanner.nextLine());
                   break;
               case 5:
                   System.out.println("input securityKey");
                   if(subScanner.nextInt() == wantedData.getSecurityKey()){
                       modifyMethodHelper_printType("securityKey");
                       wantedData.setSecurityKey(subScanner.nextInt());
                   }
               default:
                   System.out.println("input wrong data");
                   return;
           }
           System.out.println("data updated");
           subScanner.close();
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
        Iterator<Integer> keys = customerList.keySet().iterator();
        while(keys.hasNext()) {
            int key = keys.next();
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
