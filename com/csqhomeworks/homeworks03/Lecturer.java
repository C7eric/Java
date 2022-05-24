package Java.com.csqhomeworks.homeworks03;

public class Lecturer extends Teacher{

    public Lecturer() {
    }

    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public double getSalary(){
        return super.getSalary() * 1.1;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("薪资" + getSalary());
    }
}
