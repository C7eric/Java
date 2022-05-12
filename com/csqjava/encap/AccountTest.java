package Java.com.csqjava.encap;

public class AccountTest {

    public static void main(String[] args) {
        Account obj = new Account();
        obj.setName("CSQ");
        obj.setBalance(100000000);
        obj.setPwd("061102");
        obj.showInfo();
        System.out.println("---------------");
        Account obj2 = new Account("csq",10000000,"020611");
        obj2.showInfo();
        Account obj3 = new Account("ericcsq",11,"C020611.");
        System.out.println("================");
        obj3.showInfo();
    }
}
