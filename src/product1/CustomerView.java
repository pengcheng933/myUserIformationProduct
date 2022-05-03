package product1;


import java.util.Scanner;

/*
* 主模板，负责菜单显示和用户操作功能
*
*
* */
public class CustomerView {
    private CustomerList customerList=new CustomerList(10);
    public void enterMainCustomer(){
        boolean isFlag=true;
        while (isFlag) {
            System.out.println("\n---------------客户信息管理软件---------------");
            System.out.println("                  1.添加客户");
            System.out.println("                  2.修改客户");
            System.out.println("                  3.删除客户");
            System.out.println("                  4.客户列表");
            System.out.println("                  5.退    出 ");
            System.out.print("      请选择（1-5）");
            Scanner scan=new Scanner(System.in);
            int num= scan.nextInt();
            switch (num){
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    modifyCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    listAllCustomer();
                    break;
                case 5:
                    System.out.print("是否退出请选择（y/n）");
                    String endSelection=scan.next();
                    if(endSelection.charAt(0) == 'y'){
                        isFlag=false;

                    }
                    break;
            }
        }
    }
    public void addNewCustomer(){
        Scanner scan=new Scanner(System.in);
        System.out.println("---------------添加客户信息---------------");
        System.out.print("姓名");
        String name=scan.next();
        System.out.print("性别");
        char gender=scan.next().charAt(0);
        System.out.print("年龄");
        int age=scan.nextInt();
        System.out.print("电话");
        String tel=scan.next();
        System.out.print("邮件");
        String email=scan.next();
        boolean isAddok=customerList.addCustomer(new Customer(name,gender,age,tel,email));
        if(isAddok){
            System.out.println("---------------添加客户成功---------------");

        }else {
            System.out.println("---------------添加客户失败---------------");

        }
    }
    public void modifyCustomer(){
        Scanner scan=new Scanner(System.in);
        System.out.println("---------------修改客户信息---------------");
        int index;
        for(; ;){
            System.out.print("输入客户编号（小于0退出）");
            index= scan.nextInt();
            if(index <0){
                System.out.println("---------------退出修改成功---------------");

                return;
            }else if(index <customerList.getTotal()){
                break;
            }
        }
        System.out.print("姓名");
        Customer cust = customerList.getCustomers(index);
        scan.next();
        String name=scan.nextLine();
        if(name.trim().isEmpty()){
            name=cust.getName();
        }
        System.out.print("性别");
        String gender1= scan.nextLine();
        char gender;
        if(gender1.trim().isEmpty()){
            gender=cust.getGender();
        }else {
            gender=gender1.charAt(0);
        }
        System.out.print("年龄");
        String age1=scan.nextLine();
        int age;
        if(age1.trim().isEmpty()){
            age=cust.getAge();
        }else {
            age=Integer.parseInt(age1);
        }
        System.out.print("电话");
        String tel=scan.nextLine();
        if(tel.trim().isEmpty()){
            tel= cust.getTel();
        }
        System.out.print("邮件");
        String email= scan.nextLine();
        if(email.trim().isEmpty()){
            email=cust.getEmail();
        }
        boolean isRepalyok=customerList.replaceCustomer(new Customer(name,gender,age,tel,email),index);
        if(isRepalyok){
            System.out.println("---------------修改信息成功---------------");
        }else {
            System.out.println("---------------修改信息失败---------------");
        }
    }
    public void deleteCustomer(){
        Scanner scan=new Scanner(System.in);
        System.out.println("---------------删除客户---------------");
        System.out.print("输入客户编号（小于0退出）");
        for(; ;){
            int index=scan.nextInt();
            int total=customerList.getTotal();
            if(index < 0){
                return;
            }else if(index < total){
                boolean isDel=customerList.deleteCustomer(index);
                if(isDel){
                    System.out.println("---------------删除成功---------------");
                    break;
                }else {
                    System.out.println("---------------删除失败---------------");
                    break;
                }
            }
        }
    }
    public void listAllCustomer(){
        System.out.println("---------------客户信息列表---------------");
        int total=customerList.getTotal();
        if(total == 0){
            System.out.println("没找到记录");
        }else {
            Customer[] custs=customerList.getAllCustomers();
            System.out.println("\t编号\t姓名\t性别\t年龄\t电话\t\t邮件");
            for(int i=0;i <custs.length;i ++){
                System.out.println("\t"+i +"\t"+"\t"+custs[i].getName() +"\t"  +custs[i].getGender() +"\t"+"\t"+ custs[i].getAge()+"\t"+"\t"+custs[i].getTel()+"\t"+custs[i].getEmail());


            }
        }

        System.out.println("---------------客户信息结束---------------");

    }
    public static void main(String[] args) {

        CustomerView customerView=new CustomerView();
        customerView.enterMainCustomer();
    }
}
