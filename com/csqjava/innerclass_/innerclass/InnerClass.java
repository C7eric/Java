package Java.com.csqjava.innerclass_.innerclass;

public class InnerClass {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner.f2();
        outer.f3();
    }
    public static class Outer{
        public static int  a = 10;

        public void f1(){

        }

        class Inner{
        public static void f2(){
            System.out.println(a);
        }}
        public  void f3(){
            Inner inner = new Inner();
            inner.f2();
        }
    }
}
