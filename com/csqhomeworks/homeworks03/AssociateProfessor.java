package Java.com.csqhomeworks.homeworks03;

public class AssociateProfessor extends Teacher{

    public AssociateProfessor() {
    }

    public AssociateProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public double getSalary() {
        return super.getSalary() * 1.2;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("薪资" + getSalary());
    }
}
