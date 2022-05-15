package Java.com.csqjava.poly_;

public class Master {

    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(Dog dog,Bone bone){
        System.out.println("主人" + name + "给" + dog.getName() + "吃" + bone.getName());
    }

    public void feed(Cat cat,Fish fish){
        System.out.println("主人" + name + "给" + cat.getName() + "吃" + fish.getName());
    }

}
