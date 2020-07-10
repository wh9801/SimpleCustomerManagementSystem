package Service;

import Bean.Customer;

import java.sql.SQLOutput;

/**
 * CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 * 并提供相应的添加、修改、删除和遍历的方法，供CustomerView调用
 */

public class CustomerList {

    //单元测试
//    public static void main(String[] args) {
//        CustomerList customerList = new CustomerList(5);
//
//        Customer c1 = new Customer("马化腾",'男',47,"13011112222");
//        Customer c2 = new Customer("马云",'男',57,"13011112222");
//        Customer c3 = new Customer("刘强东",'男',49,"13011112222");
//        Customer c4 = new Customer("小美",'女',49,"13011112222");
//        Customer c5 = new Customer("小娜",'女',49,"13011112222");
//        Customer c6 = new Customer("小慧",'女',49,"13011112222");
//        System.out.println(customerList.addCustomer(c1));
//        System.out.println(customerList.addCustomer(c2));
//        System.out.println(customerList.addCustomer(c3));
//        System.out.println(customerList.addCustomer(c4));
//        System.out.println(customerList.addCustomer(c5));
//        System.out.println(customerList.addCustomer(c6));
//        System.out.println();
//
//        for(int i = 0;i < customerList.getAllCustomers().length;i++){
//            printInfo(customerList.getAllCustomers()[i]);
//        }
//        System.out.println(customerList.getAllCustomers().length);
//        System.out.println();
//
//        printInfo(customerList.getCustomer(1));
//        System.out.println(customerList.getTotal());
//
//        System.out.println();
//
//        Customer c = new Customer();
//        System.out.println(customerList.replaceCustomer(0,c));
//        printInfo(customerList.getCustomer(1));
//
//        System.out.println();
//
//        System.out.println(customerList.deleteCustomer(6));
//        for(int i = 0;i < customerList.getAllCustomers().length;i++){
//            printInfo(customerList.getAllCustomers()[i]);
//        }
//
//    }

//    public static void printInfo(Customer c){
//        System.out.println(c.getName()+","+c.getGender()+","+c.getAge()+","+c.getPhone()+","+c.getEmail());
//    }

    private Customer[] customers;//保存客户对象的数组
    private int total = 0;//记录已保存客户对象的数量

    /**
     * 构造器，初始化customers数组
     * @param totalCustomer:指定customers数组最大空间
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
        total = 0;
    }

    /**
     * 将参数customer添加到数组中最后一个客户对象记录之后
     * @param customer：指定要添加的客户对象
     * @return  添加成功返回true；false表示数据已满，无法添加
     */
    public boolean addCustomer(Customer customer){
        if(customer != null && total < customers.length){
            customers[total++] = customer;
            return true;
        }else {
            return false;
        }
    }

    /**
     * 用参数customer替换数组中由index指定的对象
     * @param index 指定所替换对象在数组中的位置，从0开始
     * @param customer 指定替换的新用户对象
     * @return  替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index,Customer customer){
        if(index >= 0 && index < total){
            customers[index] = customer;
            return true;
        }else {
            return false;
        }
    }

    /**
     * 从数组中删除参数index指定索引位置的客户对象记录
     * @param index 指定所删除对象在数组中的索引位置，从0开始
     * @return 删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index){
        if(index >= 0 && index < total){
            for(int i = index;i < total-1;i++){
                customers[i] = customers[i+1];
            }
            customers[--total] = null;
            return true;
        }else {
            return false;
        }
    }

    /**
     * 返回数组中记录的所有客户对象
     * @return Customer[]数组中包含了当前所有客户对象，该数组长度与对象个数相同
     */
    public Customer[] getAllCustomers(){
      //   return customers; 不需要数组中多余的null,故需要赋值给新数组返回
        Customer[] customers = new Customer[total];
        for(int i = 0;i < total;i++){
            customers[i] = this.customers[i];//赋值的是地址值
        }
        return customers;
    }

    /**
     * 返回参数index指定索引位置的客户对象记录
     * @param index 指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index){
        if(index >= 0 && index < total){
            return customers[index];
        }else{
            return null;
        }
    }

    /**
     * 返回Customer对象的总数
     * @return
     */
    public int getTotal(){
        return total;
    }


}
