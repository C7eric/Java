package Java.com.csqjava.pkg;

// 注意 ：我们需要哪个类,就导入哪个类,不建议使用 * 导入
//import java.util.Scanner; //表示只会引入 java.util 包下的 Scanner
//import java.util.*; //表示将java.util 包下的所有类都导入

import java.util.Arrays;

public class Import01 {

    public static void main(String[] args) {

        //使用系统提供的 Arrays 完成 数组排序
        int[] arr = {2,3,55,32,51};
        Arrays.sort(arr);
        //输出排序结果
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
