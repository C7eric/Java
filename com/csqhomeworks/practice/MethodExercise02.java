package Java.com.csqhomeworks.practice;

/**
 * @author CSQ-PC
 */
public class MethodExercise02 {

     public static void main(String[] args) {

          Person p = new Person();
          p.name = "CSQ";
          p.age = 19;

          Mytools tool = new Mytools();
          Person p2 = tool.copyPerson(p);

     }
}

class Person {
          String name;
          int age;
}

class Mytools {

          public Person copyPerson(Person p){

               Person p2 = new Person();
               p2.name = p.name;
               p2.age = p.age;
               return p2;
          }

}

