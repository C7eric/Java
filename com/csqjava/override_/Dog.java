package Java.com.csqjava.override_;

public class Dog extends Animal{

    /**
     * 1.因为Dog 是 Animal子类
     * 2.Dog 的cry 方法 和 Animal 的 cry 定义形式一样（名称、返回类型、参数）
     * 3.这时我们就说Dog的cry方法，重写了Animal的cry方法
     */
    public void cry(){
        System.out.println("Dog--");
    }

    /**
     *   细节：
     *  子类方法的返回类型和父类方法返回类型一样
     *  或者是父类返回类型的子类
     */
    public String m1(){
        return null;
    }

    /**
     * 细节：
     *  子类方法不能缩小父类方法的访问权限
     *  public > protected > 默认 > private
     */

    public void eat(){

    }
}
