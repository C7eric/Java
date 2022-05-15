package Java.com.csqjava.poly_.detail_;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sleep(){
        System.out.println("sleep");
    }

    public void eat(){
        System.out.println("eat");
    }

    public void run(){
        System.out.println("run");
    }

    public void show(){
        System.out.println("show");
    }
}
