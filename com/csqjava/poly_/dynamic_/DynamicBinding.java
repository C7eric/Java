package Java.com.csqjava.poly_.dynamic_;

import Java.com.csqjava.modifier.A;
import Java.com.csqjava.modifier.B;

public class DynamicBinding {
    public static void main(String[] args) {

        /**
         * 方法看运行类型
         * 属性看编译类型
         */
        A01 a = new B01(); // 向上转型
        System.out.println(a.sum()); //40
        System.out.println(a.sum1()); // 30
    }
}

/**
 * 动态绑定机制
 * 1.当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
 * 2.当调用对象属性的时候，没有动态绑定机制，哪里声明，那里使用
 */

class A01 {
    public int i =10;
    public int sum(){
        return getI() + 10;
    }

    public int sum1(){
        return i +10;
    }

    public int getI(){
        return i;
    }
}

class B01 extends A01{
    public int i = 20;
    public int sum(){
        return  i + 20;
    }

    public int getI(){
        return i;
    }

    public int sum1(){
        return i + 10;
    }
}