package Bean;

/**
 * 测试Customer的封装性
 */

public class CustomerTest {

    public static void main(String[] args) {

        Customer c1 = new Customer();

        c1.setName("刘强东");
        c1.setGender('男');
        c1.setAge(45);
        c1.setPhone("13232344535");
        c1.setEmail("lqd@qq.com");

        System.out.println(c1.getName()+","+c1.getGender()+","+c1.getAge()+","+c1.getPhone()+","+c1.getEmail());
    }

}
