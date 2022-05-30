package Java.com.csqhomeworks.practice;

public class RecursionExercise01 {

    public static void main(String[] args){

        TestDrive03 obj = new TestDrive03();
        int res = obj.fibonacci(-1 );
        System.out.println(res);

    }
}

class  TestDrive03 {

    public int fibonacci(int n){
        if(n >= 1){
            if(n == 1 || n == 2){
                return 1;
            } else {
                return fibonacci(n-1) + fibonacci(n-2);
            }
        } else {
            System.out.println("n 为 非负数");
            return 0;
        }
    }
}