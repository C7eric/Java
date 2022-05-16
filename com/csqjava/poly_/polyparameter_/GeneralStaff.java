package Java.com.csqjava.poly_.polyparameter_;

public class GeneralStaff extends Employee{

    public GeneralStaff(String name, int monthSalary) {
        super(name, monthSalary);
    }

    public GeneralStaff() {
    }

    public void getAnnual(){
        System.out.println(super.getName() + "getAnnual");
    }

    public void work(){
        System.out.println(super.getName() + "work");
    }
}
