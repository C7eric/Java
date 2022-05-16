package Java.com.csqjava.poly_.polyparameter_;

public class Employee {

    public String name;
    private int monthSalary;

    public Employee() {
    }

    public Employee(String name, int monthSalary) {
        this.name = name;
        this.monthSalary = monthSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    public void getAnnual(){
        System.out.println("计算年工资");
    }
}
