package product1;
/*
* 客户实例对象，负责保存客户信息
* */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String tel;
    private String email;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setGender(char gender){
        this.gender=gender;
    }

    public char getGender() {
        return gender;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    public String getTel(){
        return this.tel;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    public Customer(){}
    public Customer(String name,char gender,int age,String tel,String email){
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.tel=tel;
        this.email=email;
    }
}
