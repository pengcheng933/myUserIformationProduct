package product1;



/*
* Customer管理模块，负责增删改查
*
* */
public class CustomerList {
    private Customer[] customers;
    private int total=0;
    public CustomerList(int num){
        this.customers=new Customer[num];
    }
    public boolean addCustomer(Customer customer){
        if(total < customers.length){
            this.customers[total]=customer;
            total++;
            return true;
        }
        return false;
    }
    public boolean replaceCustomer(Customer customer,int index){
        if(index < total || index >= 0){
            this.customers[index]=customer;
            return true;
        }
        return false;
    }
    public boolean deleteCustomer(int index){
        if(index >= 0 && index <total){
            for(int i=index;i <total ;i ++){
                customers[i]=customers[i +1];
                customers[total]=null;
                total--;

                return true;
            }
        }
        return false;
    }
    public Customer[] getAllCustomers(){
        Customer[] cust=new Customer[total];
        for (int i=0;i<total;i ++){
            cust[i]=customers[i];

        }
        return cust;
    }

    public Customer getCustomers(int index){
        if(index >= 0 || index < total){
            return customers[index];

        }
        return null;
    }
    public int getTotal(){
        return total;
    }

}
