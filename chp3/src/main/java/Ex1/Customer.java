package Ex1;
import java.util.Scanner;

public class Customer {
    static int customerNum = 0;
    private int ID;
    private String name;
    private String phoneNum;
    private int age;
    private int securityKey;
    private String speak;

    public Customer(String name, String phoneNum, int age, int securityKey, String speak){
        ID = ++Customer.customerNum;
        this.name = name;
        this.phoneNum = phoneNum;
        this.age = age;
        this.securityKey = securityKey;
        this.speak = speak;
    }

    void printInfo(int securityKey){
        if(this.securityKey == securityKey)
            System.out.println(ID + " : " + name + "(" +age+") " + phoneNum);
        else
            System.out.println("System access is denied");
    }

    void changeSecurityKey(int oldKey, int newKey){
        if(securityKey == oldKey){
            securityKey = newKey;
            System.out.println("비밀키 변경 성공");
        }else
            System.out.println("비밀키 변경 실패");
    }

    void speaking(){
        System.out.println(speak);
    }
}

