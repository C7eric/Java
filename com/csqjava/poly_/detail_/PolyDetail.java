package Java.com.csqjava.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {

        /**向上转型
         * 父类的引用指向类子类的对象
         *语法 : 父类类型引用名 = new 子类类型();
         */
        Animal animal = new Cat();
        Object object = new Cat(); //可以吗？ 可以 Object也是Cat父类

        // 可以调用父类中的所有成员(需遵守访问权限)
        //但是不能调用子类的特有的成员
        //因为在编译阶段,能调用那些成员,是由编译类型决定的
        //animal.catchMouse();错误
        //最终运行效果看子类的具体实现,即调用方法时,按照从子类开始查找方法
        //然后调用,规则与之前方法调用规则一致

        animal.eat();
        animal.run();
        animal.show();
        animal.sleep();
        System.out.println("____________________________");
        
        /**
         * 希望调用Cat 的 catchMouse 方法
         * 多态的向下转型
         * 语法 : 子类类型 引用名 = (子类类型) 父类引用
         * 要求 : 父类的引用必须指向的是 当前目标类型的对象
         */

        // cat 的编译类型是 Cat , 运行类型是 Cat
        Cat cat = (Cat)animal;
        cat.catchMouse();

    }
}
