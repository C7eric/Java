package Java.com.csqjava.poly_.detail_;

public class Cat extends Animal{

    //方法重写
    public void eat(){
        System.out.println("猫吃鱼");
    }

    //cat 特有的方法
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
