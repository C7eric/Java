package Java.com.csqjava.override_;

public class OverrideExercise {
    public static void main(String[] args) {
        Person person1 = new Person("csq1",19);
        System.out.println(person1.say());
        Student student1 = new Student("csqq",19,"020611",100);
        System.out.println(student1.say());
    }
}

class Person{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Person(String name, int age){
        this.age = age;
        this.name = name;

    }

    public String say(){
        return "姓名:" + name + "年龄:" + age;
    }
}

class Student extends Person{

    private String id;
    private int score;

    public Student(String name, int age, String id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }
    public String say(){
        return super.say() + "ID:" + id + "分数" + score;
    }
}