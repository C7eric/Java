package Java.com.csqalgorithm.recursive_;

public class Code01_GetMax {

    public static int getMax(int[] arr){
        return process(arr,0,arr.length - 1);
    }

    //arr[L...R] 范围求最大值
    public static int process(int[] arr,int L,int R){

        if(L == R){  // arr[L...R] 范围内只有一个数,直接返回
            return arr[L];
        }
        int mid = L + ((R - L) >> 1); // 中点求法
        int leftMax = process(arr,0,mid);
        int rightMax = process(arr,mid + 1,R);
        return Math.max(leftMax,rightMax);
    }
}
