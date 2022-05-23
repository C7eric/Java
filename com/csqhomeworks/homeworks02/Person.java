package Java.com.csqhomeworks.homeworks02;

public class Person {

    private String name;
    private int age;
    private String job;

    public Person() {
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void bubbleSort(Person[] persons) {

        if(persons.length < 2 || persons == null){
            return;
        }

        for (int i = 0; i < persons.length; i++) {
            for (int j = i + 1; j < persons.length; j++) {
                if(persons[i].getAge() > persons[j].getAge()) {
                    swap(persons,i,j);
                }
            }

        }
    }

    public void swap(Person[] persons, int i, int j) {

        Person tmp = persons[i];
        persons[i] = persons[j];
        persons[j] = tmp;
    }

}

