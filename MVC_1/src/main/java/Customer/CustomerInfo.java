package Customer;

public class CustomerInfo {
    private int ID;
    private String name;
    private int age;
    private String phoneNum;
    private String email;

    public CustomerInfo(String name, int age, String phoneNum, String email){
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public void setId(int ID){
        this.ID = ID;
    }
    public int getId(){
        return ID;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    public String getPhoneNum(){
        return phoneNum;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
}
