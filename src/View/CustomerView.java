package View;

import Bean.Customer;
import Service.CustomerList;
import Utils.CMUtility;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 */

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        Customer customer = new Customer("马化腾",'男',47,"13011112222","mht@qq.com");
        customerList.addCustomer(customer);
    }
    /**
     * 显示主菜单，响应用户输入，
     * 根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理
     */
    public void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag){
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("请确认是否退出：Y/N");

                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }
            }


        }

    }

    /**
     * 增加用户
     */
    private void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(5);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(20);

        //将读入数据封装为一个Customer对象
        Customer customer = new Customer(name,gender,age,phone,email);
        //将此对象添加到CustomList对象的数组中
        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("---------------------添加成功---------------------");
        }else {
            System.out.println("客户列表已满，添加失败！");
        }

    }

    /**
     * 修改用户
     */
    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        Customer customer;
        int index;
        //验证用户想要修改的用户合法性
        for (;;){
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = CMUtility.readInt();
            if(index == -1){
                return;//不能使用break
            }
            //用户看到的index默认从1开始
            customer = customerList.getCustomer(index - 1);
            if(customer == null){
                System.out.println("无法找到指定客户！");
            }else {
                break;
            }
        }
        //修改用户信息,如果输入回车则保留原值不改变
        System.out.print("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(5, customer.getName());

        System.out.print("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());

        System.out.print("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());

        System.out.print("电话(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(15, customer.getPhone());

        System.out.print("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(20, customer.getEmail());

        //获取用户输入的属性后，封装到新的Customer对象
        customer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.replaceCustomer(index - 1, customer);
        if(isSuccess){
            System.out.println("---------------------修改完成---------------------");
        }else {
            System.out.println("---------------------修改失败---------------------");
        }
    }

    /**
     * 删除用户
     */
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        Customer customer;
        int index;
        for (;;){
            System.out.print("请选择待删除客户编号(-1退出)：");
            index = CMUtility.readInt();
            if(index == -1){
                return;
            }
            customer = customerList.getCustomer(index - 1);
            if (customer == null){
                System.out.println("无法找到指定用户！");
            }else {
                break;
            }
        }

        System.out.println("确认是否删除(Y/N)：");
        char deleteOrNot = CMUtility.readConfirmSelection();
        if (deleteOrNot == 'Y'){
            boolean isSuccess = customerList.deleteCustomer(index - 1);
            if(isSuccess){
                System.out.println("---------------------删除完成---------------------");
            }else {
                System.out.println("---------------------删除失败---------------------");
            }
        }else {
            return;
        }
    }

    /**
     * 获取用户列表
     */
    private void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------");
        if (customerList.getTotal() == 0){
            System.out.println("没有任何客户记录！");
        }else{
            System.out.println("编号\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱");
            Customer[] customers = customerList.getAllCustomers();
            for(int i = 0; i < customers.length; i++){
                Customer cust = customers[i];
                System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t\t" +
                        cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }

    public static void main(String[] args){
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }


}
