package Java.com.csqhomeworks.homeworks02;

public class HomeWorks02 {

    public static void main(String[] args) {

        Person[] persons = new Person[3];
        persons[0] = new Person("CSQ1", 21, "Java");
        persons[1] = new Person("CSQ2",19,"Python");
        persons[2] = new Person("CSQ3",35,"C++");

        Person tools = new Person();
        tools.bubbleSort(persons);

        for (Person person : persons) {

            System.out.println(person.getAge());
        }
    }


}
