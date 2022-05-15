package Java.com.csqjava.poly_;

public class Poly01 {

    public static void main(String[] args) {
        Master CSQ = new Master("csq");
        Dog xb = new Dog("xiapbai",2);
        Bone db = new Bone("大棒骨");
        CSQ.feed(xb,db);
        Cat xx = new Cat("xx",3);
        Fish fish = new Fish("xiaoyu");
        CSQ.feed(xx,fish);

    }
}
