package Java.com.csqjava.object_;

import Java.com.csqjava.modifier.A;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == c);

        /**
         *    == 比较运算符
         *    1.既可以判断基本类型,又可以判断引用类型
         *    2.如果判断基本类型,判断的是值是否相等
         *    3.如果判断引用类型,判断的是地址是否相等,，即判断是不是同一个对象
         */
    }
}

class A {

}
