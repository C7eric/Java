package Java.practice;

public class MethodExercise01 {

    public static void main(String[] args){

        TestDrive02 b = new TestDrive02();
        boolean d = b.numberJudge(6);
        if(d){
            System.out.println("为奇数");
        } else {
            System.out.println("不是奇数");
        }

        TestDrive02 e = new TestDrive02();
        e.print(3,4,'*');
    }
}

class TestDrive02 {

    public boolean numberJudge(int n){

        return n % 2 != 0 ;
    }

    public void print(int row,int col,char c){

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
