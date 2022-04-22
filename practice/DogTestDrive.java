package Java.practice;

class Dog {

    String name;

    public static void main(String[] args) {
        // 创建 Dog 对象
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";

        // 创建 Dog 数组
        Dog[] myDogs = new Dog[3];

        // 关门放狗
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        // 通过数组引用存取Dog
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";

        // myDog[2] 的名字是？
        System.out.println("Last dog's name is " + myDogs[2].name);

        // 逐个对Dog 实施bark();
        int x = 0;
        while (x < 3) {
            myDogs[x].bark();
            ++x;
        }
    }

    public void bark() {

        System.out.println(name + "says Ruff!");
    }

}
