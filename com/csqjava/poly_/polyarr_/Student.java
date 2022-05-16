package Java.com.csqjava.poly_.polyarr_;

public class Student extends Person{
    private int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String say(){
        return super.say() + "score:" + getScore();
    }

    public void study(){
        System.out.println(getName() + "study");
    }
}
