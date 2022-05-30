package Java.com.csqhomeworks.practice;

public class Constructor01 {

    public static void main(String[] args){

        Person02 p1 = new Person02("CSQ",19); // 第一个构造器
        Person02 p2 = new Person02("csq"); //第二个构造器
        System.out.println("p1的姓名：" + p1.name);
        System.out.println("p1的年龄：" + p1.age);
        System.out.println("p2的姓名：" + p2.name);
    }
}

class Person02 {
    String name;
    int age;
    //构造器
    //1.构造器没有返回值,也不能写 void
    //2.构造器的名称和类名 Person02 必须一致
    //3.(String pName,int pAge) 是构造器形参列表，规则和成员方法一致
    //4.构造器是完成对象的初始化，并不是创建对象
    //5.在创建对象时，系统自动的调用该类的构造方法
    //6.如果程序没有定义构造器，系统会自动给类生成一个默认无参构造器（也叫默认构造器）
    //比如 Person02(){},使用javap指令反编译
    //7.一旦定义了自己的构造器，默认的构造器就覆盖了，就不能使用默认的无参构造器，除非显式的定义一下
    public Person02(String pName,int pAge){
        name = pName;
        age = pAge;
    }

    // 构造器的重载
    public Person02(String pName){
        name = pName;
    }
}