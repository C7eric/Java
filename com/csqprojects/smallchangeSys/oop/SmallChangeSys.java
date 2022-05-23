package Java.com.csqprojects.smallchangeSys.oop;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 将各个功能对应一个方法
 */

public class SmallChangeSys {

    // 属性
    //定义相关的变量

    boolean loop = true;
    Scanner myScanner = new Scanner(System.in);
    String key = "";

    // 2. 完成零钱通明细

    String details = "------------零钱通明细------------";

    // 3.完成收益入账

    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // 4.消费

    /**
     * 定义新变量，保存消费的原因
     */
    String note = "";

    /**
     * 完成显示菜单，并可以选择
     */
    public void mainMenu(){
        do {

            System.out.println("\n================零钱通菜单(OOP)===============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.print("请选择(1-4): ");
            key = myScanner.next();

            // 使用 switch 分支控制

            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    }
        }while(loop);
    }

    /**
     *  完成零钱通明细
     */
    public  void detail(){
        System.out.println(details);
    }

    /**
     *  完成收益入账
     */
    public void income(){

        System.out.println("收益入账金额");
        money = myScanner.nextDouble();

        if(money <= 0){

            System.out.println("收益入账金额 需要大于 0");
            return;
        }
        balance += money;

        date = new Date();
        details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    /**
     *  消费
     */
    public void pay(){

        System.out.println("消费金额");
        money = myScanner.nextDouble();

        if(money <= 0 && money > balance){
            System.out.println("你的消费金额应该在0 - " + balance);
            return;
        }

        System.out.println("消费说明");
        note = myScanner.next();
        balance -= money;
        // 获得当前日期
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    /**
     *  退出
     */
    public void exit(){

        String choice = "";
        while(true){
            System.out.println("你确定要退出吗?  y/n");
            choice = myScanner.next();
            if("y".equals(choice) || "n".equals(choice)){
                break;
            }

            //当用户退出 while 进行判断
            if(choice.equals("y")){
                loop = false;
            }
        }
    }
}
