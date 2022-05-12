package Java.com.csqjava.extends_;

public class Graduate {

    public String name;
    public int age;
    public int score;

    public void setScore(int score) {
        this.score = score;
    }

    public void test(){
        System.out.println("testing~");
    }

    public void showInfo(){
        System.out.println("name=" + name + "年龄=" + age +"成绩=" + score);
    }
}
