package Java.com.csqjava.encap;

/**
 * 创建程序,在其中定义两个类：Account 和 AccountTest 类体会 Java 的封装性。
 * Account 类要求具有属性：姓名（长度为 2 位 3 位或 4 位）、余额(必须>20)、
 * 密码（必须是六位）, 如果不满足，则给出提示信息，并给默认值(程序员自己定)
 * 通过 setXxx 的方法给 Account 的属性赋值。
 * 在 AccountTest
 */
public class Account {
    //为了封装，将3个属性设置为 private
    private String name;
    private double balance;
    private String pwd;

    // 提供两个构造器
    public Account() {
    }

    public Account(String name, double balance, String pwd) {
        this.setBalance(balance);
        this.setName(name);
        this.setPwd(pwd);
    }

    public String getName() {
        return name;
    }

    //姓名 （长度为2位或者3位或者4位）
    public void setName(String name) {
        if(name.length() >= 2 && name.length() < 5) {
            this.name = name;
        } else {
            System.out.println("姓名违法，已设置默认值 ：NULL");
            this.name = "NULL";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 20) {
            this.balance = balance;
        } else {
            System.out.println("余额少于20,默认为0");
            this.balance = 0;
        }
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if(pwd.length() == 6) {
            this.pwd = pwd;
        } else {
            System.out.println("密码长度不合法，已设置默认值：020611");
            this.pwd = "020611";
        }
    }

    public void showInfo(){
        System.out.println("账号信息 name =" + name + "余额=" + balance + "密码=" + pwd);
    }
}
