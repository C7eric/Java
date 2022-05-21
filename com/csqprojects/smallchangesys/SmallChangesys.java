package Java.com.csqprojects.smallchangesys;

import java.util.Scanner;

public class SmallChangesys {

    public static void main(String[] args) {

        boolean loop = true;
        Scanner myScanner = new Scanner(System.in);
        String key = "";
        SystemDetail.say();
        do{

            SmallChangesys.systemMenu();
            key = myScanner.next();
            switch (key) {
                case "1" -> SystemDetail.say();
                case "2" -> System.out.println("收益入账");
                case "3" -> System.out.println("消费");
                case "4" -> {
                    System.out.println("退出");
                    loop = false;
                }
                default -> System.out.println("选择错误,请重新选择");
            }
        }while(loop);
    }

    public static void systemMenu(){

        System.out.println("===============零钱通==============");
        System.out.println("           1.  零钱通明细           ");
        System.out.println("           2.  收益入账            ");
        System.out.println("           3.  消费                ");
        System.out.println("           4.  退出                ");
        System.out.println("请选择：                            ");
    }
}
