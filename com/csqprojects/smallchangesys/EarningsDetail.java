package Java.com.csqprojects.smallchangesys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EarningsDetail  {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

    private String name;
    private int earings;
    private String date;
    private int balance;

    public String getName() {
        return name;
    }

    public int getEarings() {
        return earings;
    }

    public String getDate(String sdf) {
        return sdf.format(date);
    }

    public int getBalance() {
        return balance;
    }

    public void say(){
        System.out.println(getName() + " "
                + getEarings() + " "
                + getDate(date) + " "
                + getBalance());
    }
}
