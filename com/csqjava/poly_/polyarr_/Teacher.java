package Java.com.csqjava.poly_.polyarr_;

public class Teacher extends Person{
    private int salary;

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public Teacher(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String say(){
        return super.say() + "salary:" + getSalary();
    }

    public void teach(){
        System.out.println(getName() + "teach");
    }
}
