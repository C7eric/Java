package Java.com.csqjava.poly_.polyarr_;

public class PolyArray {

    /**
     * 多态数组
     * 数组的定义为父类类型,里面保存的实际元素为子类类型
     */

    public static void main(String[] args) {

        Person[] persons = new Person[5];
        persons[0] = new Person("CSQ",19);
        persons[1] = new Student("CSQ2",19,100);
        persons[2] = new Student("CSQ3",120,100);
        persons[3] = new Teacher("csqq",25,500000);
        persons[4] = new Teacher("csqqq",35,5000000);

        for (int i = 0; i < persons.length; i++) {

            // 提示:  persons[i] 编译类型是 Person , 运行类型是根据实际情况由 JVM 来判断
            System.out.println(persons[i].say()); //动态绑定机制

            if(persons[i] instanceof Student){
                ((Student) persons[i]).study();
            }
            if(persons[i] instanceof Teacher){
                ((Teacher) persons[i]).teach();
            }
        }


    }
}
