package Java.com.csqjava.poly_.polyparameter_;

public class PolyParameter {

    public static void main(String[] args) {

        Manager manager1 = new Manager("csq",40000,36666);
        GeneralStaff generalStaff1 = new GeneralStaff("csqq",400000);
        PolyParameter polyParameter = new PolyParameter();
        polyParameter.showEmpAnnual(manager1);
        polyParameter.showEmpAnnual(generalStaff1);
        polyParameter.testWork(generalStaff1);
        polyParameter.testWork(manager1);
    }

    public void showEmpAnnual(Employee e){

        e.getAnnual();
    }

    public void testWork(Employee e){
        if(e instanceof Manager){
            ((Manager) e).manage();
        } else if (e instanceof GeneralStaff){
            ((GeneralStaff)e).work();
        }
    }
}

