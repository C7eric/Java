package Java.com.csqalgorithm.solution;

public class Code_EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr){

        int eor = 0;
        for (int cur : arr){
            eor ^= cur;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for(int cur : arr){
            eor ^= cur;
        }
        //eor = a ^ b
        //eor != 0
        //eor 必然有一个位置为1
        int rightOne = eor & (~eor + 1); // 提取出最右边的1
        int onlyOne = 0;
        for(int cur : arr){
            if((cur & rightOne) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}


