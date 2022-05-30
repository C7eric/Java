package Java.com.csqhomeworks.practice;

import java.util.Arrays;

/**
 * @author CSQ-PC
 */
public class MethodDetail {

    //编写一个main方法
    public static void main(String[] args){

         TestDrive a = new TestDrive();
         a.getSumAndSub(1,3);
         System.out.println(Arrays.toString(a.getSumAndSub(1, 3)));

    }
}

class TestDrive{

    // 1.一个方法最多有一个返回值
    public int[] getSumAndSub(int a,int b){

        //创建一个数组
        int[] res = new int[2];
        res[0] = a + b;
        res[1] = a - b;
        return res;
    }

    // 2.返回类型可以为任意类型，包含基本类型或引用类型（数组，对象）

    // 3.如果方法要求有返回数据类型，则方法体中最后的执行语句必须为 return 值
    //而且要求返回值类型必须跟return的值类型一样或者兼容

    public double TestDrive2(){
        double d1 = 1.1 * 3;
        int  n = 100;
        return n; //int -> double
    }
}
