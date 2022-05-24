package Java.com.csqhomeworks.homeworks03;

public class Professor extends Teacher{

    public Professor() {
    }

    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public double getSalary() {
        return super.getSalary() * 1.3;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("薪资" + getSalary());
    }
}
