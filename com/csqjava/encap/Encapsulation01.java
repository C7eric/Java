package Java.com.csqjava.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("csq");
        person.setAge(19);
        person.setSalary(40000);
        System.out.println(person.info());
        Person obj = new Person();
        obj.setName("sdsadasdsad");
        obj.setAge(177);
        Person person02 = new Person("CSQ",19,500000);
        System.out.println("---------------------");
        System.out.println(person02.info());
    }
}

    class Person {

        public String name; // 名称公开
        private int age; // 年龄私有化
        private double salary;

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }
        public Person (){}

        public Person(String name, int age, double salary) {
//            this.name = name;
//            this.age = age;
//            this.salary = salary;
            //我们可以将set方法写在构造器中，这样仍然可以验证
            setAge(age);
            setName(name);
            setSalary(salary);
        }

        public void setAge(int age) {

            if (age >= 1 && age <= 120) {
                this.age = age;
            } else {
                System.out.println("年龄输入异常");
                this.age = 18; // 给一个默认年龄
            }

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name.length() >= 2 && name.length() <= 6) {
                this.name = name;
            } else {
                System.out.println("输入名称不合法");
                this.name = "error";
            }
        }

        public String info() {
            return "信息为 name=" + name + " age=" + age + "薪水=" + salary;
        }
    }
