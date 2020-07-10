package Bean;

/**
 * Customer为实体对象，用来封装客户信息
 */

public class Customer {

//    //单元测试
//    public static void main(String[] args) {
//
//        Customer c1 = new Customer();
//        printInfo(c1);
//
//        Customer c2 = new Customer("马云",'男',55,"13012344143");
//        printInfo(c2);
//
//        Customer c3 = new Customer("马化腾",'男',45,"13123425562","ponyma@qq.com");
//        printInfo(c3);
//
//    }
//
//    public static void printInfo(Customer c){
//        System.out.println(c.name + ',' + c.gender + ',' + c.age + "," + c.phone + "," +c.email);
//    }

    private String name;//名字
    private char gender;//性别
    private int age;//年龄
    private String phone;//电话
    private String email;//邮箱

    //无参构造方法
    public Customer(){

    }

    //初始化有名字、性别、年龄和电话属性的对象
    public Customer(String name,char gender,int age,String phone){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    //初始化有所有属性的对象
    public Customer(String name,char gender,int age,String phone,String email){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    /**
     * getter/setter
     */

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public char getGender(){
        return gender;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
