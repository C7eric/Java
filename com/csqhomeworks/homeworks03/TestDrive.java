package Java.com.csqhomeworks.homeworks03;

public class TestDrive {
    public static void main(String[] args) {
        Teacher[] teachers = new Teacher[3];
        teachers[0] = new Lecturer("csq1",19,"讲师",10000);
        teachers[1] = new AssociateProfessor("csq2",25,"副教授",25000);
        teachers[2] = new Professor("csq3",30,"教授",100000);

        for(Teacher teacher : teachers){

            teacher.introduce();
        }
    }
}
