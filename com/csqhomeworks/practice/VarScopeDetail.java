package Java.com.csqhomeworks.practice;

public class VarScopeDetail {

    public static void main(String[] args){
        Person01 obj = new Person01();
        obj.say();

    }
}

class Person01 {

    //细节 ： 属性可以加修饰符（public、protected、private）
    //局部变量不能加
    private int age = 19;
    String name = "CSQ";
    public void say(){
        //细节 ：属性和局部变量可以重名，访问时遵循就近原则
        String name = "csq";
        System.out.println(name);
    }
}