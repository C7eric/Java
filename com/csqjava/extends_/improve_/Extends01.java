package Java.com.csqjava.extends_.improve_;

import Java.com.csqjava.extends_.Graduate;
import Java.com.csqjava.extends_.Pupil;

public class Extends01 {
    public static void main(String[] args) {

        Java.com.csqjava.extends_.Pupil obj1 = new Pupil();
        obj1.setScore(60);
        obj1.age = 10;
        obj1.name = "xiaoming";
        obj1.showInfo();
        System.out.println("----------------");
        Java.com.csqjava.extends_.Graduate obj2 = new Graduate();
        obj2.age = 19;
        obj2.name = "CSQ";
        obj2.setScore(100);
        obj2.showInfo();
    }
}
