package Java.practice;

public class VarParameter {

    public static void main(String[] args) {
        CsqMethod obj = new CsqMethod();
        System.out.println(obj.showScore("CSQ", 99, 99, 99, 99));
    }
}

class CsqMethod {

    public String showScore(String name,double... scores){

        double totalScore = 0;
        for(int i = 0;i < scores.length;i++){
            totalScore += scores[i];
        }
        return name + "有" + scores.length + "门课的成绩总分为 = " + totalScore;
    }
}