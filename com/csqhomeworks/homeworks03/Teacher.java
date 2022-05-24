package Java.com.csqhomeworks.homeworks03;

public class Teacher {

    private String name;
    private  int age;
    private String post;
    private double salary;

    public Teacher() {
    }

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     *  实现教师信息的输出
     */
    public void introduce(){

        System.out.println("教师：" + getName() + "年龄" + getAge() + "职称" + getPost());
    }
}
