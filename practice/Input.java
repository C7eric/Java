package Java.practice;

import java.util.Scanner; //表示把 java.util 下的 Scanner 类 导入

public class Input {
    public static void main(String[] args) {
        // 演示接受用户的输入
        // 步骤
        // Scanner 类 表示 简单文本扫描器 , 在 java.util 包 中
        // 1. 引入/导入 Scanner 类 所在的包
        // 2.创建 Scanner 对象 , 就是 new 一个对象
        // myScanner 就是Scanner 类 的对象
        Scanner myScanner = new Scanner(System.in);
        // 3. 接受用户输入，使用相关的方法
        System.out.println("请输入名字");
        String myName = myScanner.next(); // 接受用户输入
        System.out.println("请输入年龄");
        int myAge = myScanner.nextInt(); // 接受用户输入
        System.out.println("请输入薪水");
        double mySalary = myScanner.nextDouble(); // 接受用户输入
        System.out.println("人的信息如下");
        System.out.println("name = " + myName + "age = " + myAge + "薪资 = " + mySalary);
        myScanner.close();
    }
}