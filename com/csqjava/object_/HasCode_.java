package Java.com.csqjava.object_;

/**
 *  HasCode方法
 *  1.具有提高哈希结构的容器的效率
 *  2.两个引用,如果指向的是同一个对象,则哈希值肯定是一样的
 *  3.两个引用,如果指向的是同一个对象,则哈希值肯定是不一样的
 *  4.哈希值只要根据地址号来的,不能完全将哈希值等价与地址
 *  5.后面在集合中,如果需要,也会重写
 */
public class HasCode_ {
    public static void main(String[] args) {
        AA aa = new AA();
        AA aa2 = new AA();
        AA aa3 = aa;
        System.out.println("aa.hascode：" + aa.hashCode());
        System.out.println("aa2.hascode：" + aa2.hashCode());
        System.out.println(aa3.hashCode());

    }


}

class AA {

}