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
            return name + "为" + age + "岁" + "月薪为" + salary;
        }
    }
