package Java.com.csqjava.poly_.polyparameter_;

public class Manager extends Employee{

    private int bonus;

    public Manager() {
    }

    public Manager(String name, int monthSalary, int bonus) {
        super(name, monthSalary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void manage(){
        System.out.println("manage");
    }

    @Override
    public void getAnnual(){
        System.out.println(getName() + "getAnnual");
    }
}
