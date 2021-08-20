package Ex2.Customer;

class CustomerInfo {
    private int ID;
    private String name;
    private String phoneNum;
    private int age;
    private int securityKey;
    private String speak;

    public CustomerInfo(int ID, String name, String phoneNum, int age, int securityKey, String speak){
        this.ID = ID;
        this.name = name;
        this.phoneNum = phoneNum;
        this.age = age;
        this.securityKey = securityKey;
        this.speak = speak;
    }

    void setID(int ID){
        this.ID = ID;
    }
    int getID(){
        return ID;
    }

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }

    void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    String getPhoneNum(){
        return phoneNum;
    }

    void setAge(int age){
        this.age = age;
    }
    int getAge(){
        return age;
    }

    void setSpeak(String speak){
        this.speak = speak;
    }
    String getSpeak(){
        return speak;
    }
    void speaking(){
        System.out.println(speak);
    }

    void setSecurityKey(int securityKey){
        this.securityKey = securityKey;
    }
    int getSecurityKey(){
        return securityKey;
    }
}

