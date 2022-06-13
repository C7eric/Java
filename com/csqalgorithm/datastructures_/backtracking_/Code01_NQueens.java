package Java.com.csqalgorithm.datastructures_.backtracking_;

/**
 * @author C77eric
 * @version 1.0
 */
public class Code01_NQueens {
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    // 当前来到i行，一共是0~N-1行
    // 在i行上放皇后，所有列都尝试
    // 必须要保证跟之前所有的皇后不打架
    // int[] record record[x] = y 之前的第x行的皇后，放在了y列上
    // 返回：不关心i以上发生了什么，i.... 后续有多少合法的方法数
    public static int process1(int i, int[] record, int n) {
        if (i == 1) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; ++j) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }
    public static boolean isValid(int[] record,int i,int j){
        for(int  k = 0;k < i;k++){
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }
}
