package Java.com.csqjava.innerclass_.anonymousclass;

public class InnerClassExercise {

    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();

        // 匿名内部类
        cellPhone.alarmClock(new Bell() {
                                 @Override
                                 public void ring() {
                                     System.out.println("lalalala");
                                 }
                             }

        );

        // 传统方法
        phone phone = new phone();
        cellPhone.alarmClock(new phone());

    }
    public static void f1(Bell bell){bell.ring();}
}
interface Bell{
    void ring();
}
class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}
class phone implements Bell{
    @Override
    public void ring() {
        System.out.println("wuwuwuwu");
    }
}
