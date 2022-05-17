package Java.com.csqjava.object_;

public class Finalize_ {

    public static void main(String[] args) {

        /*
            1.当对象被回收时,系统自动调用该对象的finalize方法。子类可以重写该方法
            做一些释放资源的操作
            2.回收的时机: 当某个对象没有任何引用时,JVM就认为这个对象是一个垃圾对象,
            就会使用垃圾回收机制来销毁该对象,在销毁该对象之前,先调用finalize方法
            3.垃圾回收机制的调用,是由系统来决定的,也可以通过System.gc()
            主动出发垃圾回收机制
         */

        Car bmw = new Car("宝马");
        bmw = null;
        /*
            此时  Car 对象 就是一个垃圾 , 垃圾回收器就会回收（销毁） 对象  把空间释放了
            在销毁对象之前,会调用该对象的finalize方法

            程序员就可以在 finalize中, 写自己的业务逻辑,比如释放资源：数据库链接,或者打开文件
            如果程序员不重写finalize , 那么就会调用 Object 类 的finalize 方法,即默认处理
            如果重写了finalize ,那么就可以实现自己的业务逻辑
         */

        System.gc();//  主动调用垃圾回收器
        System.out.println("程序退出 ");
    }
}

class Car{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 重写  finalize 方法
    // 可以使用快捷键

    @Override
    protected void finalize() throws Throwable {
        System.out.println("销毁汽车" + getName());
        System.out.println("释放了一些资源... ");
    }
}