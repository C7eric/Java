#  	JavaNotes

​																																				           		 	 	 	 	 	 	 	 	 	 	 	 	   	 	 ——C77eric									 																								



[TOC]



## 面向对象OOP

### 类变量

---

#### 什么是 类变量

> 类变量也叫静态变量/静态属性，是该类的所有对象共享的变量，任何一个该类的对象去访问它时，取到的都是相同的值，同样任何一个该类的对象去修改它时，修改的也是同一个变量。



#### 如何定义类变量

> **定义语法**
>
> 访问修饰符 static 数据类型 变量名



#### 如何访问类变量

> 类名.类变量名 
>
> 或者  对象名.类变量名 **静态变量的访问修饰符的访问权限和范围 和 普通属性是一样的**

```java
public static void mian(String[] args){

// 类名.类变量名
// 说明： 类变量是随着类的加载而创建的，所以即使没有创建对象实例也可以访问
System.out.println(A.name);

// 通过对象名.类变量名 也可以访问
A a = new A();
System.out.println(a.name);
}

class A {
// 类变量
// 类变量的访问，必须遵守相关的访问权限
public static String name = "csq";
}
```





#### 类变量的使用注意事项和细节

**I.什么时候需要用类变量**

> 当我们需要让某个类的所有对象都共享一个变量时，就可以考虑是类变量(静态变量)。比如： 定义学生类，统计所有学生共交多少钱，Student(name,static fee)

**II.类变量和实例(普通属性)变量的区别**

> 类变量是该类的所有对象共享的，而实例变量是每个对象独享的

**III.加上 static  称为类变量或静态变量，否则称为实例变量/普通变量/非静态变量**

**VI.类变量可以通过类名.类变量名 或 对象名.类变量名 访问  前提是满足修饰符的访问权限和范围**

**V.实例变量不能通过 类名.类变量名 方式访问**

**VI.类变量是在类加载的时候就初始化了，也就是说，即使没有创建对象，只要类加载了，就可以使用类变量**

**VII.类变量的生命周期是随着类的加载开始，随着类的消亡而销毁**



### 类方法

---

#### 基本介绍

> 类方法也叫静态方法

**形式如下**

访问修饰符 static 数据返回类型 方法名（）{}

#### 类方法的调用

类名.类方法名   对象名.类方法名 **前提是满足访问修饰符的访问权限和范围**

```java
public static void main(String[] args) {
	//创建 2 个学生对象，叫学费
	Stu tom = new Stu("tom");
	//tom.payFee(100);
	Stu.payFee(100);//对不对?对
	Stu mary = new Stu("mary");
	//mary.payFee(200);
	Stu.payFee(200);//对
	//输出当前收到的总学费
	Stu.showFee();//300
	//如果我们希望不创建实例，也可以调用某个方法(即当做工具来使用)
	//这时，把方法做成静态方法时非常合适
	System.out.println("9 开平方的结果是=" + Math.sqrt(9));
	System.out.println(MyTools.calSum(10, 30));
	}
}

//开发自己的工具类时，可以将方法做成静态的，方便调用
class MyTools {
	//求出两个数的和
	public static double calSum(double n1, double n2) {
	return n1 + n2;
	}

//可以写出很多这样的工具方法... }
class Stu {

	private String name;//普通成员
	//定义一个静态变量，来累积学生的学费
	private static double fee = 0;
	public Stu(String name) {
	this.name = name;
}
	//说明
	//1. 当方法使用了 static 修饰后，该方法就是静态方法
	//2. 静态方法就可以访问静态属性/变量
public static void payFee(double fee) {
	Stu.fee += fee;//累积到
}

public static void showFee() {
	System.out.println("总学费有:" + Stu.fee);
	}
}
```



#### 使用场景

当方法中不涉及到任何和对象相关的成员，则可以将方法设计成静态方法，提高开发效率

**如果我们希望不创建实例，也可以调用某个方法（即当作工具使用）**



比如： 工具类中方法 utils

Math 类、Array 类、Collections 集合类



#### 小结:

---

在程序实际开发中，往往会将一些通用的方法，设计成静态方法，这样我们不需要创建对象就可以使用，比如打印一维数组，冒泡排序，完成某个计算任务



#### 注意事项和细节

​	**I.  类方法和普通方法都是随着类的加载而加载，将结构信息储存在方法区：**

​		类方法中无 this 的参数

​		普通方法中隐含着 this 的参数

​	**II.类方法可以通过类名调用，也可以通过对象名调用**

​	**III.普通方法和对象有关，需要通过对象名调用，比如对象名.方法名（参数），不能通过类名调用**

​	**VI.类方法中不允许使用和对象有关的关键字，比如 this 和 super 。普通方法（成员方法）可以**

​	**V.类方法（静态方法）中只能访问 静态变量 或 静态方法**

​	**VII.普通成员方法，既可以访问 非静态成员，也可以访问静态成员**



**小结:**

---

静态方法，只能访问静态的成员，非静态的方法，可以访问静态成员和非静态成员 **前提是必须遵守访问权限和范围**



###  main() 方法

---

#### 形式

```java
public static void main(String [] args){}
```



#### 说明

​	**1. main 方法是虚拟机调用**

​	**2. Java 虚拟机需要调用类的 main 方法，所以该方法的访问权限必须是 public **

​	**3. Java 虚拟机在执行 main 方法时不必创建对象，所以该方法必须是 static**

​	**4.该方法接收 String 类型的数组参数，该数组中保存执行 Java 命令时传递给所运行的类的参数**

​	**5. Java 执行的程序 参数1 参数2 参数3 **



#### 特别提示

---

​	**1.在 main 方法中，我们可以直接调用 main 方法所在类的静态方法 或 静态属性**

​	**2. 但是不能直接访问该类中的非静态成员，必须创建该类的一个实例对象后，才可以通过这个对象去访问类中的非静态成员**



###  代码块

---

#### 基本介绍

> 代码块又称 初始化块 ，属于类中的成员[即 是类的一部分]，类似于方法，将逻辑语句封装在方法体中，通过 {} 包围起来
>
> 但和方法不同，没有方法名 ，没有返回，没有参数，只有方法体，而且不用通过对象或类 显式调用，而是加载类时，或创建对象时隐式调用



#### 基本语法

```java
(修饰符){
};
```



#### 说明

> 1. 修饰符可选，要写的话，也只能写 static
> 2. 代码块分为两类，使用 static 修饰的叫 静态代码块，没有 static 修饰的，叫普通代码块/非静态代码块
> 3. 逻辑语句可以为任何逻辑语句（输入，输出，方法调用，循环，判断等）
> 4. ；可以写，也可以省略 



#### 代码块的好处

- 相当于另外一种形式的构造器（对构造器的补充机制），可以做初始化的操作
- **场景：** 如果多个构造器中都有重复的语句，可以抽取到初始化块中，提高代码的重用性

```java
public class CodeBlock01 {
public static void main(String[] args) {

   Movie movie = new Movie("你好，李焕英");
	System.out.println("===============");
	Movie movie2 = new Movie("唐探 3", 100, "陈思诚");
	}
}
class Movie {

	private String name;
	private double price;
	private String director;
	//3 个构造器-》重载
	//(1) 下面的三个构造器都有相同的语句
	//(2) 这样代码看起来比较冗余
	//(3) 这时我们可以把相同的语句，放入到一个代码块中，即可
	//(4) 这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容
	//(5) 代码块调用的顺序优先于构造器.. {
	System.out.println("电影屏幕打开...");
	System.out.println("广告开始...");
	System.out.println("电影正是开始...");
};

public Movie(String name) {

    System.out.println("Movie(String name) 被调用...");
	this.name = name;
}

public Movie(String name, double price) {

    this.name = name;
	this.price = price;
}
public Movie(String name, double price, String director) {

    System.out.println("Movie(String name, double price, String director) 被调用...");
	this.name = name;
	this.price = price;
	this.director = director;
	}
}
```



#### 使用注意事项和细节

1.  static 代码块也叫做 静态代码块，作用就是对类进行初始化，而且谈随着 **类的加载** 而执行，并且只会执行一次，如果是普通代码块，每创建一个对象，就执行一次
2.  **类什么时候被加载**
    1. 创建对象实例的时候（new)
  3.  创建子类对象实例的时候，父类也会被加载
   4.  使用类的静态成员时（静态属性/静态方法）
5.  普通的代码块，在创建对象实例时，会被隐式调用，被创建一次，调用一次  **如果只是使用类的静态成员时，普通代码块并不会执行**



#### 小结

> ##### 1.static 代码块是在类加载时，执行，且只执行一次

> ##### 2.普通代码块是在创建对象时调用的，创建一次，调用一次

> ##### 3.类加载的 3 种 情况需要记住

```java
public static void main(String[] args) {

	//类被加载的情况举例
	//1. 创建对象实例时(new)
	// AA aa = new AA();
	//2. 创建子类对象实例，父类也会被加载, 而且，父类先被加载，子类后被加载
	// AA aa2 = new AA();
	//3. 使用类的静态成员时(静态属性，静态方法)
	// System.out.println(Cat.n1);
	//static 代码块，是在类加载时，执行的，而且只会执行一次. // DD dd = new DD();
	// DD dd1 = new DD();
	//普通的代码块，在创建对象实例时，会被隐式的调用。
	// 被创建一次，就会调用一次。
	// 如果只是使用类的静态成员时，普通代码块并不会执行
	System.out.println(DD.n1);//8888, 静态模块块一定会执行
	}
}

class DD {

    public static int n1 = 8888;//静态属性
	//静态代码块
	static {
		System.out.println("DD 的静态代码 1 被执行...");//
}

	//普通代码块, 在 new 对象时，被调用，而且是每创建一个对象，就调用一
	//可以这样简单的，理解 普通代码块是构造器的补充
    	{
		System.out.println("DD 的普通代码块...");
	}
}

class Animal {
//静态代码块
	static {
		System.out.println("Animal 的静态代码 1 被执行...");//
	}
}
class Cat extends Animal {

    public static int n1 = 999;//静态属性
	//静态代码块
	static {
			System.out.println("Cat 的静态代码 1 被执行...");//
	}
}
class BB {
//静态代码块
	static {
			System.out.println("BB 的静态代码 1 被执行...");//1
	}
}
class AA extends BB {

    //静态代码块
	static {
		System.out.println("AA 的静态代码 1 被执行...");//2
	};
}
```

---



> ##### 4.创建一个对象时，在 一个类 调用顺序是（重点、难点）

1.  调用静态代码块和静态属性初始化（注意：静态代码块和静态属性初始化调用的优先级一样，如果有多个静态代码块和多个静态变量初始化，则按他们定义的顺序调用）
2.  调用普通代码块和普通属性的初始化（注意：普通代码块和普通属性初始化调用的优先级一样，如果有多个普通代码块和普通属性初始化，则按定义顺序调用
3.  调用构造方法

```java
public static void main(String[] args) {

   A a = new A();
    // (1) A 静态代码块 01 (2) getN1 被调用...(3)A 普通代码块 01(4)getN2 被调用...(5)A() 构造器被调用
	}
}
class A {

   { //普通代码块
	System.out.println("A 普通代码块 01");
}
    	private int n2 = getN2();//普通属性的初始化
	static { //静态代码块
    	System.out.println("A 静态代码块 01");
}
	//静态属性的初始化
	private static int n1 = getN1();
	public static int getN1() {
	System.out.println("getN1 被调用...");
	return 100;
}
	public int getN2() { //普通方法/非静态方法
		System.out.println("getN2 被调用...");
		return 200;
}
	//无参构造器
	public A() {
		System.out.println("A() 构造器被调用");
	}
}
```

---



> ##### 5.构造器的最前面其实隐含了 super() 和 调用普通代码块，静态相关的代码块，属性初始化，在类加载时，就加载完毕，因此是优先于 构造器和 普通代码块执行的

```java
public class CodeBlockDetail03 {
    public static void main(String[] args) {

    new BBB();//(1)AAA 的普通代码块(2)AAA() 构造器被调用(3)BBB 的普通代码块(4)BBB() 构造器被调用
	}
}
class AAA { //父类 Object

    {
		System.out.println("AAA 的普通代码块");
}
public AAA() {

    //(1)super()
	//(2)调用本类的普通代码块
	System.out.println("AAA() 构造器被调用....");
		}
}

class BBB extends AAA {

    {
	System.out.println("BBB 的普通代码块...");
}
public BBB() {

    //(1)super()
	//(2)调用本类的普通代码块
	System.out.println("BBB() 构造器被调用....");	
	}
}
class BBB extends AAA {

    {
		System.out.println("BBB 的普通代码块...");
}
public BBB() {

    //(1)super()
	//(2)调用本类的普通代码块
	System.out.println("BBB() 构造器被调用....");
	}
}
```





> ##### 6.创建一个子类对象时（继承关系） ，他们的 静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序如下

1. 父类的静态代码块和静态属性(优先级一样，按定义顺序执行)

2. 子类的静态代码块和静态属性(优先级一样，按定义顺序执行)
3. 父类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
4. 父类的构造方法
5. 子类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
6. 子类的构造方法

```java
public static void main(String[] args) {


    //(1) 进行类的加载
	//1.1 先加载 父类 A02 1.2 再加载 B02
	//(2) 创建对象
	//2.1 从子类的构造器开始
	//new B02();//对象
	new C02();
	}
}
class A02 { //父类

    private static int n1 = getVal01();
	static {
		System.out.println("A02 的一个静态代码块..");//(2)
	}
	{
	System.out.println("A02 的第一个普通代码块..");//(5)
}
	public int n3 = getVal02();//普通属性的初始化
	public static int getVal01() {
	System.out.println("getVal01");//(1)
	return 10;
}

public int getVal02() {

    System.out.println("getVal02");//(6)
	return 10;
}

public A02() {//构造器
	//隐藏
	//super()
	//普通代码和普通属性的初始化...... System.out.println("A02 的构造器");//(7)
	}
	}
class C02 {

    private int n1 = 100;
	private static int n2 = 200;
	private void m1() {
}

private static void m2() {
	}
	static {
	//静态代码块，只能调用静态成员
	//System.out.println(n1);错误
	System.out.println(n2);//ok
	//m1();//错误
	m2();
	}
{

    //普通代码块，可以使用任意成员
	System.out.println(n1);
	System.out.println(n2);//ok
	m1();
	m2();

	}
}

class B02 extends A02 { //

    private static int n3 = getVal03();

    static {
		System.out.println("B02 的一个静态代码块..");//(4)
}

public int n5 = getVal04();

    {
		System.out.println("B02 的第一个普通代码块..");//(9)
}

	public static int getVal03() {
		System.out.println("getVal03");//(3)
	return 10;
}

public int getVal04() {
	System.out.println("getVal04");//(8)
	return 10;
}

//一定要慢慢的去品.. public B02() {//构造器
//隐藏了
//super()
//普通代码块和普通属性的初始化... System.out.println("B02 的构造器");//(10)
// TODO Auto-generated constructor stub
}
```





> ##### 7.静态代码块只能调用静态成员(静态属性和静态方法)，普通代码块可以调用任意成员



### 设计模式

---

#### 什么是设计模式

> 1. 静态方法和属性的经典使用
> 2. 设计模式是在大量的实践中总结和理论化之后优选的代码结构、编码风格、以及解决问题的思考方式。设计模式就像是经典的棋谱，不同的棋局，我们用不同的棋谱，免去我们自己再思考和摸索



#### 单例模式

##### 什么是单例

1. 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法
2. 单例模式有两种方式 ：**1.饿汉式  2.懒汉式**



##### 单例模式应用实例 -  饿汉式 

**步骤如下**

1. 构造器私有化  -> **防止用户直接 new **

2. 类的内部创建对象

3. 向外暴露一个静态的公共方法  - **getInstance**

4. 代码实现

```java
class GirlFriend {
    private String name;

    // 为了能够在静态方法中返回 gf 对象，需要将其修饰为 static 
    private static GirlFriend gf = new GirlFriend("q");

    private GirlFriend(String name){
        this.name = name;
    }

    // 提供一个公共的 static 方法，返回 gf 对象
    public static GirlFriend getInstance(){
        return gf;
    }
}
```

> ###### 饿汉式可能造成创建了对象，但是没有使用，造成资源浪费



##### 单例应用案例 - 懒汉式

**步骤如下**

1. 构造器私有化

2. 定义一个 static 静态属性对象

3. 提供一个公共的 static 方法，可以返回一个对象

4. 代码实现

```java
class Cat{
    private String name;

    private static Cat cat;
    private Cat(String name){
        this.name = name;
    }

    public static Cat(){
        if(cat == null){
            cat = new Cat("xx");
        }

        return cat;
    }
}
```

> ###### 类加载之后，构造器也不会调用





##### 懒汉式和饿汉式的区别

1. 两者最主要的区别在于创建对象的时机不同：**饿汉式是在类加载时就创建了对象实例，而懒汉式是在使用时才创建**
2. 饿汉式不存在线程安全问题，懒汉式存在线程安全问题
3. 饿汉式存在资源浪费的可能。因为一个程序员一个对象实例都没有使用，那么饿汉式创建的对象实例就浪费了，懒汉式是使用时才创建，就不存在这个问题。
4. 在我们 JavaSE 标准类中，java.lang.Runtime  就是经典的单例模式





### final

---

> **final 可以修饰类，属性，方法和局部变量**



#### final的使用场景

1. 当不希望类被继承时，可以用 final 修饰
2. 当不希望父类的某个方法被子类覆盖/重写时，可以用 final 修饰
3. 当不希望某个类的某个属性的值被修改，可以用 final 修饰
4. 当不希望某个局部变量被修改时，可以用 final 修饰



#### **final的注意事项和细节**

1. final 修饰的常量，一般用 XX_XX_XX_XX 来命名

2. final 修饰的属性在定义时，必须赋值，并且之后不可再修改，赋值可以在如下位置

   1. 在定义时 ： 如 **public final double MAX_VALUE = 10.1;**
   2. 在构造器中
   3. 在代码块中

3. 如果 final 修饰的属性是静态的，则初始化的位置只能是 
   - 定义时 
   - 在静态代码块          
   - 不能在构造器中赋值

4. final 类不能继承，但是可以有实例化对象

5. 如果类不是 final 类，但是含有 final 方法，则该方法虽然不能重写，但是可以被继承

6. 一般来说，如果一个类是 final 类了，就没有必要再将方法，修饰成 final 方法了，

7. final 不能修饰构造方法（即 构造器）

8. final 和 static 往往搭配使用，效率更高，底层编译器做了优化处理

9. 包装类（Integer,Double,Float,Boolean 等 都是 final )String 也是 final 类



### 抽象类

---

>**当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象方法，那么这个类就是抽象类**

```java
abstract class Animal {

	private String name;
	public Animal(String name) {
	this.name = name;
}
	//思考：这里 eat 这里你实现了，其实没有什么意义
	//即： 父类方法不确定性的问题
	//===> 考虑将该方法设计为抽象(abstract)方法
	//===> 所谓抽象方法就是没有实现的方法
	//===> 所谓没有实现就是指，没有方法体
	//===> 当一个类中存在抽象方法时，需要将该类声明为 abstract 类
	//===> 一般来说，抽象类会被继承，有其子类来实现抽象方法.
// public void eat() {
	// System.out.println("这是一个动物，但是不知道吃什么..");
	//}
public abstract void eat() ;
```



>**当父类的一些方法不能确定时，可以用 abstract 关键字来修饰该方法，这个方法就是抽象方法，用 abstract 来修饰该类就是抽象类，一般来说，抽象类会被继承，抽象方法会让子类来实现**



#### 抽象类介绍

> 用 abstract 关键字l来修饰一个类，这个类就叫做抽象类
>
> 访问修饰符 abstract 类名{ }



1. 用 abstract 关键字来修饰一个方法 时，这个方法就是抽象方法

2. ```java
   **访问修饰符 abstract 返回类型 方法名（参数列表）； // 没有方法体**
   ```

3. 抽象类的价值更多作用在于设计，是设计者设计好后，让子类继承并实现抽象类

4. 抽象类，是重点，在框架h和设计模式使用较多



#### 使用事项和细节

1. 抽象类不能实例化
2. 抽象类不一定要b包含 abstract 方法，**也就是说 ：抽象类可以 没有 abstract 方法**
   - 一旦类包含了 abstract 方法，**则这个类必须声明为 abstract**
3. abstract 只能修饰 类 和 方法，不能修饰属性和其他的
4. 抽象类可以有任何成员（**抽象类还是类**），比如：非抽象方法，构造器，静态属性
5. 抽象方法，不能有主体，即不能实现
6. 如果一个类继承了 抽象 类，则他必须 实现抽象类 的所有抽象方法，除非 他自己也声明为  abstract 类    **所谓实现，就是要有方法体**
7. 抽象方法不能使用 **private 、final、static **来修饰，因为这些关键字 都是和重写相违背的



### 接口

---

> **接口就是给出一些没有实现的方法，封装到一起，到某个类要使用时，再根据具体的情况把这些方法写出来**



#### 语法

```java
interface 接口名{
 // 属性
 // 抽象方法
}

class 类名 implements 接口 {
 //自己的属性;
 //自己的方法;
 //必须实现的借口的抽象方法
}
```



> ###### **小结：** 借口是更加抽象的抽象类，抽象类里的方法可以有方法体，接口里的所有方法都没有方法体【jdk 7.0】。接口体现了程序设计的多态和高内聚低耦合的设计思想

**特别说明：** Jdk 8.0 后接口类可以有静态方法，默认方法，也就是说接口中可以有方法的具体实现



#### 注意事项和细节

1. 接口**不能被实例化**
2. 接口中的所有方法是 public 方法，接口中抽象方法，可以不用 abstract 修饰
3. 一个普通类实现接口，就必须将该借口的所有方法都实现
4. 抽象类实现接口，可以不用实现接口的方法
5. 一个类同是**可以实现多个接口**
6. 接口中的属性，只能是 **final** 的，而且是 **public static final** 修饰符
7. 接口属性的访问形式 ： **接口名.属性名**
8. **接口中不能继承其他类**，但是可以继承多个接口
9. 接口的修饰符，只能是 **public 默认**，这点和类的修饰符是一样的  



#### 实现接口 vs 继承类

- **接口和继承解决的问题不同**

  - 继承的价值主要在于 ：**解决代码的复用性和可维护性**

  - 接口的价值主要在于： **设计，设计好各种规范（方法），让其他类去实现这些方法。即更加的灵活**

- **接口比继承更加灵活**

  - 接口比继承更加灵活，继承是满足  is - a 的关系，而接口只需满足 like - a 的关系。

- **接口在一定程度上实现代码解耦【即： 接口规范性 + 动态绑定机制】**



#### 接口的多态性

##### 	多态参数 

```java
public class InterfacePolyParameter {
    public static void main(String[] args) {
        //接口的多态体现
        //接口类型的变量 if01 可以指向 实现了 IF 接口类的对象实例
        IF if01 = new Monster();
        if01 = new Car();
        //继承体现的多态
        //父类类型的变量 a 可以指向 继承 AAA 的子类的对象实例
        AAA a = new BBB();
        a = new CCC();
	}
}
    interface IF {}
    class Monster implements IF{}
    class Car implements IF{}
    class AAA {
}
    class BBB extends AAA {}
    class CCC extends AAA {}
}
```



##### 	多态数组

```java
public class InterfacePolyArr {
	public static void main(String[] args) {
	//多态数组 -> 接口类型数组
	Usb[] usbs = new Usb[2];
	usbs[0] = new Phone_();
	usbs[1] = new Camera_();
	/*
	给 Usb 数组中，存放 Phone 和 相机对象，Phone 类还有一个特有的方法 call（），
	请遍历 Usb 数组，如果是 Phone 对象，除了调用 Usb 接口定义的方法外，
	还需要调用 Phone 特有方法 call
	*/
	for(int i = 0; i <usbs.length; i++) {
	sbs[i].work();//动态绑定.. //和前面一样，我们仍然需要进行类型的向下转型
	if(usbs[i] instanceof Phone_) {//判断他的运行类型是 Phone_
		((Phone_) usbs[i]).call();
			}
		}
	}
}
interface Usb{
	void work();
}

class Phone_ implements Usb {
	public void call() {
	System.out.println("手机可以打电话...");
}
	@Override
	public void work() {
	System.out.println("手机工作中...");
	}
}
	class Camera_ implements Usb {

		@Override
    	public void work() {
        System.out.println("相机工作中...");
	}
}
```



##### 	接口的多态传递现象 

```java
/**
* 演示多态传递现象
*/
public class InterfacePolyPass {

	public static void main(String[] args) {
	//接口类型的变量可以指向，实现了该接口的类的对象实例
	IG ig = new Teacher();
	//如果 IG 继承了 IH 接口，而 Teacher 类实现了 IG 接口
	//那么，实际上就相当于 Teacher 类也实现了 IH 接口. //这就是所谓的 接口多态传递现象. IH ih = new Teacher();
	}
}
interface IH {
	void hi();
}

interface IG extends IH{ }

class Teacher implements IG
    @Override
	public void hi() {
	}
}
```



###  内部类

---

#### 基本介绍

> 一个类的内部完整的嵌套了另一个类结构。**被嵌套的类成为内部类（inner class）**，**嵌套其他类的类统称外部类（outer class）**，是我们类的第五大成员
>
> 内部类最大的特点就是 **可以直接访问私有属性，并且可以体现类与类之间的包含关系**
>
> 注意：**内部类是学习的难点，同时也是重点，底层源码里有大量内部类**



#### 基本语法

---

> ```java
> class Outer{
> class Inner{
> 
> }
> }
> 
> class Other{
> 
> }
> ```



> ###### 示例

```java
public class InnerClass01 { //外部其他类
public static void main(String[] args) {
	}
}
class Outer { //外部类

	private int n1 = 100;//属性

	public Outer(int n1) {//构造器
		this.n1 = n1;
	}

	public void m1() {//方法
		System.out.println("m1()");
	}
	{//代码块
		System.out.println("代码块...");
	}
	class Inner { //内部类, 在 Outer

 }
}
```





#### 内部类的分类

- 定义在外部类局部位置上（比如方法内）：
  1. 局部内部类（有类名）
  2. **匿名内部类（没有类名，重点）**
- 定义在外部类成员位置上：
  1. 成员内部类（没用 static 修饰）
  2. 静态内部类（使用 static 修饰）



#### 局部内部类

---

> **说明：** 局部内部类是定义在外部类的局部位置，比如方法中，并且**有类名**
>
> 1. 可以直接访问外部类 的**所有成员**，包括私有的
>
> 2. 不能添加访问修饰符，因为他的地位就是一个局部变量。局部变量是不能使用访问修饰符的。**但是可以用 final 修饰，**因为局部变量也可以使用 final
>
> 3. 作用域：**仅仅在定义它的方法或代码块中**
>
> 4. 局部内部类 --- 访问 --- > 外部类的成员[访问方式：**直接访问**]
>
> 5. 外部类 --- 访问 ---> 局部内部类的成员  **访问方式： 创建对象再访问（注意：必须在作用域内）**  
>
>    1. 局部内部类定义在方法/代码块中
>    2. 作用域在方法体，或者代码块中
>    3. 本质仍然是一个类
>
> 6. 外部其他类 --- 不能访问 --- > 局部内部类（**因为局部内部类地位是一个局部变量）**
>
> 7. 如果外部类和局部内部类的**成员重名时**，默认遵循**就近原则**，**如果想访问外部类的成员，则可以使用（外部类.this.成员）去访问**
>
>    > ###### **Outer.this 本质就是 外部类的对象**，即哪个对象调用了方法，Outer.this 就指向哪个对象
>
> ```java
> /**
> * 演示局部内部类的使用
> */
> public class LocalInnerClass {//
> 
> 	public static void main(String[] args) {
> 	//演示一遍
> 	Outer02 outer02 = new Outer02();
> 	outer02.m1();
> 	System.out.println("outer02 的 hashcode=" + outer02);
> 	}
> }
> 	class Outer02 {//外部类
> 
> 		private int n1 = 100;
> 		private void m2() {
> 		System.out.println("Outer02 m2()");
> 	}//私有方法
> 
> 		public void m1() {//方法
> 		//1.局部内部类是定义在外部类的局部位置,通常在方法
> 		//3.不能添加访问修饰符,但是可以使用 final 修饰
> 		//4.作用域 : 仅仅在定义它的方法或代码块中
> 		final class Inner02 {//局部内部类(本质仍然是一个类)
> 		//2.可以直接访问外部类的所有成员，包含私有的
> 		private int n1 = 800;
> 		public void f1() {
> 		//5. 局部内部类可以直接访问外部类的成员，比如下面 外部类 n1 和 m2()
> 		//7. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，
> 		// 使用 外部类名.this.成员）去访问
> 		// 老韩解读 Outer02.this 本质就是外部类的对象, 即哪个对象调用了 m1, Outer02.this 就是哪个对象
> 		System.out.println("n1=" + n1 + " 外部类的 n1=" + Outer02.this.n1);
> 		System.out.println("Outer02.this hashcode=" + Outer02.this);
> 		m2();
> 	}
> }
> 		//6. 外部类在方法中，可以创建 Inner02 对象，然后调用方法即可
> 		Inner02 inner02 = new Inner02();
> 	inner02.f1();
> 	}
> }
> ```

 

#### 匿名内部类

---

> **1.本质是类   2.内部类    3.该类没有名字     4.同时还是对象**
>
> **说明：** 匿名内部类是定义在外部类的局部位置，比如方法中，并且没有名字



##### 基本语法

---

> ```java
> new 类/接口(参数列表){
> 	//类体
> };
> ```

> ###### **案例演示**

```java
/**
* 演示匿名内部类的使用
*/
public class AnonymousInnerClass {
    
	public static void main(String[] args) {
	Outer04 outer04 = new Outer04();
	outer04.method();
	}
}
class Outer04 { //外部类
    
	private int n1 = 10;//属性
	public void method() {//方法	
	//基于接口的匿名内部类
	//解读
	//1.需求： 想使用 IA 接口,并创建对象
	//2.传统方式，是写一个类，实现该接口，并创建对象
	//3.需求是 Tiger/Dog 类只是使用一次，后面再不使用
	//4. 可以使用匿名内部类来简化开发
	//5. tiger 的编译类型 ? IA
	//6. tiger 的运行类型 ? 就是匿名内部类 Outer04$1	
    /*
    我们看底层 会分配 类名 Outer04$1
    class Outer04$1 implements IA {
    @Override
    public void cry() {
    System.out.println("老虎叫唤...");
    }
    }
    */
    //7. jdk 底层在创建匿名内部类 Outer04$1,立即马上就创建了 Outer04$1 实例，并且把地址
    // 返回给 tiger
    //8. 匿名内部类使用一次，就不能再使用
	IA tiger = new IA() {
	@Override
	public void cry() {
	System.out.println("老虎叫唤...");
	}
};
	System.out.println("tiger 的运行类型=" + tiger.getClass());
	tiger.cry();
	tiger.cry();
	tiger.cry();
    // IA tiger = new Tiger();
    // tiger.cry();
    //演示基于类的匿名内部类
    //分析
    //1. father 编译类型 Father
    //2. father 运行类型 Outer04$2
    //3. 底层会创建匿名内部类
    /*
    class Outer04$2 extends Father{
    @Override
    public void test() {
    System.out.println("匿名内部类重写了 test 方法");
    }
    }
    */
    //4. 同时也直接返回了 匿名内部类 Outer04$2 的对象
    //5. 注意("jack") 参数列表会传递给 构造器
	Father father = new Father("jack"){
	@Override
	public void test() {
	System.out.println("匿名内部类重写了 test 方法");
	}
};
    System.out.println("father 对象的运行类型=" + father.getClass());//Outer04$2
    father.test();
	//基于抽象类的匿名内部类
    Animal animal = new Animal(){
        
    @Override
    void eat() {
    	System.out.println("小狗吃骨头...");
    }
    };
    animal.eat();
    }
 }
    interface IA {//接口
        
    	public void cry();
    }
    //class Tiger implements IA {
    //
    // @Override
    // public void cry() {
    // System.out.println("老虎叫唤...");
    // }
    //}
    //class Dog implements IA{
    // @Override
    // public void cry() {
    // System.out.println("小狗汪汪...");
    // }
    //}
    class Father {//类
        
    	public Father(String name) {//构造器
    	System.out.println("接收到 name=" + name);
    	}
    	public void test() {//方法
    	}
    }
    abstract class Animal { //抽象类
        
    	abstract void eat();
    }
```



##### 细节

- 匿名内部类即是**一个类的定义**，同时它本身**也是一个对象**，因此从语法上看，它**即有定义类的特征，也有创建对象的特征**，因此可以调用匿名内部类的方法
- 可以直接访问外部类的所有成员，包括私有的
- **不能添加访问修饰符**，因为他本身就是一个局部变量
- 作用域 ： 仅仅在定义他的方法或代码块中
- 局部内部类 --- 访问 --- > 外部类的成员[访问方式：**直接访问**]
- 外部类 --- 访问 ---> 局部内部类的成员  **访问方式： 创建对象再访问（注意：必须在作用域内）**  

  1. 局部内部类定义在方法/代码块中
  2. 作用域在方法体，或者代码块中
  3. 本质仍然是一个类
- 外部其他类 --- 不能访问 --- > 局部内部类（**因为局部内部类地位是一个局部变量）**
- 如果外部类和局部内部类的**成员重名时**，默认遵循**就近原则**，**如果想访问外部类的成员，则可以使用（外部类.this.成员）去访问**

```java
public class AnonymousInnerClassDetail {
 public static void main(String[] args) {

     Outer05 outer05 = new Outer05();
     outer05.f1();
     //外部其他类---不能访问----->匿名内部类
     System.out.println("main outer05 hashcode=" + outer05);
 }
}

class Outer05 {
 private int n1 = 99;
 public void f1() {
     //创建一个基于类的匿名内部类
     //不能添加访问修饰符,因为它的地位就是一个局部变量
     //作用域 : 仅仅在定义它的方法或代码块中
     Person p = new Person(){
         private int n1 = 88;
         @Override
         public void hi() {
             //可以直接访问外部类的所有成员，包含私有的
             //如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，
             //默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.this.成员）去访问
             System.out.println("匿名内部类重写了 hi方法 n1=" + n1 +
                     " 外部内的n1=" + Outer05.this.n1 );
             //Outer05.this 就是调用 f1的 对象
             System.out.println("Outer05.this hashcode=" + Outer05.this);
         }
     };
     p.hi();//动态绑定, 运行类型是 Outer05$1

     //也可以直接调用, 匿名内部类本身也是返回对象
     // class 匿名内部类 extends Person {}
//        new Person(){
//            @Override
//            public void hi() {
//                System.out.println("匿名内部类重写了 hi方法,哈哈...");
//            }
//            @Override
//            public void ok(String str) {
//                super.ok(str);
//            }
//        }.ok("jack");


 }
}

class Person {//类
 public void hi() {
     System.out.println("Person hi()");
 }
 public void ok(String str) {
     System.out.println("Person ok() " + str);
 }
}
//抽象类/接口...
```





##### 实践

> **当作实参直接传递，简洁高效**
>
> ```java
> public class InnerClassExercise {
> 
> public static void main(String[] args) {
>   CellPhone cellPhone = new CellPhone();
> 
>   // 匿名内部类
>   cellPhone.alarmClock(new Bell() {
>                            @Override
>                            public void ring() {
>                                System.out.println("lalalala");
>                            }
>                        }
> 
>   );
> 
>   // 传统方法
>   phone phone = new phone();
>   cellPhone.alarmClock(new phone());
> 
> }
> public static void f1(Bell bell){bell.ring();}
> }
> interface Bell{
> void ring();
> }
> class CellPhone{
> public void alarmClock(Bell bell){
>   bell.ring();
> }
> }
> class phone implements Bell{
> @Override
> public void ring() {
>   System.out.println("wuwuwuwu");
> }
> }
> ```
>
> 





#### 成员内部类

> **成员内部类是定义在外部类 的成员位置，并且没有 static 修饰**
>
> - 可以直接访问外部类的所有成员，包括私有的
> - **可以添加任何修饰符(public、protected、默认、private)，因为他的地位就是成员**

> ```java
> public class InnerClass {
> 
>  public static void main(String[] args) {
>      Outer outer = new Outer();
>      Outer.Inner.f2();
>      outer.f3();
>  }
>   class Outer{
>      public int  a = 10;
> 
>      public void f1(){
> 
>      }
> 
>      class Inner{
>      public void f2(){
>          System.out.println(a);
>      }}
>      public void f3(){
>          Inner inner = new Inner();
>          inner.f2();
>      }
>  }
> }
> ```



##### 细节

> - 可以直接访问外部类的所有成员，包括私有的
>
> - **可以添加任何修饰符(public、protected、默认、private)，因为他的地位就是成员**
>
> - 作用域 : 是整个类体
>
> - 成员内部类 --- 访问 --- 外部类成员 （比如 属性） 【直接访问】
>
> - 外部类 --- 访问 --- 内部类 【先创建对象，再访问】
>
> - 外部其他类 --- 访问 --- 成员内部类
>
>   - ```java
>     Outer.Inner inner = outer.new Inner();
>     ```
>
>     > 相当于把 new Inner(); 当作outer 的成员
>
> 
>
>   - **在外部类中，编写一个方法，可以返回 Inner对象**
>
>     ```java
>     public Inner getInnerInstance(){
>         return new Inner();
>     }
>     ```
>
> - 如果外部类和内部类的成员重名时，内部类访问的话，默认遵守就近原则，如果想访问外部类的成员，则可以使用（外部类.this.成员）去访问



#### 静态内部类

> **静态内部类s是定义在外部类的成员位置，并且有 static 修饰**



##### 细节

> 1. 可以直接访问外部类的所有静态成员，包括私有的，但不能访问非静态成员
>
> 2. 可以添加任意访问修饰符，因为他的地位就是一个成员
>
> 3. 作用域 ：  同其他成员，为整个类体
>
> 4. 静态内部类 --- 访问 --- 外部类 （比如静态属性） 【访问方式 ： 直接访问所有静态成员】
>
> 5. 外部类 --- 访问 --- 静态内部类 【访问方式 ： 创建对象，再访问】
>
> 6. 外部其他类 --- 访问 --- 静态内部类
>
>    -  因为静态内部类，是可以通过类名直接访问(前提是满足访问权限)
>
>    ```java
>    Outer.Inner inner = new Outer.Inner();
>    inner.f1();
>    ```
>
> 
>
>    - 通过构造方法来返回一个 Inner 的 对象实例
>
>      ```java
>      public static inner getInnerInstance (){
>          return new Inner();
>      }
>                                              
>      Outer.Inner inner = Outer.gerInnerInstance();
>      ```
>
> 
>
> 7. 如果外部类和静态内部类的成员重名时，静态内部类访问时遵循就近原则，如果想访问外部类的成员，则可以用（外部类.成员）去访问
>
> ```java
> public class StaticInnerClass {
>     public static void main(String[] args) {
>         Outer10 outer10 = new Outer10();
>         outer10.m1();
> 
>         //外部其他类 使用静态内部类
>         //方式1
>         //因为静态内部类，是可以通过类名直接访问(前提是满足访问权限)
>         Outer10.Inner10 inner10 = new Outer10.Inner10();
>         inner10.say();
>         //方式2
>         //编写一个方法，可以返回静态内部类的对象实例.
>         Outer10.Inner10 inner101 = outer10.getInner10();
>         System.out.println("============");
>         inner101.say();
> 
>         Outer10.Inner10 inner10_ = Outer10.getInner10_();
>         System.out.println("************");
>         inner10_.say();
>     }
> }
> 
> class Outer10 { //外部类
>     private int n1 = 10;
>     private static String name = "张三";
>     private static void cry() {}
>     //Inner10就是静态内部类
>     //1. 放在外部类的成员位置
>     //2. 使用static 修饰
>     //3. 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
>     //4. 可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
>     //5. 作用域 ：同其他的成员，为整个类体
>     static class Inner10 {
>         private static String name = "李四";
>         public void say() {
>             //如果外部类和静态内部类的成员重名时，静态内部类访问的时，
>             //默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.成员）
>             System.out.println(name + " 外部类name= " + Outer10.name);
>             cry();
>         }
>     }
> 
>     public void m1() { //外部类---访问------>静态内部类 访问方式：创建对象，再访问
>         Inner10 inner10 = new Inner10();
>         inner10.say();
>     }
> 
>     public Inner10 getInner10() {
>         return new Inner10();
>     }
> 
>     public static Inner10 getInner10_() {
>         return new Inner10();
>     }
> }
> ```



## 枚举类与注解



### 枚举类

---

> **枚举是一组常量的集合，可以这样理解：枚举属于一种特殊的类，里面只包含一组有限的特定的对象**



#### 枚举的实现方式

> - 自定义类实现枚举
> - 使用 enum 关键字实现枚举



#### 自定义类实现枚举

> - 不需要提供 setXxx 方法，因为枚举类对象值通常为只读
> - 对枚举对象使用 static + final 共同修饰，实现底层优化
> - 枚举对象名通常使用全部大写，常量的命名规范
> - 枚举对象根据需要，也可以有多个属性
>
> ```java
> public class Enumeration02 {
> 	public static void main(String[] args) {
> 		System.out.println(Season.AUTUMN);
> 		System.out.println(Season.SPRING);
> 	}
> }
> 
> //演示字定义枚举实现
> class Season {//类
> 	private String name;
> 	private String desc;//描述
> 	//定义了四个对象, 固定. public static final Season SPRING = new Season("春天", "温暖");
> 	public static final Season WINTER = new Season("冬天", "寒冷");
>     public static final Season AUTUMN = new Season("秋天", "凉爽");
>     public static final Season SUMMER = new Season("夏天", "炎热");
>     //1. 将构造器私有化,目的防止 直接 new
>     //2. 去掉 setXxx 方法, 防止属性被修改
>     //3. 在 Season 内部，直接创建固定的对象
> 	//4. 优化，可以加入 final 修饰符
>     private Season(String name, String desc) {
>     this.name = name;
>     this.desc = desc;
> }
>     public String getName() {
> 
> 		return name;
> 	}
> 
> 	public String getDesc() {
> 
> 		return desc;
> }
>     @Override
>     public String toString() {
> 
>     	return "Season{" +
>     		"name='" + name + '\'' +
>     		", desc='" + desc + '\'' +
>     		'}';
>     }
> }
> ```



> ###### 小结：
>
> 1. 构造器私有化
> 2. 本类内部创建一组对象
> 3. 对外暴露对象（通过为对象 添加  public static final 修饰符）
> 4. 可以提供 get  方法，但不要提供 set 方法



#### 3.enum 关键字实现枚举

##### 语法

> 1. 使用关键字  enum 代替 class 
> 2. public static final class Season SPRING = new Season("春天"，"温暖") ；  -> SPRING("春天"，"温暖")；
> 3. 如果有多个常量（对象），使用 ， 隔开即可
> 4. 如果使用 enum 来实现枚举，要求将定义常量对象，写在前面



##### 注意事项

> 1. 当我们使用 enum 关键字开发一个枚举类时，默认会继承Enum 类，而且是一个 **final 类**
> 2. 传统的 public static final Season SPRING = new Season（"春天"，"温暖"）；  简化成SPRING（"春天"，"温暖"),**这里必须知道，它调用的是哪个构造器**
> 3. 如果使用**无参构造器** 创建 枚举对象，则**实参列表和小括号都可以省略**
> 4. 当有多个枚举对象时，**使用 ， 间隔**，最后有一个**分号结尾**
> 5. **枚举对象必须放在枚举类的行首**



#### 4.  enum 成员方法

##### 1.toString 

> Enum 类已经重写过了，返回的是当前对象名，子类可以重写该方法，用于返回对象的属性信息

##### 2.name

> 返回当前对象名（常量名），子类中不能重写

##### 3.ordinal 

> 返回当前对象的位置号，默认从 0 开始

##### 4.values

> 返回当前枚举类的所有的常量

##### 5.valueOf

> 将字符串转换成 枚举对象，要求字符串必须为 已有的常量名 ，否则报异常

##### 6.compareTo

> 比较两个枚举常量，比较的就是位置号



#### 5. enum 实现接口

---

> **使用 enum 关键字后，就不能再继承其他类了，因为 enum 会隐式继承 Enum ,而 Java 是单继承机制**

> 枚举类和普通类一样，可以实现接口，形式如下：
>
> ```java
> enum 类名 implements 接口1，接口2{
> }
> ```



### 注解

---

> **注解（Annotation）也被成为元数据（MeteData)，用于修饰解释 包、类、方法、属性、构造器、局部变量等数据信息**
>
> 和注释一样，注解不影响程序逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息
>
> 在 JavaSE 中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE 中 注解占据了重要角色，例如用来配置应用程序的任何切面，代替JavaEE j旧版中所遗留的繁冗代码和 XML 配置



#### 基本的 Annotation 介绍

> **使用 Annotation  时要在其前面增加 @ 符号，并把该 Annotation 当成一个修饰符使用。用于修饰它支持的程序元素**



##### 	三个基本的 Annotation

###### 	@Override 

> 限定某个方法，是重写父类方法，该注解只能用于方法

> ```java
> //1. @Override 注解放在 fly 方法上，表示子类的 fly 方法时重写了父类的 fly
> //2. 这里如果没有写 @Override 还是重写了父类 fly
> //3. 如果你写了@Override 注解，编译器就会去检查该方法是否真的重写了父类的
> // 方法，如果的确重写了，则编译通过，如果没有构成重写，则编译错误
> //4. 看看 @Override 的定义
> // 解读： 如果发现 @interface 表示一个 注解类
>  /*
>  @Target(ElementType.METHOD)
>  @Retention(RetentionPolicy.SOURCE)
>  public @interface Override {
>  }
>  */
> ```
>
> > **@Target 是修饰注解的注解，称为元注解**



###### @Deprecated 

> 用于表示某个程序元素（类、方法等）**已过时**

> ```java
> @Deprecated 说明
> /*
> 1.用于表示某个程序元素（方法、类） 已过时
> 2.可以修饰方法、类、字段、包、参数 等等
> 3.@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE}
> 4.@Deprecated 的作用可以做到新旧版本的兼容和过渡
> */
> 
> /*
> @Documented
> @Retention(RetentionPolicy.RUNTIME)
> @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
> public @interface Deprecated {
> }
> */
> ```



###### @SuppressWarnings 

> **抑制编译器警告**

> ```java
> @SuppressWarnings({"rawtypes", "unchecked", "unused"})
> public class SuppressWarnings_ {
> 
> //1. 当我们不希望看到这些警告的时候，可以使用 SuppressWarnings 注解来抑制警告信息
> //2. 在{""} 中，可以写入你希望抑制(不显示)警告信息
> 
> //3. 可以指定的警告类型有
> 
>      // all，抑制所有警告
>      // boxing，抑制与封装/拆装作业相关的警告
>      // //cast，抑制与强制转型作业相关的警告
>      // //dep-ann，抑制与淘汰注释相关的警告
>      // //deprecation，抑制与淘汰的相关警告
>      // //fallthrough，抑制与 switch 陈述式中遗漏 break 相关的警告
>      // //finally，抑制与未传回 finally 区块相关的警告
>      // //hiding，抑制与隐藏变数的区域变数相关的警告
>      // //incomplete-switch，抑制与 switch 陈述式(enum case)中遗漏项目相关的警告
>             // //javadoc，抑制与 javadoc 相关的警告
>      // //nls，抑制与非 nls 字串文字相关的警告
>     // //null，抑制与空值分析相关的警告
>      // //rawtypes，抑制与使用 raw 类型相关的警告
>     // //resource，抑制与使用 Closeable 类型的资源相关的警告
>      // //restriction，抑制与使用不建议或禁止参照相关的警告
>      // //serial，抑制与可序列化的类别遗漏 serialVersionUID 栏位相关的警告
>      // //static-access，抑制与静态存取不正确相关的警告
>      // //static-method，抑制与可能宣告为 static 的方法相关的警告
>      // //super，抑制与置换方法相关但不含 super 呼叫的警告
>      // //synthetic-access，抑制与内部类别的存取未最佳化相关的警告
>      // //sync-override，抑制因为置换同步方法而遗漏同步化的警告
>      // //unchecked，抑制与未检查的作业相关的警告
>                          // //unqualified-field-access，抑制与栏位存取不合格相关的警告
>      // //unused，抑制与未用的程式码及停用的程式码相关的警告
> ```
>
> 
>
>
> ```java
> //4. 关于 SuppressWarnings 作用范围是和你放置的位置相关
> 
>  // 比如 @SuppressWarnings 放置在 main 方法，那么抑制警告的范围就是 main
> // 通常我们可以放置具体的语句, 方法, 类. 
> 
> //5. 看看 @SuppressWarnings 源码
> 
>  //(1) 放置的位置就是 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
>  //(2) 该注解类有数组 String[] values() 设置一个数组比如 {"rawtypes", "unchecked", "unused"}
>                          /*
>      @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
>      @Retention(RetentionPolicy.SOURCE)
>                          public @interface SuppressWarnings {
>      String[] value()
>                          }
>  */
>  	public static void main(String[] args) {
>          List list = new ArrayList();
>          list.add("jack");
>          list.add("tom");
>          list.add("mary");
>          int i;
>          System.out.println(list.get(1));
>      }
>  	public void f1() {
>          // @SuppressWarnings({"rawtypes"})
>          List list = new ArrayList();
>          list.add("jack");
>          list.add("tom");
>          list.add("mary");
>          // @SuppressWarnings({"unused"})
>          int i;
>          System.out.println(list.get(1));
>  	}
>  }
> ```



#### 元注解

> **JDK 的元 Annotation 用于修饰其他 Annotation** 



##### 元注解的种类

###### Retention  

> 指定注解的作用范围，三种 SOURCE 、CLASS、RUNTIME

> ```java
> /*说明
> 只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 可以保留多长时间, @Rentention 包含一个 RetentionPolicy
> 类型的成员变量, 使用 @Rentention 时必须为该 value 成员变量指定值:
> @Retention 的三种值
> 1) RetentionPolicy.SOURCE: 编译器使用后，直接丢弃这种策略的注释
> 2) RetentionPolicy.CLASS: 编译器将把注解记录在 class 文件中. 当运行 Java 程序时, JVM 不会保留注解。 这是默认
> 值
> 3) RetentionPolicy.RUNTIME:编译器将把注解记录在 class 文件中. 当运行 Java 程序时, JVM 会保留注解. 程序可以
> 通过反射获取该注解
> */
> ```



###### Target 

> 指定注解可以在那些地方用

> ```java
> 用于修饰 Annotation 定义，用于指定被修饰的 Annotation 能用于那些程序元素。
> @Target 也包含一个名为 value 的成员变量
> ```



###### Documented 

> 指定该注解是否会在 javadoc 体现

> ```java
> 用于指定被该元注解修饰的 Annotation 类 将被 javadoc 工具提取成文档，即在生成文档时，可以看到该注解
> 说明： 定义为 Documented 的注解必须设置 Retention 为 RUNTIME
> ```



###### Inherited 

> 子类会继承父类注解

> ```java
> 被它修饰的 Annotation 将具有继承性，如果某个类使用了 被 Inherited 修饰的 Annotation ，则其子类将自动具有该 z
> ```





## 异常

> **Java 语言中，将程序执行中发生的不正常情况称为“异常”（开发过程中的语法错误和逻辑错误不算异常）**
>
> 
>
> **将该代码块  ->  选中  ->  ctrl + alt + t  ->  选中 try - catch**
>
> 如果进行了异常处理，那么即使出现了异常，程序可以继续执行



### 异常事件分类

---

#### Error(错误)

> Java 虚拟机无法解决的严重问题。 如：JVM 系统内部错误、资源耗尽等严重情况。比如 StackOverFlow [栈溢出]、OOM [out of memory], Error 是严重错误，程序会崩溃

#### **Exception**

> 其他因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如空指针访问，试图读取不存在的文件，网络连接中断，**Exception 分为两大类： 运行时异常【程序运行时，发生的异常】，编译时异常【编程时，编译器检查出来的异常】**



### 异常体系图

---

> 1. 异常分为两大类 ： 运行时异常、编译时异常
> 2. 运行时异常，编译器检查不出来，编译器不要求强制处置的异常。一般是指编程时的逻辑错误，是程序员应该避免其出现的异常， java.lang.RuntimeException 类及它的子类都是运行时异常
> 3. 对于运行时异常，可以不做处理，因为这类异常很普遍，若全处理可能会对程序的可读性和运行效率产生影响
> 4. 编译时异常，是编译器要求必须处理的异常



### 常见五大运行时异常

---

> **常见的运行时异常：**
>
> ​		**NullPointerException   空指针异常**
>
> ​		**ArithmeticEXception   数学运算异常**
>
> ​		**ArrayIndexOutOfBoundsException   数组下标越界异常**
>
> ​		**ClassCastException   类型转换异常**
>
> ​		**NumberFormatException   数字格式不正确异常** 



#### NullPointerException 

> **当应用程序试图在需要对象的地方使用 null 时，抛出该异常**
>
> ```java
> public static void main(String[] args) {
> 
> 	String name = null;
> 	System.out.println(name.length());
> }
> ```



#### ArithmeticEXception

>**当出现异常的运算条件时，抛出此异常。例如，一个整数“除以零”时，抛出此类的一个实例**



#### ArrayIndexOutOfBoundsException

>**用非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引**
>
>```java
>public static void main(String[] args) {
>
>int[] arr = {1,2,4};
>for (int i = 0; i <= arr.length; i++) {
>System.out.println(arr[i]);
>}
>```



#### ClassCastException

>**当试图将对象强制转换为不是实例的子类时，抛出该异常**
>
>```java
>public static void main(String[] args) {
>A b = new B(); //向上转型
>B b2 = (B)b;//向下转型，这里是 OK
>C c2 = (C)b;//这里抛出 ClassCastException
>}
>```



#### NumberFormatException

>**当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常**
>
>```java
>public static void main(String[] args) {
>
>String name = "csq";
>//将 String 转成 int
>int num = Integer.parseInt(name);//抛出 NumberFormatException
>System.out.println(num);//1234
>}
>```



### 编译异常

---

> **编译异常是指在编译期间，就必须处理的异常，否则代码不能通过编译**



#### 常见的编译异常

##### SQLException

> 操作数据库时，查询表可能发生异常**



##### IOException

> 操作文件时，发生的异常



##### FileNotFoundException

> 当操作一个不存在的文件时，发生异常



##### ClassNotFoundException

> 加载类，而该类不存在时，异常



##### EOFException

> 操作文件，到文件末尾，发生异常



##### lllegalArguementException

> 参数异常





### 异常处理

---

> **异常处理就是异常发生时，对异常的处理方式**



#### 异常处理方式

##### try  -  catch  -  finally

> 程序员在代码中捕获发生的异常，自行处理
>
> ```java
> try{
> 	//代码可能有异常
> }catch(Exception e){
> 
> //捕获到异常
>  //1当异常发生时
> //2.系统将异常封装成Exception对象e,传递给catch
> 	//3.得到异常对象后，程序员，自己处理
> 	//4.注意，如果没有发生异常catch代码块不执行
> }finally{
> 
>                      	//不管ty代码块是否有异常发生，始终要执行finally
>  //所以通常将释放资源的代码，放在 finally 里
> }
> ```



##### throws

> 将发生的异常抛出，交给调用者（方法）来处理，最顶级的处理者就是 **JVM**





#### try - catch

> **Java 提供 try 和 catch 块 来处理异常。try 块 用于包含出错的代码。catch 块 用于处理 try 块中发生的异常。可以根据需要在程序中有多个的 try- catch 块**



##### 基本语法

> ```java
> try {
> //可疑代码
> //将异常生成对应的异常对象，传递给 catch 块
> } catch(Exception e) {
> //对异常的处理
> }
> // 如果没有 finally ，语法也可以通过
> ```

 

##### 注意事项

> ###### 如果异常发生了，则异常发	生后面的代码不会执行，直接进入到 catch 块

> ###### 如果异常没有发生，则顺序执行 try 的代码块，不会进入到 catch

> ###### 如果希望不管是否发生异常，都执行某段代码（比如关闭连接，释放资源等），则使用 finally 

```java
public static void main(String[] args) {

//ctrl + atl + t
//1. 如果异常发生了，则异常发生后面的代码不会执行，直接进入到 catch 块
//2. 如果异常没有发生，则顺序执行 try 的代码块，不会进入到 catch
//3. 如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)则使用如下代码- finally
try {
    String str = "csq";
    int a = Integer.parseInt(str);
    System.out.println("数字：" + a);
} catch (NumberFormatException e) {
    System.out.println("异常信息=" + e.getMessage());
} finally {
    System.out.println("finally 代码块被执行...");
}
    System.out.println("程序继续...");
}
```



> ###### 可以**有多个 catch 语句**，捕获**不同的异常**(进行不同的业务处理)，**要求父类异常在后，子类异常在前**，比如（Exception  在后，NullPointerException 在前），**如果发生异常，只会匹配一个 catch**

```java
try{
    //
} catch(NullPointerException e){

} catch(Exception e){

} finally {

}
```



```java
public static void main(String[] args) {

//1.如果 try 代码块有可能有多个异常
//2.可以使用多个 catch 分别捕获不同的异常，相应处理
//3.要求子类异常写在前面，父类异常写在后面
try {
    Person person = new Person();
    //person = null;
    System.out.println(person.getName());//NullPointerException
    int n1 = 10;
    int n2 = 0;
    int res = n1 / n2;//ArithmeticException
} catch (NullPointerException e) {
    System.out.println("空指针异常=" + e.getMessage());
} catch (ArithmeticException e) {
    System.out.println("算术异常=" + e.getMessage());
} catch (Exception e) {
    System.out.println(e.getMessage());
} finally {
	}
}
}
```



> ###### 可以进行 try - finally 配合使用，这种用法**相当于没有捕获异常**，因此程序**会直接崩掉**，应用场景：就是执行一段代码，不管是否发生异常，都必须执行某个业务

```java
try{
    //代码
}
finally {
    //总是执行
}
```



##### 执行顺序总结

> 1. 如果没有出现异常，则执行 try 块中所有语句，不执行 catch 语句，如果有finally ，最后还需要执行finally 里面的语句
> 2. 如果出现异常，则 try 块中异常发生后，**try 块剩下的语句不再执行**。将执行 catch 里的语句，**如果有 finally ,最后还需要执行 finally  里面的语句**







#### throws

---

##### 基本介绍

> ###### 如果一个方法（中的语句执行时）可能生成某种异常，但是并不能确定如何处理这种异常，则此方法应显式的声明抛出异常，表明该方法将不对这些异常进行处理，而由该方法的调用者负责处理

> ###### 在方法声明中用 throws 语句可以声明抛出异常的列表，throws 后面的异常种类可以是方法中产生的异常类型，也可以是他的父类

> ###### 代码示例：

```java
public void f2() throws FileNotFoundException,NullPointerException,ArithmeticException{
    // 创建了一个文件流d对象
    //1.这里的异常是一个 FileNotFoundException 变异异常
    //2.使用 try - catch 
    //3.使用 throws 抛出异常，让调用 f2方法的调用者处理
    //4.throws 后面的异常类型可以是方法中产生的异常，也可以是他的父类
    //5.throws 后面也可以是一个异常列表，有多个异常
    FileInputStream fis = new FileInputStream(d://aa.txt);
}
```



##### 细节和注意事项

> ###### 对于编译异常，程序中必须处理，，比如 try - catch - finally  或者  throws 

> ###### 对于运行时异常，程序中如果没有处理，默认就是 throws 的方式处理

> ###### 子类重写父类方法时，对于抛出异常的规定 ： **子类所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常的类型的子类型**

> ###### 在 throws 过程中，如果有方法 try - catch - finally ,就相当于处理异常，就不必再  throws 

> ###### 代码示例：

```java
public class ThrowsDetail {
    public static void main(String[] args) {
    f2();
	}
    public static void f2() /*throws ArithmeticException*/ {
    //1.对于编译异常，程序中必须处理，比如 try-catch 或者 throws
    //2.对于运行时异常，程序中如果没有处理，默认就是 throws 的方式处理
    int n1 = 10;
    int n2 = 0;
    double res = n1 / n2;
	}
    public static void f1() throws FileNotFoundException {
    //调用 f3() 报错

    //1. 因为 f3() 方法抛出的是一个编译异常
    //2. 即这时，就要 f1() 必须处理这个编译异常
    //3. 在 f1() 中，要么 try-catch-finally ,或者继续 throws 这个编译异常
        f3(); // 抛出异常
	}
    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
    public static void f4() {

        //1. 在 f4()中调用方法 f5() 是 OK
        //2. 原因是 f5() 抛出的是运行异常
        //3. 而 java 中，并不要求程序员显示处理,因为有默认处理机制
        f5();
	}
    public static void f5() throws ArithmeticException {
	}
}
class Father { //父类
    public void method() throws RuntimeException {
    }
}
class Son extends Father {//子类
    //3. 子类重写父类的方法时，对抛出异常的规定:子类重写的方法，
    // 所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
    //4. 在 throws 过程中，如果有方法 try-catch , 就相当于处理异常，就可以不必 throws
    @Override
    public void method() throws ArithmeticException {
	}
}
```







#### 自定义异常

> **当程序中出现了某些错误，但该错误信息并没有在 Throwable 子类中描述处理，这个时候可以自己设计异常类，用于描述该错误信息**



##### 自定义异常步骤

> 1. 定义类： 自定义异常类名，继承 Exception 或者 RuntimeException 
> 2. 如果继承 Exception ，属于编译异常
> 3. 如果继承 RuntimeException ，属于运行异常（一般来说，继承 RuntimeException
>
> ```java
> public class CustomException {
>     public static void main(String[] args) /*throws AgeException*/ {
>         int age = 180;
>         //要求范围在 18 – 120 之间，否则抛出一个自定义异常
>         if(!(age >= 18 && age <= 120)) {
>             //这里我们可以通过构造器，设置信息
>             throw new AgeException("年龄需要在 18~120 之间");
>         }
>         System.out.println("你的年龄范围正确.");
>     }
> }
> //自定义一个异常
> //老韩解读
> //1. 一般情况下，我们自定义异常是继承 RuntimeException
> //2. 即把自定义异常做成 运行时异常，好处时，我们可以使用默认的处理机制
> //3. 即比较方便
> class AgeException extends RuntimeException {
>     public AgeException(String message) {//构造器
>         super(message);
> 	}
> }
> ```



#### throw 和 throws 区别

>|        | 意义                     | 位置       | 后面跟的东西 |
>| ------ | ------------------------ | ---------- | ------------ |
>| throws | 异常处理的一种方式       | 方法声明处 | 异常类型     |
>| throw  | 手动生成异常对象的关键字 | 方法体中   | 异常对象     |



## 常用类

### 包装类

---

> **针对八种基本数据类型相应的引用类型 - 包装类**
>
> 有了类的特点，就可以调用类中的方法
>
> | 基本数据类型 |    包装类     |
> | :----------: | :-----------: |
> | **boolean**  |  **Boolean**  |
> |   **char**   | **Character** |
> |   **byte**   |   **Byte**    |
> |  **short**   |   **Short**   |
> |   **int**    |  **Integer**  |
> |   **long**   |   **Long**    |
> |  **float**   |   **Float**   |
> |  **double**  |  **Double**   |



#### 包装类和基本数据的转换

> ##### jdk5 前的手动装箱和拆箱方式，装箱：基本类型 -> 包装类型 ，拆箱反之

> ##### jdk5 以后（含 jdk5) 的自动装箱和拆箱方式

> ##### 自动装箱底层调用的是 valueOf 方法，比如 Integer,valueOf();

> ##### 其他包装类的应用案例

```java
public static void main(String[] args) {
        //演示int <--> Integer 的装箱和拆箱
        //jdk5前是手动装箱和拆箱
        //手动装箱 int->Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱
        //Integer -> int
        int i = integer.intValue();

        //jdk5后，就可以自动装箱和自动拆箱
        int n2 = 200;
        //自动装箱 int->Integer
        Integer integer2 = n2; //底层使用的是 Integer.valueOf(n2)
        //自动拆箱 Integer->int
        int n3 = integer2; //底层仍然使用的是 intValue()方法
    }
```







#### 包装类型和 String 类型的相互转换

> ```java
> public static void main(String[] args) {
>      //包装类(Integer)->String
>      Integer i = 100;//自动装箱
>      //方式1
>      String str1 = i + "";
>      //方式2
>      String str2 = i.toString();
>      //方式3
>      String str3 = String.valueOf(i);
> 
>      //String -> 包装类(Integer)
>      String str4 = "12345";
>      Integer i2 = Integer.parseInt(str4);//使用到自动装箱
>      Integer i3 = new Integer(str4);//构造器
> 
>      System.out.println("ok~~");
> 
>  }
> ```



#### Integer 类

> ```java
> public static void main(String[] args) {
>      Integer i = new Integer(1);
>      Integer j = new Integer(1);
>      System.out.println(i == j);  //False
>      //所以，这里主要是看范围 -128 ~ 127 就是直接返回
>      /*
>      //1. 如果i 在 IntegerCache.low(-128)~IntegerCache.high(127),就直接从数组返回
>      //2. 如果不在 -128~127,就直接 new Integer(i)
>       public static Integer valueOf(int i) {
>          if (i >= IntegerCache.low && i <= IntegerCache.high)
>              return IntegerCache.cache[i + (-IntegerCache.low)];
>          return new Integer(i);
>      }
>       */
>      Integer m = 1; //底层 Integer.valueOf(1); -> 阅读源码
>      Integer n = 1;//底层 Integer.valueOf(1);
>      System.out.println(m == n); //T
>      //所以，这里主要是看范围 -128 ~ 127 就是直接返回
>      //，否则，就new Integer(xx);
>      Integer x = 128;//底层Integer.valueOf(1);
>      Integer y = 128;//底层Integer.valueOf(1);
>      System.out.println(x == y);//False
>  }
> ```
>
> 



### String 类

---

#### String  类的理解和创建对象

> 1. String 对象用于保存字符串，也是一组字符序列
> 2. 字符串常量对象是用双引号括起来的字符序列。例如 “你好” ， “12.97” ， “boy” 
> 3. 字符串的字符使用的是 **Unicode **字符编码，一个字符（不区分字母还是汉子）占两个字节。
> 4. String 类常用构造器
>    - String s1 = new String();
>    - String s2 = new String(String original);
>    - String s3 = new String(char[] a);
>    - String s4 = new String(char[] a,int startIndex,int count);
>
> ```java
> public class String01 {
>     public static void main(String[] args) {
> 
>     //1.String 对象用于保存字符串，也就是一组字符序列
>     //2. "jack" 字符串常量, 双引号括起的字符序列
>     //3. 字符串的字符使用 Unicode 字符编码，一个字符(不区分字母还是汉字)占两个字节
>     //4. String 类有很多构造器，构造器的重载
>     // 常用的有 String s1 = new String(); 
>     //String s2 = new String(String original);
>     //String s3 = new String(char[] a);
>     //String s4 = new String(char[] a,int startIndex,int count)
>     //String s5 = new String(byte[] b)
>     //5. String 类实现了接口 Serializable【String 可以串行化:可以在网络传输】
>     // 接口 Comparable [String 对象可以比较大小]
>     //6. String 是 final 类，不能被其他的类继承
>     //7. String 有属性 private final char value[]; 用于存放字符串内容
>     //8. 一定要注意：value 是一个 final 类型， 不可以修改(需要功力)：即 value 不能指向
>     // 新的地址，但是单个字符内容是可以变化
>     String name = "jack";
>     name = "tom";
>     final char[] value = {'a','b','c'};
>     char[] v2 = {'t','o','m'};
>     value[0] = 'H';
>     //value = v2; 不可以修改 value 地址
> }
> ```



#### 创建 String 对象的两种方式

> - **方式一 ：直接赋值 String s = "csq";**
> - **方式二 ： 调用构造器 String s = new String("csq");**

> ##### 两种方式的区别：
>
> - 方式一 ： 先从常量池查看是否有 “csq" 数据空间，如果有，直接指向，如果没有则重新创建，然后指向。s 最终指向的是常量池的空间地址
> - 方式二 ： 先在堆中创建空间，里面维护了 value 属性，指向常量池的 csq 空间。如果常量池中 没有 csq 则重新创建，如果有直接通过 value 指向，最终指向的是堆中的空间地址。



#### 字符串的特性

> 1. Sring 是一个 final 类，代表不可变的字符序列。
> 1. 字符串是不可变的，一个字符串对象一旦被分配，其内容是不可变的
>
> ```java
> public static void main(String[] args) {
>         String a = "hello"; //创建 a对象
>         String b = "abc";//创建 b对象
>         //1. 先 创建一个 StringBuilder sb = StringBuilder()
>         //2. 执行  sb.append("hello");
>         //3. sb.append("abc");
>         //4. String c= sb.toString()
>         //最后其实是 c 指向堆中的对象(String) value[] -> 池中 "helloabc"
>         String c = a + b;
>         String d = "helloabc";
>         System.out.println(c == d);//真还是假? 是false
>         String e = "hello" + "abc";//直接看池， e指向常量池
>         System.out.println(d == e);//真还是假? 是true
>     }
> ```
>
> ##### **重要规则：** **底层是 StringBuilder sb = new StringBuilder(); sb.append(a);  sb.append(b); sb 是在堆中，并且 append 是在原来字符串的基础上追加的** 
>
> **String c1 = "ab" + "cd";  常量相加，看的是池。  String c1 = a + b; 变量相加，是在堆中**



#### String 类常用的方法

> **字符串是保存字符串常量的。每次更新都需要重新开辟空间，效率极低，因此 Java 设计者还提供了  StringBuilder 和 StringBuffer 来增强String 的功能，并提高效率。**



##### 常见方法

###### equals   

> 区分大小写，判断内容是否相等



###### equalslgnoreCase   

> 忽略大小写的判断内容是否相等



###### length   

> 获取字符的个数，字符串的长度



###### indexof   

> 获取字符在字符串中第1次出现的索引，索引从0开始，如果找不到，返回-1



###### lastIndexOf   

> 获取字符在字符串中最后1次出现的索引，索引从0开始如找不到，返回-1



###### substring   

> 截取指定范围的子串



###### trim   

> 去前后空格



###### charAt   

> 获取某索引处的字符，注意不能使用Str[index]这种方式.



###### intern 

> 当调用 intern 方法时，如果池中已经包含一个d等于 此 String 对象的字符串(用 equals (object) 方法确定，则返回池中的字符串。否则，将此 String 对象添加到池中，并返回此 String 对象的引用)    **此方法最终返回的是 常量池中的地址（对象）**



> ###### 代码：

```java
public static void main(String[] args) {
        // 1.toUpperCase转换成大写
        String s = "heLLo";
        System.out.println(s.toUpperCase());//HELLO
    
        // 2.toLowerCase
        System.out.println(s.toLowerCase());//hello
    
        // 3.concat拼接字符串
        String s1 = "宝玉";
        s1 = s1.concat("林黛玉").concat("薛宝钗").concat("together");
        System.out.println(s1);//宝玉林黛玉薛宝钗together
    
        // 4.replace 替换字符串中的字符
        s1 = "宝玉 and 林黛玉 林黛玉 林黛玉";
        //在s1中，将 所有的 林黛玉 替换成薛宝钗
        //  s1.replace() 方法执行后，返回的结果才是替换过的.
        // 注意对 s1没有任何影响
        String s11 = s1.replace("宝玉", "jack");
        System.out.println(s1);//宝玉 and 林黛玉 林黛玉 林黛玉
        System.out.println(s11);//jack and 林黛玉 林黛玉 林黛玉
    
        // 5.split 分割字符串, 对于某些分割字符，我们需要 转义比如 | \\等
        String poem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        //
        // 1. 以 , 为标准对 poem 进行分割 , 返回一个数组
        // 2. 在对字符串进行分割时，如果有特殊字符，需要加入 转义符 \
        String[] split = poem.split(",");
        poem = "E:\\aaa\\bbb";
        split = poem.split("\\\\");
        System.out.println("==分割后内容===");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    
        // 6.toCharArray 转换成字符数组
        s = "happy";
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]);
        }
    
        // 7.compareTo 比较两个字符串的大小，如果前者大，
        // 则返回正数，后者大，则返回负数，如果相等，返回0
        // 解读
        // (1) 如果长度相同，并且每个字符也相同，就返回 0
        // (2) 如果长度相同或者不相同，但是在进行比较时，可以区分大小
        //     就返回 if (c1 != c2) {
        //                return c1 - c2;
        //            }
        // (3) 如果前面的部分都相同，就返回 str1.len - str2.len
        String a = "jcck";// len = 3
        String b = "jack";// len = 4
        System.out.println(a.compareTo(b)); // 返回值是 'c' - 'a' = 2的值
    
		// 8.format 格式字符串
        /* 占位符有:
         * %s 字符串 %c 字符 %d 整型 %.2f 浮点型
         *
         */
        String name = "john";
        int age = 10;
        double score = 56.857;
        char gender = '男';
        //将所有的信息都拼接在一个字符串.
        String info =
                "我的姓名是" + name + "年龄是" + age + ",成绩是" + score + "性别是" + gender + "。希望大家喜欢我！";

        System.out.println(info);


        //解读
        //1. %s , %d , %.2f %c 称为占位符
        //2. 这些占位符由后面变量来替换
        //3. %s 表示后面由 字符串来替换
        //4. %d 是整数来替换
        //5. %.2f 表示使用小数来替换，替换后，只会保留小数点两位, 并且进行四舍五入的处理
        //6. %c 使用char 类型来替换
        String formatStr = "我的姓名是%s 年龄是%d，成绩是%.2f 性别是%c.希望大家喜欢我！";

        String info2 = String.format(formatStr, name, age, score, gender);

        System.out.println("info2=" + info2);
    }
```



 

#### StringBuffer 类

> **java.lang.StringBuffer 代表可变的字符序列，可以对字符串序列内容进行删减。**
>
> 很多方法与 String 相同，但 StringBuffer 是可变长度的。
>
> StringBuffer 是一个容器。



##### 基础内容

> - Stringbuffer 是 final 类
> - 实现了 Serializable 接口，可以保存到文件，或文件传输
> - 继承了抽象类 AbstractStringBuider 
> - AbstractStringBuilder 属性  char[] value,存放的字符序列
>
> ```java
> public static void main(String[] args) {
> 
>     //1. StringBuffer 的直接父类 是 AbstractStringBuilder
>     //2. StringBuffer 实现了 Serializable, 即 StringBuffer 的对象可以串行化
>     //3. 在父类中 AbstractStringBuilder 有属性 char[] value,不是 final
>     // 该 value 数组存放 字符串内容，引出存放在堆中的
>     //4. StringBuffer 是一个 final 类，不能被继承
>     //5. 因为 StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)
>     // 不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String
>     StringBuffer stringBuffer = new StringBuffer("hello");
> }
> ```



##### StringBuffer 构造器的使用

```java
public static void main(String[] args) {

        //构造器的使用
        //解读
        //1. 创建一个 大小为 16的 char[] ,用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();

        //2 通过构造器指定 char[] 大小
        StringBuffer stringBuffer1 = new StringBuffer(100);
        //3. 通过 给一个String 创建 StringBuffer, char[] 大小就是 str.length() + 16

        StringBuffer hello = new StringBuffer("hello");

    }
```



##### String 与 StringBuffer

1. String 保存的是字符串常量，里面的值不能改，每次 String 类 更新实际上就是更换地址，效率较低。
2. StringBuffer 保存的是字符串变量，里面的值可以更改，每次 StringBuffer 的更新 实际上可以更新内容，不用每次更新地址，效率较高。



##### String 与 StringBuffer 相互转换

> **在开发中，我 们经常需要将 String 与 StringBuffer 进行转换。**

```java
public static void main(String[] args) {
    
	//看 String——>StringBuffe
    String str = "hello tom";
    //方式 1 使用构造器
    //注意： 返回的才是 StringBuffer 对象，对 str 本身没有影响
    StringBuffer stringBuffer = new StringBuffer(str);
    //方式 2 使用的是 append 方法
    StringBuffer stringBuffer1 = new StringBuffer();
    stringBuffer1 = stringBuffer1.append(str);
    //看看 StringBuffer ->String
    StringBuffer stringBuffer3 = new StringBuffer("韩顺平教育");
    //方式 1 使用 StringBuffer 提供的 toString 方法
    String s = stringBuffer3.toString();
    //方式 2: 使用构造器来搞定
    String s1 = new String(stringBuffer3);
}
```



##### StringBuffer 类常见方法

```java
public static void main(String[] args) {
    
    StringBuffer s = new StringBuffer("hello");
    
    //增
    s.append(',');// "hello,"
    s.append("张三丰");//"hello,张三丰"
    s.append("赵敏").append(100).append(true).append(10.5);//"hello,张三丰赵敏 100true10.5" System.out.println(s);//"hello,张三丰赵敏 100true10.5"
    
    //删
    /*
    * 删除索引为>=start && <end 处的字符
    * 解读: 删除 11~14 的字符 [11, 14)
    */
    s.delete(11, 14);
    System.out.println(s);//"hello,张三丰赵敏 true10.5"
    
    //改
    //使用 周芷若 替换 索引 9-11 的字符 [9,11)
    s.replace(9, 11, "周芷若");
    System.out.println(s);//"hello,张三丰周芷若 true10.5"
    //查找指定的子串在字符串第一次出现的索引，如果找不到返回-1
    int indexOf = s.indexOf("张三丰");
    System.out.println(indexOf);//6
    
    //插
    //老解读，在索引为 9 的位置插入 "赵敏",原来索引为 9 的内容自动后移
    s.insert(9, "赵敏");
    System.out.println(s);//"hello,张三丰赵敏周芷若 true10.5"
    //长度
    System.out.println(s.length());//22
    System.out.println(s);
}
```



#### StringBuilder 类

> - 一个可变的字符序列。此类提供一个与 StringBuffer 兼容的 API ，但不保证同步（StringBuilder 不是线程安全）。该类 被设计用作 StringBuffer 的一个简易替换，用在字符串缓冲区被单个线程使用的时候。如果可能，建议优先采用该类，因为在大多数实现中，它 比 StringBuffer 要快。
> - 在 StringBuiler 上的主要操作是 append 和 insert 方法，可重载这些方法，以接受任意类型的数据。

```java
public static void main(String[] args) {

    //1. StringBuffer 的直接父类 是 AbstractStringBuilder
    //2. StringBuffer 实现了 Serializable, 即 StringBuffer 的对象可以串行化
    //3. 在父类中 AbstractStringBuilder 有属性 char[] value,不是 final
    // 该 value 数组存放 字符串内容，引出存放在堆中
    //4. StringBuffer 是一个 final 类，不能被继承
    //5. 因为 StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)
    // 不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String
    StringBuffer stringBuffer = new StringBuffer("hello");
}
```



##### StringBuffer 类 常用方法

> **StringBuffer 和 StringBuilder 均代表可变的字符序列，方法是一样的，所以使用和 StringBuffer 一样 。**

- StringBuilder 是 final 
- 继承了 AbstractStringBuilder 属性 char[] value ,内容存到 value
- 实现了 Serializable 接口，序列化（所谓序列化即可以保存类型和数据本 

```java
public static void main(String[] args){
    //1. StringBuilder 继承 AbstractStringBuilder 类
    //2. 实现了 Serializable ,说明 StringBuilder 对象是可以串行化(对象可以网络传输,可以保存到文件)
    //3. StringBuilder 是 final 类, 不能被继承
    //4. StringBuilder 对象字符序列仍然是存放在其父类 AbstractStringBuilder 的 char[] value;
    // 因此，字符序列是堆中
    //5. StringBuilder 的方法，没有做互斥的处理,即没有 synchronized 关键字,因此在单线程的情况下使用
    // StringBuilder
    StringBuilder stringBuilder = new StringBuilder();
}
```



#### String 与 StringXxx 比较

1. StringBuilder 和 StringBuffer 非常类似，均代表可变的字符序列，而且方法都一样

2. String ： 不可变字符序列，效率低，但是复用率高

3. StringBuffer ： 可变字符序列，效率较高（增删）、线程安全、看源码

4. StringBuilder : 可变序列、效率最高、线程不安全

5. String 使用说明：

   String s = "a"; //创建了一个字符串

   s += "b";  // 实际上 原来的"a"字符串对象 已经丢弃了，现在又产生了一个字符串 s + "b"(也就是"ab")。如果多次执行这些改变内容的操作，会导致大量副本字符串对象存留在内存中，将降低效率。如果这样的操作放在循环中，会 极大影响程序的性能 = > **如果我们对 String 做大量修改，不要使用 String**



#### StringXxx 的选择

使用的原则，结论：

1. 如果字符串存在大量的修改操作，一般使用 StringBuffer 或 StringBuiler 
2. 如果字符串存在大量的修改操作，并在单线程的情况，使用StringBuilder
3. 如果字符串存在大量的修改操作，并在多线程的情况，使用 StringBuffer
4. 如果我们的字符串存在很少的修改操作，被多个对象引用，使用 String ，比如配置信息



### Math 类

---

> **Math 类包括用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数**



#### Math 类 常见方法 

##### .**abs  [绝对值]**

```java
int abs = Math.abs(-9);
System.out.println(abs);//9
```



##### .pow  [求幂]

```java
double pow = Math.pow(2, 4);//2 的 4 次方
System.out.println(pow);//16
```



##### .ceil  [向上取整]

```java
double ceil = Math.ceil(3.9);
System.out.println(ceil);//4.0
```



##### .floor  [向下取整]

```java
double floor = Math.floor(4.001);
System.out.println(floor);//4.0
```



##### .round  [四舍五入]

```java
// Math.floor(该参数+0.5)
long round = Math.round(5.51);
System.out.println(round);//6
```



##### .sqrt  [开平方]

```java
double sqrt = Math.sqrt(9.0);
System.out.println(sqrt);//3.0
```



##### .random  [求随机数]

```java
// random 返回的是 0 <= x < 1 之间的一个随机小数
// 思考：请写出获取 a-b 之间的一个随机整数,a,b 均为整数 ，比如 a = 2, b=7
// 即返回一个数 x 2 <= x <= 7
// Math.random() * (b-a) 返回的就是 0 <= 数 <= b-a
// (1) (int)(a) <= x <= (int)(a + Math.random() * (b-a +1) )
// (2) 使用具体的数给小伙伴介绍 a = 2 b = 7
// (int)(a + Math.random() * (b-a +1) ) = (int)( 2 + Math.random()*6)
// Math.random()*6 返回的是 0 <= x < 6 小数
// 2 + Math.random()*6 返回的就是 2<= x < 8 小数
// (int)(2 + Math.random()*6) = 2 <= x <= 7
// (3) 公式就是 (int)(a + Math.random() * (b-a +1) )
for(int i = 0; i < 100; i++) {
    System.out.println((int)(2 + Math.random() * (7 - 2 + 1)));
}
```



##### .max / min  [最大值/最小值]

```java
int min = Math.min(1, 9);
int max = Math.max(45, 90);
System.out.println("min=" + min);
System.out.println("max=" + max);
```



### Arrays 类

---

> **Arrays 类中包含了一系列的静态方法，用于管理或操作数组（比如排序和搜索）**



#### Arrays 类常用方法

---

##### toString 返回数组的字符串形式

```java
System.out.println(Arrays.toString(arr));
```



##### sort 排序（自然排序和定制排序）

```java
Arrays.sort(arr); // 默认排序方法
```

###### 定制排序

```java
public class ArraysMethod01 {
    public static void main(String[] args) {

        Integer[] integers = {1, 20, 90};
        //遍历数组
//        for(int i = 0; i < integers.length; i++) {
//            System.out.println(integers[i]);
//        }
        //直接使用Arrays.toString方法，显示数组
//        System.out.println(Arrays.toString(integers));//

        //演示 sort方法的使用

        Integer arr[] = {1, -1, 7, 0, 89};
        //进行排序
        //解读
        //1. 可以直接使用冒泡排序 , 也可以直接使用Arrays提供的sort方法排序
        //2. 因为数组是引用类型，所以通过sort排序后，会直接影响到 实参 arr
        //3. sort重载的，也可以通过传入一个接口 Comparator 实现定制排序
        //4. 调用 定制排序 时，传入两个参数 (1) 排序的数组 arr
        //(2) 实现了Comparator接口的匿名内部类 , 要求实现  compare方法
        //5. 先演示效果，再解释
        //6. 这里体现了接口编程的方式 , 看看源码，就明白
        //   源码分析
        //(1) Arrays.sort(arr, new Comparator()
        //(2) 最终到 TimSort类的 private static <T> void binarySort(T[] a, int lo, int hi, int start,
        //                                       Comparator<? super T> c)()
        //(3) 执行到 binarySort方法的代码, 会根据动态绑定机制 c.compare()执行我们传入的
        //    匿名内部类的 compare ()
        //     while (left < right) {
        //                int mid = (left + right) >>> 1;
        //                if (c.compare(pivot, a[mid]) < 0)
        //                    right = mid;
        //                else
        //                    left = mid + 1;
        //            }
        //(4) new Comparator() {
        //            @Override
        //            public int compare(Object o1, Object o2) {
        //                Integer i1 = (Integer) o1;
        //                Integer i2 = (Integer) o2;
        //                return i2 - i1;
        //            }
        //        }
        //(5) public int compare(Object o1, Object o2) 返回的值>0 还是 <0
        //    会影响整个排序结果, 这就充分体现了 接口编程+动态绑定+匿名内部类的综合使用
        //    将来的底层框架和源码的使用方式，会非常常见
        //Arrays.sort(arr); // 默认排序方法
        //定制排序
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println("===排序后===");
        System.out.println(Arrays.toString(arr));//



    }
}
```

###### 定制排序

```java
public class ArraysSortCustom {
    public static void main(String[] args) {

        int[] arr = {1, -1, 8, 0, 20};
        //bubble01(arr);

        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2 - i1;// return i2 - i1;
            }
        });

        System.out.println("==定制排序后的情况==");
        System.out.println(Arrays.toString(arr));

    }

    //使用冒泡完成排序
    public static void bubble01(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //结合冒泡 + 定制
    public static void bubble02(int[] arr, Comparator c) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //数组排序由 c.compare(arr[j], arr[j + 1])返回的值决定
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

```

###### 案例分析

```java
//(2)price 从小到大
// Arrays.sort(books, new Comparator() {
// //这里是对 Book 数组排序，因此 o1 和 o2 就是 Book 对象
// @Override
// public int compare(Object o1, Object o2) {
// Book book1 = (Book) o1;
// Book book2 = (Book) o2;
// double priceVal = book2.getPrice() - book1.getPrice();
//如果发现返回结果和我们输出的不一致，就修改一下返回的 1 和 -1
// if(priceVal > 0) {
// return -1;
// } else if(priceVal < 0) {
// return 1;
// } else {
// return 0;
// }
//}

//(3)按照书名长度从大到小
    Arrays.sort(books, new Comparator() {
    //这里是对 Book 数组排序，因此 o1 和 o2 就是 Book 对象
    @Override
    public int compare(Object o1, Object o2) {
        Book book1 = (Book) o1;
        Book book2 = (Book) o2;
        //要求按照书名的长度来进行排序
        return book2.getName().length() - book1.getName().length();
    }
});
```

##### binarySearch 

> 通过二分查找进行查找，要求必须排好序

```java
int index = Arrays.binarySearch(arr, 567);
```

###### 案例分析

```java
public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 123, 567};
        // binarySearch 通过二分搜索法进行查找，要求必须排好
        // 解读
        //1. 使用 binarySearch 二叉查找
        //2. 要求该数组是有序的. 如果该数组是无序的，不能使用binarySearch
        //3. 如果数组中不存在该元素，就返回 return -(low + 1);  // key not found.
        int index = Arrays.binarySearch(arr, 567);
        System.out.println("index=" + index);
    }
```

##### copyOf 

> 数组元素的复制

```java
Integer[] newArr = Arrays.copyOf(arr, 
```

```java
//copyOf 数组元素的复制
        // 解读
        //1. 从 arr 数组中，拷贝 arr.length个元素到 newArr数组中
        //2. 如果拷贝的长度 > arr.length 就在新数组的后面 增加 null
        //3. 如果拷贝长度 < 0 就抛出异常NegativeArraySizeException
        //4. 该方法的底层使用的是 System.arraycopy()
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println("==拷贝执行完毕后==");
        System.out.println(Arrays.toString(newArr));
```

##### fill 

> 数组元素的填充

```java
//1. 使用 99 去填充 num 数组，可以理解成是替换原理的元素
Arrays.fill(num, 99);
```

```java
 //ill 数组元素的填充
        Integer[] num = new Integer[]{9,3,2};
        //解读
        //1. 使用 99 去填充 num数组，可以理解成是替换原理的元素
        Arrays.fill(num, 99);
        System.out.println("==num数组填充后==");
        System.out.println(Arrays.toString(num));
```

##### equals 

> 比较两个数组元素内容是否完全一致

```java
        //equals 比较两个数组元素内容是否完全一致
        Integer[] arr2 = {1, 2, 90, 123};
        //解读
        //1. 如果arr 和 arr2 数组的元素一样，则方法true;
        //2. 如果不是完全一样，就返回 false
        boolean equals = Arrays.equals(arr, arr2);
        System.out.println("equals=" + equals);
```

##### asList 

> 将一组值，转换成 List

```java
 //asList 将一组值，转换成list
        //解读
        //1. asList方法，会将 (2,3,4,5,6,1)数据转成一个List集合
        //2. 返回的 asList 编译类型 List(接口)
        //3. asList 运行类型 java.util.Arrays#ArrayList, 是Arrays类的
        //   静态内部类 private static class ArrayList<E> extends AbstractList<E>
        //              implements RandomAccess, java.io.Serializable
        List asList = Arrays.asList(2,3,4,5,6,1);
        System.out.println("asList=" + asList);
        System.out.println("asList的运行类型" + asList.getClass());
```



### System 类

---

#### System 常用方法

##### exit 

> 退出当前程序

```java
//exit 退出当前程序

//        System.out.println("ok1");
//        //解读
//        //1. exit(0) 表示程序退出
//        //2. 0 表示一个状态 , 正常的状态
//        System.exit(0);//
//        System.out.println("ok2");
```

##### arrayCopy 

> 复制数组元素，比较适合底层调用，一般使用 Arrays.copyOf 完成数组复制

```java
 //1. 主要是搞清楚这五个参数的含义
        //2.
        //     源数组
        //     * @param      src      the source array.
        //     srcPos： 从源数组的哪个索引位置开始拷贝
        //     * @param      srcPos   starting position in the source array.
        //     dest : 目标数组，即把源数组的数据拷贝到哪个数组
        //     * @param      dest     the destination array.
        //     destPos: 把源数组的数据拷贝到 目标数组的哪个索引
        //     * @param      destPos  starting position in the destination data.
        //     length: 从源数组拷贝多少个数据到目标数组
        //     * @param      length   the number of array elements to be copied.
        System.arraycopy(src, 0, dest, 0, src.length);
```

##### currentTimeMillens 

> 返回当前时间距离 1970-1-1 的 毫秒数

##### gc 

>  运行垃圾回收机制 System.gc();

---

> ##### 代码

```java
public static void main(String[] args) {
//exit 退出当前程序
// System.out.println("ok1");

// //1. exit(0) 表示程序退出
// //2. 0 表示一个状态 , 正常的状态
// System.exit(0);//
// System.out.println("ok2");
//arraycopy ：复制数组元素，比较适合底层调用，
// 一般使用 Arrays.copyOf 完成复制数组
    int[] src={1,2,3};
    int[] dest = new int[3];// dest 当前是 {0,0,0}

//1. 主要是搞清楚这五个参数的含义
//2. // 源数组
// * @param src the source array. // srcPos： 从源数组的哪个索引位置开始拷贝
// * @param srcPos starting position in the source array. // dest : 目标数组，即把源数组的数据拷贝到哪个数组
// * @param dest the destination array. // destPos: 把源数组的数据拷贝到 目标数组的哪个索引
// * @param destPos starting position in the destination data. // length: 从源数组拷贝多少个数据到目标数组
// * @param length the number of array elements to be copied. System.arraycopy(src, 0, dest, 0, src.length);
// int[] src={1,2,3};
    System.out.println("dest=" + Arrays.toString(dest));//[1, 2, 3]
//currentTimeMillens:返回当前时间距离 1970-1-1 的毫秒数

    System.out.println(System.currentTimeMillis());
    }
}
```



### BigInteger 和 BigDecimal 类

---

- #### BigInteger

  > 适合存放比较大的整型

- #### BigDecimal 

  > 适合存放 精度更高的浮点型



#### 常用方法

- ##### add  加

- ##### substract  减

- ##### multiply  乘

- ##### divide 除

> ##### 代码

```java
public static void main(String[] args) {
    //当我们编程中，需要处理很大的整数，long 不够用
    //可以使用 BigInteger 的类来搞定
    // long l = 23788888899999999999999999999l;
    // System.out.println("l=" + l);
    BigInteger bigInteger = new BigInteger("23788888899999999999999999999");
    BigInteger bigInteger2 = new 		           BigInteger("10099999999999999999999999999999999999999999999999999999999999999999999999999999999");
    System.out.println(bigInteger);
    //1. 在对 BigInteger 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /
    //2. 可以创建一个 要操作的 BigInteger 然后进行相应操作
    BigInteger add = bigInteger.add(bigInteger2);
    System.out.println(add);//
    BigInteger subtract = bigInteger.subtract(bigInteger2);
    System.out.println(subtract);//减
    BigInteger multiply = bigInteger.multiply(bigInteger2);
    System.out.println(multiply);//乘
    BigInteger divide = bigInteger.divide(bigInteger2);
    System.out.println(divide);//除
}
```

```java
public static void main(String[] args) {
    //当我们需要保存一个精度很高的数时，double 不够用
    //可以是 BigDecimal
    // double d = 1999.11111111111999999999999977788d;
    // System.out.println(d);
    BigDecimal bigDecimal = new BigDecimal("1999.11");
    BigDecimal bigDecimal2 = new BigDecimal("3");
    System.out.println(bigDecimal);
    
    //1. 如果对 BigDecimal 进行运算，比如加减乘除，需要使用对应的方法
    //2. 创建一个需要操作的 BigDecimal 然后调用相应的方法即可
    System.out.println(bigDecimal.add(bigDecimal2));
    System.out.println(bigDecimal.subtract(bigDecimal2));
    System.out.println(bigDecimal.multiply(bigDecimal2));
    //System.out.println(bigDecimal.divide(bigDecimal2));//可能抛出异常 ArithmeticException
    //在调用 divide 方法时，指定精度即可. BigDecimal.ROUND_CEILING
    //如果有无限循环小数，就会保留 分子 的精度
    System.out.println(bigDecimal.divide(bigDecimal2, BigDecimal.ROUND_CEILING));
}
```



### 日期类

---

#### 第一代日期类

##### Date :

> 精确到毫秒，代表特定的瞬间



##### SimpleDateFormat 

> 格式化和解析日期的具体类，他允许进行格式化（日期 - > 文本）、解析（文本 -> 日期）和规范化



> ##### 代码

```java
public class Date01 {
    public static void main(String[] args) throws ParseException {
    //1. 获取当前系统时间
    //2. 这里的 Date 类是在 java.util 包
    //3. 默认输出的日期格式是国外的方式, 因此通常需要对格式进行转换
    Date d1 = new Date(); //获取当前系统时间
    System.out.println("当前日期=" + d1);
    Date d2 = new Date(9234567); //通过指定毫秒数得到时间
    System.out.println("d2=" + d2); //获取某个时间对应的毫秒数
    //

    //1. 创建 SimpleDateFormat 对象，可以指定相应的格式
    //2. 这里的格式使用的字母是规定好，不能乱写
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日 hh:mm:ss E");
    String format = sdf.format(d1); // format:将日期转换成指定格式的字符串
    System.out.println("当前日期=" + format);

    //1. 可以把一个格式化的 String 转成对应的 Date
    //2. 得到 Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
    //3. 在把 String -> Date ， 使用的 sdf 格式需要和你给的 String 的格式一样，否则会抛出转换异常
    String s = "1996 年 01 月 01 日 10:20:30 星期一";
    Date parse = sdf.parse(s);
    System.out.println("parse=" + sdf.format(parse));
    }
}
```



#### 第二代日期类

##### 基本介绍

> ​	1.主要就是 Calendar 类（日历）
>
> ```java
> public abstract class Calendar extends Object implements Serializable,Cloneable,Comparabale<Calendar>
> ```
>
> 
>
> ​	2.Calendar 类是一个抽象类，它为特定瞬间与一组诸如 YEAR,MONTH，DAY_OF_MONTH,HOUR 等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
>
> ```java
> public static void main(String[] args) {
> 
>  //1. Calendar 是一个抽象类， 并且构造器是 private
>  //2. 可以通过 getInstance() 来获取实例
>  //3. 提供大量的方法和字段提供给程序员
>  //4. Calendar 没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
>  //5. 如果我们需要按照 24 小时进制来获取时间， Calendar.HOUR ==改成=> Calendar.HOUR_OF_DAY
>  Calendar c = Calendar.getInstance(); //创建日历类对象//比较简单，自由
>  System.out.println("c=" + c);
>  //2.获取日历对象的某个日历字段
>  System.out.println("年：" + c.get(Calendar.YEAR));
>  // 这里为什么要 + 1, 因为 Calendar 返回月时候，是按照 0 开始编号
>  System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
>  System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
>  System.out.println("小时：" + c.get(Calendar.HOUR));
>  System.out.println("分钟：" + c.get(Calendar.MINUTE));
>  System.out.println("秒：" + c.get(Calendar.SECOND));
>  //Calender 没有专门的格式化方法，所以需要程序员自己来组合显示
>  System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
>  c.get(Calendar.DAY_OF_MONTH) +
>  " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) );
> }
> ```
>
> 



#### 第三代日期类：

##### 前面两代日期类的不足分析

> **JDK 1.0 中包含了一个java.util.Date 类，但是它的大多数方法已经在 JDk 1.1 引入Calendar 类之后被弃用了。而 Calendar 类 存在的问题是：**



###### 可变性：

> 像日期和时间这样的类应该是不可变的

###### 偏移性:

> Date 中年份是从 1900 开始的，而月份都从 0 开始

###### 格式化：

> 格式化只对 Date 有用，Calendar 则不行

###### 提示：

> 它们也不是线程安全的；不能处理闰秒等（每隔2天，多出 1 s)





#####   LocalDate、LocalTime、LocalDateTime

> LocalDate （日期/年月日）、LocalTime(时间/十分秒) 、LocalDateTime（日期时间/年月日时分秒） JDK 8 加入



###### LocalDate 

> 只包括日期，可以获取日期字段



###### LocalTime

> 只包括时间，可以获取时间字段



###### LocalDateTime 

> 包括日期 + 时间，可以获取日期 + 时间字段



> ##### 代码

```java
public static void main(String[] args) {
    //第三代日期

    //1. 使用 now() 返回表示当前日期时间的 对象
    LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
    System.out.println(ldt);
    
    //2. 使用 DateTimeFormatter 对象来进行格式化
    // 创建 DateTimeFormatter 对象
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String format = dateTimeFormatter.format(ldt);
    System.out.println("格式化的日期=" + format);
    System.out.println("年=" + ldt.getYear());
    System.out.println("月=" + ldt.getMonth());
    System.out.println("月=" + ldt.getMonthValue());
    System.out.println("日=" + ldt.getDayOfMonth());
    System.out.println("时=" + ldt.getHour());
    System.out.println("分=" + ldt.getMinute());
    System.out.println("秒=" + ldt.getSecond());
    LocalDate now = LocalDate.now(); //可以获取年月日
    LocalTime now2 = LocalTime.now();//获取到时分秒
    
    //提供 plus 和 minus 方法可以对当前时间进行加或者减
    //看看 890 天后，是什么时候 把 年月日-时分秒
    LocalDateTime localDateTime = ldt.plusDays(890);
    System.out.println("890 天后=" + dateTimeFormatter.format(localDateTime));
    //看看在 3456 分钟前是什么时候，把 年月日-时分秒输出
    LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
    System.out.println("3456 分钟前 日期=" + dateTimeFormatter.format(localDateTime2));
}
```



#### DateTimeFormatter 格式日期类

> **类似于 SimpleDateFormat **

```java
DateTimeFormat dtf = DateTimeformat.ofPattern(格式);
String str = dtf.format(日期对象); 
```



#### Instant 时间戳

> **类似于 Date ,提供了一系列 和Date 类 转换的方式**

```java
// Instant ->  Date
Date date = Date.from(instant);
// Date ->  Instant
Instant instant = date.toInstant();
```

```java
public static void main(String[] args) {
    
    //1.通过 静态方法 now() 获取表示当前时间戳的对象
    Instant now = Instant.now();
    System.out.println(now);
    
    //2. 通过 from 可以把 Instant 转成 Date
    Date date = Date.from(now);
    
    //3. 通过 date 的 toInstant() 可以把 date 转成 Instant 对象
    Instant instant = date.toInstant();
}
```



#### 第三代日期类更多方法

- LocalDateTime 类
- MonthDay 类 ： 检查重复事件
- 是否是闰年
- 增加日期的某个部分
- 使用 plus 方法测试增加时间的某个部分
- 使用 minus 方法测试查看一年前和一年后的日期



## 集合

> - 可以动态保存任意多个对象，使用比较方便
> - 提供一系列方便的操作对象的方法：add,remove,set,get
> - 使用集合添加，删除新元素



### 数组

---

> ###### 长度必须一开始指定，而且一旦指定不能更改

> ###### 保存的必须是同一类型的元素

> ###### 使用数组进行增加/删除元素的示意代码比较麻烦







### 集合的框架体系

---

> Java 的集合类很多，主要分为两大类
>
> ![image-20220620112941131](D:\C\Java\com\csqjava\notes_\image-20220620112941131.png)
>
> ![image-20220620113045773](D:\C\Java\com\csqjava\notes_\image-20220620113045773.png)

> ###### 代码演示：

```java
public static void main(String[] args) {
    //解读
    //1. 集合主要是两组(单列集合 , 双列集合)
    //2. Collection 接口有两个重要的子接口 List Set , 他们的实现子类都是单列集合
    //3. Map 接口的实现子类 是双列集合， 存放的 K-V
    //4. 两张图记住
    //Collection
    //Map
    ArrayList arrayList = new ArrayList();
    arrayList.add("jack");
    arrayList.add("tom");
    HashMap hashMap = new HashMap();
    hashMap.put("NO1", "北京");
    hashMap.put("NO2", "上海");
}
```



### Collection 

---



#### Collection 接口和常用方法

---

#### Collection 接口实现类的特点

- Collection 实现子类可以存放多个元素，每个元素可以是 Object
- 有些 Collection 的实现类，可以存放重复的元素，有些不可以
- 有些 Collection 的实现类，有些是有序的（List),有些不是有序（Set)
- Collection 接口没有直接实现子类，是通过它的子接口 Set 和 List 来实现的



#### Collection 接口常用方法

##### add

> 添加单个元素

```java
    list.add("jack");
    list.add(10);//list.add(new Integer(10))
    list.add(true);
    System.out.println("list=" + list);
```



##### remove 

> 删除指定元素

```java
    // remove:删除指定元素
    //list.remove(0);//删除第一个元素
    list.remove(true);//指定删除某个元素
    System.out.println("list=" + list);
```



##### contains

> 查找元素是否存在

```java
    // contains:查找元素是否存在
    System.out.println(list.contains("jack"));//T
```



##### size

> 获取元素个数

```java
    // size:获取元素个数
    System.out.println(list.size());//2
```



##### isEmpty

> 判断是否为空

```java
    // isEmpty:判断是否为空
    System.out.println(list.isEmpty());//F
```



##### clear

> 清空

```java
    // clear:清空
    list.clear();
    System.out.println("list=" + list);
```



##### addAll

> 添加多个元素

```java
    // addAll:添加多个元素
    ArrayList list2 = new ArrayList();
    list2.add("红楼梦");
    list2.add("三国演义");
    list.addAll(list2);
    System.out.println("list=" + list);
```



##### contains

> 查询多个元素是否存在

```java
    // containsAll:查找多个元素是否都存在
    System.out.println(list.containsAll(list2));//T
```



##### removeAll

> 移除多个元素

```java
        
    // removeAll： 删除多个元素
    list.add("聊斋");
    list.removeAll(list2);
    System.out.println("list=" + list);//[聊斋]
```





> ##### 代码示例

```java
public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
    List list = new ArrayList();
        
    // add:添加单个元素
    list.add("jack");
    list.add(10);//list.add(new Integer(10))
    list.add(true);
    System.out.println("list=" + list);
        
    // remove:删除指定元素
    //list.remove(0);//删除第一个元素
    list.remove(true);//指定删除某个元素
    System.out.println("list=" + list);
        
    // contains:查找元素是否存在
    System.out.println(list.contains("jack"));//T
        
    // size:获取元素个数
    System.out.println(list.size());//2
        
    // isEmpty:判断是否为空
    System.out.println(list.isEmpty());//F
        
    // clear:清空
    list.clear();
    System.out.println("list=" + list);
        
    // addAll:添加多个元素
    ArrayList list2 = new ArrayList();
    list2.add("红楼梦");
    list2.add("三国演义");
    list.addAll(list2);
    System.out.println("list=" + list);
        
    // containsAll:查找多个元素是否都存在
    System.out.println(list.containsAll(list2));//T
        
    // removeAll： 删除多个元素
    list.add("聊斋");
    list.removeAll(list2);
    System.out.println("list=" + list);//[聊斋]
    // 说明： 以 ArrayList 实现类来演示.
}
```





#### Collection 接口遍历元素方式

#### Iterator遍历

##### 基本介绍

> ###### Iterator 对象称为迭代器，主要用于遍历 Collection 集合中的元素

> ###### 所有实现了 Collection 接口的集合类都有一个 iterator() 方法，用以返回一个实现了 Iterator 接口的对象，即可以返回一个迭代器

> ###### Iterator 的结构

> ###### Iterator 只用于遍历集合，Iterator 本身并不存放对象



##### 迭代器的执行原理

```java
Iterator iterator = coll.iterator(); // 得到一个集合迭代器
// hasNext(); 判断是否还有下一个元素
while(iterator.hasNext()){
    // next() 作用 
    // 1.下移
    // 2.将下移以后集合位置上的元素返回
    System.out.println(iterator.next());
}
```



##### Iterator 接口的方法

###### hasNext()

> Returns true if the iteration has more elements

###### next()

> Returns the next elements in the iteration

###### remove()

> Removes from the underlying collection the last lelment returned by the iterator (optional operation)



> ###### 提示

在调用 iterator.next() 方法之前必须要调用 iterator.hasNext() 进行检测，若不调用，且下一条记录无效，直接调用next() 会抛出 NoSuchElementException 异常



> ###### 代码示例

```java
public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));


        //System.out.println("col=" + col);
        //遍历 col集合
        //1. 先得到 col 对应的 迭代器
        Iterator iterator = col.iterator();
        //2. 使用while循环遍历
//        while (iterator.hasNext()) {//判断是否还有数据
//            //返回下一个元素，类型是Object
//            Object obj = iterator.next();
//            System.out.println("obj=" + obj);
//        }
        //快捷键，快速生成 while => itit
        //显示所有的快捷键的的快捷键 ctrl + j
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);

        }
        //3. 当退出while循环后 , 这时iterator迭代器，指向最后的元素
        //   iterator.next();//NoSuchElementException
        //4. 如果希望再次遍历，需要重置我们的迭代器
        iterator = col.iterator();
        System.out.println("===第二次遍历===");
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);

        }

    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

```



#### for 循环增强遍历

> 增强 for 循环，可以代替 iterator 迭代器，特点：增强for 就是 简化版的 iterator,本质一样。智能用于遍历集合或数组



##### 基本语法

```java
for(元素类型 元素名 : 集合名或数组名){
    //访问元素
}
```



> ##### 代码示例

```java
public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("小黑", 3));
        list.add(new Dog("大黄", 100));
        list.add(new Dog("大壮", 8));


        //先使用for增强
        for (Object dog : list) {
            System.out.println("dog=" + dog);
        }

        //使用迭代器
        System.out.println("===使用迭代器来遍历===");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println("dog=" + dog);

        }

    }
}
/**
 * 创建  3个 Dog {name, age}  对象，放入到 ArrayList 中，赋给 List 引用
 * 用迭代器和增强for循环两种方式来遍历
 * 重写Dog 的toString方法， 输出name和age
 */
class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```



### List

---



#### List 接口和常用方法

##### 基本介绍

- List 集合类中元素有序（即添加顺序和取出顺序一致）、且可重复
- List 集合类中的每个元素都有对应的顺序索引，即支持索引
- List 容器中的元素都对应一个整数型的序号，记载其在容器中的位置，可以根据序号存取容器中的元素
- JDK API 中List 的实现类有
  - AbstractList
  - AbstractSequentialList
  - **ArrayList**
  - AttributeList
  - CopyOrWriteArrayList
  - **LinkedList**
  - RoleList
  - RoleUnresolveList
  - **Stack**
  - **Vector**





##### List 接口常用方法

###### add();

> void add(int index, Object ele):在index位置插入ele元素



###### addAll();

> boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来



###### get();

> Object get(int index):获取指定index位置的元素



###### indexOf();

> int indexOf(Object obj):返回obj在集合中首次出现的位置



###### lastIndexOf();

> int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置



###### remove();

> Object remove(int index):移除指定index位置的元素，并返回此元素



###### set();

> Object set(int index, Object ele):设置指定index位置的元素为ele , 相当于是替换.



###### subList();

> List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合



> ###### 代码示例

```java
public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");
//        void add(int index, Object ele):在index位置插入ele元素
        //在index = 1的位置插入一个对象
        list.add(1, "csq");
        System.out.println("list=" + list);
//        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(1, list2);
        System.out.println("list=" + list);
//        Object get(int index):获取指定index位置的元素
        //说过
//        int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("tom"));//2
//        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        list.add("csq");
        System.out.println("list=" + list);
        System.out.println(list.lastIndexOf("csq"));
//        Object remove(int index):移除指定index位置的元素，并返回此元素
        list.remove(0);
        System.out.println("list=" + list);
//        Object set(int index, Object ele):设置指定index位置的元素为ele , 相当于是替换.
        list.set(1, "玛丽");
        System.out.println("list=" + list);
//        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        // 注意返回的子集合 fromIndex <= subList < toIndex
        List returnlist = list.subList(0, 2);
        System.out.println("returnlist=" + returnlist);

    }
}

```



#### List 的遍历元素方式

##### iterator 迭代器

```java
Iterator iter = new col.iterator();
while(iter.hasNext()){
    Object 0 = iter.next();
}
```



##### 增强 for 

```java
for(Object o : col){
    //
}
```



##### 普通 for

```java
for(int i = 0;i < list.size();++i){
    
    Object o = list.get(i);
    System.out.println(object);
}
```

> ##### 代码示例

```java
public class ListFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //List 接口的实现子类 Vector LinkedList
        //List list = new ArrayList();
        //List list = new Vector();
        List list = new LinkedList();

        list.add("jack");
        list.add("tom");
        list.add("鱼香肉丝");
        list.add("北京烤鸭子");

        //遍历
        //1. 迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);

        }

        System.out.println("=====增强for=====");
        //2. 增强for
        for (Object o : list) {
            System.out.println("o=" + o);
        }

        System.out.println("=====普通for====");
        //3. 使用普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println("对象=" + list.get(i));
        }
    }
}
```



> ##### 说明：

使用 LinkedList 完成 使用方式和 ArrayList 一样



#### ArrayList 底层结构和源码分析

##### ArrayList 注意事项 

> ###### permits all elements ， including null ，ArrayList 可以加入 null ，并且多个

> ###### ArrayList 是由 数组来实现数据存储的

> ###### ArrayList 基本等同于 Vector ，除了 ArrayList 是线程不安全的（执行效率高），在多线程情况下，不建议使用 ArrayList 



##### ArrayList 的底层操作机制

> ###### ArrayList 中维护了一个Object 类型的数组 elementData 



> ###### 当创建 ArrayList 对象时，如果使用的无参构造器，则初始 elemenData 容量为0，第一次添加，则扩容 elementData 为 10，如需要再次扩容，则扩容 elementData 为 1.5 倍



> ###### 如果使用的是指定大小的构造器，则初始 elementData 容量为指定大小，如果需要再次扩容，则直接扩容elementData 为 1.5 倍





#### Vector 底层结构和源码分析

##### 基本介绍

> ###### Vector 类的定义说明

```java
public class Vector<E>
extends AbstractList<E>
implements List<E>,RandomAccess,Cloneable,Serializable
```



> ###### Vector 底层也是一个对象数组， protected Object[] elementData



> ###### Vector 是线程同步的，即线程安全，Vector 类的操作方法带有 synchronized

```java
public synchronized E get (int index){
    if(index >= elementCount){
        throw new ArrayIndexOutOfBoundsException(index);
    }
    return elementData;
}
```



> ###### 在开发中，需要线程同步安全时，考虑使用 Vector



> ###### 代码示例

```java
@SuppressWarnings({"all"})
public class Vector_ {
    public static void main(String[] args) {
        //无参构造器
        //有参数的构造
        Vector vector = new Vector(8);
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        System.out.println("vector=" + vector);
        //解读源码
        //1. new Vector() 底层
        /*
            public Vector() {
                this(10);
            }
         补充：如果是  Vector vector = new Vector(8);
            走的方法:
            public Vector(int initialCapacity) {
                this(initialCapacity, 0);
            }
            
         2. vector.add(i)
         2.1  //下面这个方法就添加数据到vector集合
            public synchronized boolean add(E e) {
                modCount++;
                ensureCapacityHelper(elementCount + 1);
                elementData[elementCount++] = e;
                return true;
            }
            
          2.2  //确定是否需要扩容 条件 ： minCapacity - elementData.length>0
            private void ensureCapacityHelper(int minCapacity) {
                // overflow-conscious code
                if (minCapacity - elementData.length > 0)
                    grow(minCapacity);
            }
            
          2.3 //如果 需要的数组大小 不够用，就扩容 , 扩容的算法
              //newCapacity = oldCapacity + ((capacityIncrement > 0) ?
              //                             capacityIncrement : oldCapacity);
              //就是扩容两倍.
            private void grow(int minCapacity) {
                // overflow-conscious code
                int oldCapacity = elementData.length;
                int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                                 capacityIncrement : oldCapacity);
                if (newCapacity - minCapacity < 0)
                    newCapacity = minCapacity;
                if (newCapacity - MAX_ARRAY_SIZE > 0)
                    newCapacity = hugeCapacity(minCapacity);
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
         */

    }
}

```



##### Vector 和 ArrayList 的比较

|           | 底层结构         | 版本   | 线程安全（同步）效率 | 扩容参数                                                     |
| --------- | ---------------- | ------ | -------------------- | ------------------------------------------------------------ |
| ArrayList | 可变数组         | JDK1.2 | 不安全，效率高       | 如果有参构造 1.5 倍                                                         如果是无参  第一次10  第二次开始 1.5 倍 |
| Vector    | 可变数组Object[] | Jdk1.0 | 安全。效率不高       | 如果是无参，默认10，满后就按 2 倍扩容         如果指定大小，则每次直接按 2 倍 扩容 |



#### LinkedList 底层结构

##### LinkedList 全面说明

- LinkedList 底层实现了双向链表  和  双端队列特点
- 可以添加任意元素（元素可以重复），包括 null
- 线程不安全，没有实现同步





##### LinkedList 的底层操作机制

- LinkedList 底层维护了一个双向链表
- LinedList 中维护了两个属性 first 和 last 分别指向 首节点和尾节点
- 每个节点（Node对象)，里面又维护了 prev,next,item 三个属性，其中通过prev 指向前一个，通过 next 指向下一个，最终实现了双向链表
- 所以 LinkedList 的元素添加和删除，不是通过数组完成的，相对来说效率较高

> ###### 代码示例

```java
public class LinkedList01 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("老韩");

        //连接三个结点，形成双向链表
        //jack -> tom -> hsp
        jack.next = tom;
        tom.next = hsp;
        //hsp -> tom -> jack
        hsp.pre = tom;
        tom.pre = jack;

        Node first = jack;//让first引用指向jack,就是双向链表的头结点
        Node last = hsp; //让last引用指向hsp,就是双向链表的尾结点


        //演示，从头到尾进行遍历
        System.out.println("===从头到尾进行遍历===");
        while (true) {
            if(first == null) {
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        //演示，从尾到头的遍历
        System.out.println("====从尾到头的遍历====");
        while (true) {
            if(last == null) {
                break;
            }
            //输出last 信息
            System.out.println(last);
            last = last.pre;
        }

        //演示链表的添加对象/数据，是多么的方便
        //要求，是在 tom --------- 直接，插入一个对象 smith

        //1. 先创建一个 Node 结点，name 就是 smith
        Node smith = new Node("smith");
        //下面就把 smith 加入到双向链表了
        smith.next = hsp;
        smith.pre = tom;
        hsp.pre = smith;
        tom.next = smith;

        //让first 再次指向jack
        first = jack;//让first引用指向jack,就是双向链表的头结点

        System.out.println("===从头到尾进行遍历===");
        while (true) {
            if(first == null) {
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        last = hsp; //让last 重新指向最后一个结点
        //演示，从尾到头的遍历
        System.out.println("====从尾到头的遍历====");
        while (true) {
            if(last == null) {
                break;
            }
            //输出last 信息
            System.out.println(last);
            last = last.pre;
        }


    }
}

//定义一个Node 类，Node 对象 表示双向链表的一个结点
class Node {
    public Object item; //真正存放数据
    public Node next; //指向后一个结点
    public Node pre; //指向前一个结点
    public Node(Object name) {
        this.item = name;
    }
    public String toString() {
        return "Node name=" + item;
    }
}
```



##### LinkedList 的 CRUD 案例

```java
@SuppressWarnings({"all"})
public class LinkedListCRUD {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("linkedList=" + linkedList);

        //演示一个删除结点的
        linkedList.remove(); // 这里默认删除的是第一个结点
        //linkedList.remove(2);

        System.out.println("linkedList=" + linkedList);

        //修改某个结点对象
        linkedList.set(1, 999);
        System.out.println("linkedList=" + linkedList);

        //得到某个结点对象
        //get(1) 是得到双向链表的第二个对象
        Object o = linkedList.get(1);
        System.out.println(o);//999

        //因为LinkedList 是 实现了List接口, 遍历方式
        System.out.println("===LinkeList遍历迭代器====");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("next=" + next);

        }

        System.out.println("===LinkeList遍历增强for====");
        for (Object o1 : linkedList) {
            System.out.println("o1=" + o1);
        }
        System.out.println("===LinkeList遍历普通for====");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }


        //源码阅读.
        /* 1. LinkedList linkedList = new LinkedList();
              public LinkedList() {}
           2. 这时 linkeList 的属性 first = null  last = null
           3. 执行 添加
               public boolean add(E e) {
                    linkLast(e);
                    return true;
                }
            4.将新的结点，加入到双向链表的最后
             void linkLast(E e) {
                final Node<E> l = last;
                final Node<E> newNode = new Node<>(l, e, null);
                last = newNode;
                if (l == null)
                    first = newNode;
                else
                    l.next = newNode;
                size++;
                modCount++;
            }

         */

        /*
          读源码 linkedList.remove(); // 这里默认删除的是第一个结点
          1. 执行 removeFirst
            public E remove() {
                return removeFirst();
            }
         2. 执行
            public E removeFirst() {
                final Node<E> f = first;
                if (f == null)
                    throw new NoSuchElementException();
                return unlinkFirst(f);
            }
          3. 执行 unlinkFirst, 将 f 指向的双向链表的第一个结点拿掉
            private E unlinkFirst(Node<E> f) {
                // assert f == first && f != null;
                final E element = f.item;
                final Node<E> next = f.next;
                f.item = null;
                f.next = null; // help GC
                first = next;
                if (next == null)
                    last = null;
                else
                    next.prev = null;
                size--;
                modCount++;
                return element;
            }
         */
    }
}

```



##### ArrayList 和 LinkedList 比较

|            | 底层结构 | 增删的效率         | 改查的效率 |
| ---------- | -------- | ------------------ | ---------- |
| ArrayList  | 可变数组 | 较低  数组扩容     | 较高       |
| LinkedList | 双向链表 | 较高，通过链表追加 | 较低       |



###### ArrayList 和 LinkedList 的选择

- 如果我们 改查 的操作多，选择 ArrayList 
- 如果我们 增删 的操作多，选择 LinkedList
- 一般来说，在程序中，80%-90%都是查询，因此大部分情况下会选择 ArrayList 
- 在有一个项目中，根据业务灵活选择，也可能这样，一个模块使用的是 ArrayList ,另一个使用的是 LinkedList ，也就是说要根据业务来进行选择



### Set

---



#### 基本介绍

- 无序（添加和取出的顺序不一致），没有索引
- 不允许重复元素，所以最多包含有一个 null
- JDK API 中 Set 接口的实现类
  - 所有的超级接口
    - Collection<E> 
    - Iterable<E>
  - 所有已知子接口
    - NavigableSet<E>
    - SortedSet<E>
  - 所有已知实现类
    - AbstractSet
    - ConCurrentSkipListSet
    - CopyOnWriteArraySet
    - EnumSet
    - **HashSet**
    - JobStataReasons
    - **LinkedHashSet**
    - **TreeSet**



#### Set 接口的常用方法

> 和 List 接口一样，Set 接口也是 Collection 的子接口，因此常用方法和 Collection 接口也一致



#### Set 接口的遍历方式

> 同 Collection 的遍历方式一致，因为 Set 接口是 Collection 接口的子接口

> ##### 可以使用迭代器

> ##### 增强 for

> ##### 不能使用索引的方式来获取



#### Set 接口实现类 - HashSet

##### HashSet 全面说明

> ###### HashSet 实现了 Set 接口

> ###### HashSet 实际上是 HashMap

```java
public HashSet(){
    map = new HashMap<>();
}
```

> ###### 可以存放 null 值，但是只能存放一个 null

> ###### HashSet 不保证元素是有序的，取决于 hash 后，再确定索引的结果（即 不能保证存放元素的顺序和取出顺序一致）

> ###### 不能有重复元素/对象，在前面 Set 接口使用有说明



##### HashSet 底层机制说明

> HashSet 底层是HashMap,HashMap底层是（数组，链表，红黑树



##### HashSet 的添加元素底层实现

- 先获取元素的 hash 值（hashCode 方法）

- 对 hash值 进行运算，得出一个索引值 即为要存放在HashSet 中的位置号

- 如果该位置上没有其他元素则直接存放。

- 如果该位置上已经有其他元素，则需要进行 equals 判断

  - 如果相等，则不再添加
  - 如果不相等，则以链表的方式添加 

- 过程

  ```java
  /*
  1.HashSet底层是HashMap
  2.
  添加一个元素时，先得到hash值会
  转成->索引值
  3.找到存储数据表table,看这个索引
  位置是否已经存放的有元素
  4.
  如果没有，直接加入
  5.
  如果有，调用equals比较，如果
  相同，就放弃添加，如果不相同，则
  添加到最后
  6.
  在Java8中，如果一条链表的元素个数
  到达TREEIFY_THRESHOLD(默认
  是8)，并且table的大小>=
  MIN_TREEIFY_CAPACITY(默认64)
  就会进行树化（红黑树）
  */
  ```

  

> ###### 代码示例

```java
@SuppressWarnings({"all"})
public class HashSetSource {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("java");//到此位置，第1次add分析完毕.
        hashSet.add("php");//到此位置，第2次add分析完毕
        hashSet.add("java");
        System.out.println("set=" + hashSet);

        /*
        HashSet 的源码解读
        1. 执行 HashSet()
            public HashSet() {
                map = new HashMap<>();
            }
        2. 执行 add()
           public boolean add(E e) {//e = "java"
                return map.put(e, PRESENT)==null;//(static) PRESENT = new Object();
           }
         3.执行 put() , 该方法会执行 hash(key) 得到key对应的hash值 算法h = key.hashCode()) ^ (h >>> 16)
             public V put(K key, V value) {//key = "java" value = PRESENT 共享
                return putVal(hash(key), key, value, false, true);
            }
         4.执行 putVal
         final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i; //定义了辅助变量
                //table 就是 HashMap 的一个数组，类型是 Node[]
                //if 语句表示如果当前table 是null, 或者 大小=0
                //就是第一次扩容，到16个空间.
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;

                //(1)根据key，得到hash 去计算该key应该存放到table表的哪个索引位置
                //并把这个位置的对象，赋给 p
                //(2)判断p 是否为null
                //(2.1) 如果p 为null, 表示还没有存放元素, 就创建一个Node (key="java",value=PRESENT)
                //(2.2) 就放在该位置 tab[i] = newNode(hash, key, value, null)

                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    //一个开发技巧提示： 在需要局部变量(辅助变量)时候，在创建
                    Node<K,V> e; K k; //
                    //如果当前索引位置对应的链表的第一个元素和准备添加的key的hash值一样
                    //并且满足 下面两个条件之一:
                    //(1) 准备加入的key 和 p 指向的Node 结点的 key 是同一个对象
                    //(2)  p 指向的Node 结点的 key 的equals() 和准备加入的key比较后相同
                    //就不能加入
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    //再判断 p 是不是一颗红黑树,
                    //如果是一颗红黑树，就调用 putTreeVal , 来进行添加
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {//如果table对应索引位置，已经是一个链表, 就使用for循环比较
                          //(1) 依次和该链表的每一个元素比较后，都不相同, 则加入到该链表的最后
                          //    注意在把元素添加到链表后，立即判断 该链表是否已经达到8个结点
                          //    , 就调用 treeifyBin() 对当前这个链表进行树化(转成红黑树)
                          //    注意，在转成红黑树时，要进行判断, 判断条件
                          //    if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY(64))
                          //            resize();
                          //    如果上面条件成立，先table扩容.
                          //    只有上面条件不成立时，才进行转成红黑树
                          //(2) 依次和该链表的每一个元素比较过程中，如果有相同情况,就直接break

                        for (int binCount = 0; ; ++binCount) {
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD(8) - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                //size 就是我们每加入一个结点Node(k,v,h,next), size++
                if (++size > threshold)
                    resize();//扩容
                afterNodeInsertion(evict);
                return null;
            }
         */

    }
}

```



##### HashSet 的扩容 和转成红黑树机制

- HashSet 的底层是HashMap,第一次添加时，table  数组扩容到 16，临界值（threshold)是 16 * 加载因子（loadFactor) 是 0.75 = 12
- 如果 table 数组使用到了临界值 12  ，就会扩容到 16 * 2 = 32，新的临界值就是 32 * 0.75 = 24
- 在 Java 8 中，如果一条链条的元素个数到达 TREEIFY_THRESHOOLD（默认是 8 ），并且 table  的大小 >= MIN_TREEIFY_CAPACITY(默认 64) ，就会进行树化（红黑树），**否则仍然采用数组扩容机制）**

```java
@SuppressWarnings({"all"})
public class HashSetIncrement {
    public static void main(String[] args) {
        /*
        HashSet底层是HashMap, 第一次添加时，table 数组扩容到 16，
        临界值(threshold)是 16*加载因子(loadFactor)是0.75 = 12
        如果table 数组使用到了临界值 12,就会扩容到 16 * 2 = 32,
        新的临界值就是 32*0.75 = 24, 依次类推

         */
        HashSet hashSet = new HashSet();
//        for(int i = 1; i <= 100; i++) {
//            hashSet.add(i);//1,2,3,4,5...100
//        }
        /*
        在Java8中, 如果一条链表的元素个数到达 TREEIFY_THRESHOLD(默认是 8 )，
        并且table的大小 >= MIN_TREEIFY_CAPACITY(默认64),就会进行树化(红黑树),
        否则仍然采用数组扩容机制

         */

//        for(int i = 1; i <= 12; i++) {
//            hashSet.add(new A(i));//
//        }


        /*
            当我们向hashset增加一个元素，-> Node -> 加入table , 就算是增加了一个size++

         */

        for(int i = 1; i <= 7; i++) {//在table的某一条链表上添加了 7个A对象
            hashSet.add(new A(i));//
        }

        for(int i = 1; i <= 7; i++) {//在table的另外一条链表上添加了 7个B对象
            hashSet.add(new B(i));//
        }



    }
}

class B {
    private int n;

    public B(int n) {
        this.n = n;
    }
    @Override
    public int hashCode() {
        return 200;
    }
}

class A {
    private int n;

    public A(int n) {
        this.n = n;
    }
    @Override
    public int hashCode() {
        return 100;
    }
}
```



#### Set 接口实现类 - LinkedHashSet

##### 基本介绍

- LinkedHashSet 是 HashSet 的子类
- LinkedHashSet 底层是一个 LinkedHashMap,底层维护了一个数组 + 双向链表
- LinkedHashSet 根据元素的 hashCode 值 来决定元素的存储位置。同时使用链表维护元素的次序，这使得元素看起来是以插入顺序保存的
- LinkedHashSet 不允许添加重复元素



##### 说明

- 在 LinkedHashSet 中维护了一个 hash 表 和 一个双向链表（LinkedHashSet 有 head 和 tail)
- 每一个节点 有 before 和 after 属性，这样可以形成双向链表
- 在添加元素时，先求 hash 值，再求索引，确定该元素在 table 中的位置，然后将添加的元素加入到双向链表中（如果已经存在，则不添加）
- 这样的话，我们遍历 LinkedHashSet 时，也能确保插入顺序和遍历顺序一致





### Map

---



#### Map 接口实现类的特点

- Map 与 Collection 并列存在。用于保存具有映射关系的数据： Key - Value
- Map 中的 key 和 value 可以是任何引用类型的数据，会封装到 HashMap$Node 对象中
- Map 中的 key 不允许重复，原因和 HashSet 一样
- Map 中的 value 可以重复
- Map  的 key 可以为 null,value 也可以为 null,注意 key 为 null,只能有一个，value 为 null,可以多个
- 常用 String 类作为 Map 的 key
- key 和 value 之间存在单向 一对一关系，即通过指定的 key 总能找到对应的 value
- Map 存放数据的 key - value 示意图，一对 k-v 是放在一个 HashMap$Node 中的，又因为 Node 实现了 Entry 接口，有些书上也说 一对 k - v 就是一个Entry

> ##### 代码示例

```java
@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        //Map 接口实现类的特点, 使用实现类HashMap
        //1. Map与Collection并列存在。用于保存具有映射关系的数据:Key-Value(双列元素)
        //2. Map 中的 key 和  value 可以是任何引用类型的数据，会封装到HashMap$Node 对象中
        //3. Map 中的 key 不允许重复，原因和HashSet 一样，前面分析过源码.
        //4. Map 中的 value 可以重复
        //5. Map 的key 可以为 null, value 也可以为null ，注意 key 为null,
        //   只能有一个，value 为null ,可以多个
        //6. 常用String类作为Map的 key
        //7. key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到对应的 value
        Map map = new HashMap();
        map.put("no1", "韩顺平");//k-v
        map.put("no2", "张无忌");//k-v
        map.put("no1", "张三丰");//当有相同的k , 就等价于替换.
        map.put("no3", "张三丰");//k-v
        map.put(null, null); //k-v
        map.put(null, "abc"); //等价替换
        map.put("no4", null); //k-v
        map.put("no5", null); //k-v
        map.put(1, "赵敏");//k-v
        map.put(new Object(), "金毛狮王");//k-v
        // 通过get 方法，传入 key ,会返回对应的value
        System.out.println(map.get("no2"));//张无忌

        System.out.println("map=" + map);



    }
}

```



#### Map 接口常用方法

##### remove

> 根据键 删除映射关系

```java
// remove:根据键删除映射关系
map.remove(null);
```



##### get 

> 根据键获取值

```java
// get： 根据键获取值
Object val = map.get("鹿晗");
System.out.println("val=" + val);
```



##### size

> 获取元素个数

```java
// size:获取元素个数
System.out.println("k-v=" + map.size());
```



##### isEmpty

> 判断个数是否为 0

```java
// isEmpty:判断个数是否为 0
System.out.println(map.isEmpty());//F
```



##### clear 

> 清除 k - v

```java
// clear:清除 k-v
//map.clear();
System.out.println("map=" + map);
```



##### containsKey

> 查找键是否存在

```java
// containsKey:查找键是否存在
System.out.println("结果=" + map.containsKey("csq"));//T
```



> ##### 代码示例

```java
@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        //演示map接口常用方法

        Map map = new HashMap();
        map.put("邓超", new Book("", 100));//OK
        map.put("邓超", "孙俪");//替换-> 一会分析源码
        map.put("王宝强", "马蓉");//OK
        map.put("宋喆", "马蓉");//OK
        map.put("刘令博", null);//OK
        map.put(null, "刘亦菲");//OK
        map.put("鹿晗", "关晓彤");//OK
        map.put("csq", "csqq");

        System.out.println("map=" + map);

//        remove:根据键删除映射关系
        map.remove(null);
        System.out.println("map=" + map);
//        get：根据键获取值
        Object val = map.get("鹿晗");
        System.out.println("val=" + val);
//        size:获取元素个数
        System.out.println("k-v=" + map.size());
//        isEmpty:判断个数是否为0
        System.out.println(map.isEmpty());//F
//        clear:清除k-v
        //map.clear();
        System.out.println("map=" + map);
//        containsKey:查找键是否存在
        System.out.println("结果=" + map.containsKey("csq"));//T


    }
}

class Book {
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

```



#### Map 接口遍历方法

> 比 List,Set 复杂点，但是基本原理都一样

> ##### 代码示例

```java
@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        //第一组: 先取出 所有的Key , 通过Key 取出对应的Value
        Set keyset = map.keySet();
        //(1) 增强for
        System.out.println("-----第一种方式-------");
        for (Object key : keyset) {
            System.out.println(key + "-" + map.get(key));
        }
        //(2) 迭代器
        System.out.println("----第二种方式--------");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组: 把所有的values取出
        Collection values = map.values();
        //这里可以使用所有的Collections使用的遍历方法
        //(1) 增强for
        System.out.println("---取出所有的value 增强for----");
        for (Object value : values) {
            System.out.println(value);
        }
        //(2) 迭代器
        System.out.println("---取出所有的value 迭代器----");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println(value);

        }

        //第三组: 通过EntrySet 来获取 k-v
        Set entrySet = map.entrySet();// EntrySet<Map.Entry<K,V>>
        //(1) 增强for
        System.out.println("----使用EntrySet 的 for增强(第3种)----");
        for (Object entry : entrySet) {
            //将entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        //(2) 迭代器
        System.out.println("----使用EntrySet 的 迭代器(第4种)----");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry =  iterator3.next();
            //System.out.println(next.getClass());//HashMap$Node -实现-> Map.Entry (getKey,getValue)
            //向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }


    }
}

```





#### Map 接口实现类 - HashMap

##### HashMap 小结

-  Map 接口的常用实现类 ： HashMap、HashTable 和 Properties
- HashMap 是 Map 接口使用频率最高的实现类
- HashMap 是以key - value 对的方式来存储数据（HashMap$Node 类型)
- key 不能重复，但是值可以重复，允许使用 null 键 和 null 值
- 如果添加相同的key ，则会覆盖原来的 key - val ，等同于修改（key 不会替换，val 会替换）
- 与 HashSet 一样，不保证映射的顺序，因为底层是以 hash 表的方式来存储的。（JDK 8 的hashMap 底层  : 数组 + 链表 + 红黑树)
- HashMap 没有实现同步，因此线程是不安全的，方法没有做同步互斥的操作，没有 synchronized



##### HashMap 底层机制及源码分析

> ###### 扩容机制

> ###### 代码示例

```java
@SuppressWarnings({"all"})
public class HashMapSource1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10);//ok
        map.put("php", 10);//ok
        map.put("java", 20);//替换value

        System.out.println("map=" + map);//

        /*解读HashMap的源码+图解
        1. 执行构造器 new HashMap()
           初始化加载因子 loadfactor = 0.75
           HashMap$Node[] table = null
        2. 执行put 调用 hash方法，计算 key的 hash值 (h = key.hashCode()) ^ (h >>> 16)
            public V put(K key, V value) {//K = "java" value = 10
                return putVal(hash(key), key, value, false, true);
            }
         3. 执行 putVal
         final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;//辅助变量
                //如果底层的table 数组为null, 或者 length =0 , 就扩容到16
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
                //取出hash值对应的table的索引位置的Node, 如果为null, 就直接把加入的k-v
                //, 创建成一个 Node ,加入该位置即可
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    Node<K,V> e; K k;//辅助变量
                // 如果table的索引位置的key的hash相同和新的key的hash值相同，
                 // 并 满足(table现有的结点的key和准备添加的key是同一个对象  || equals返回真)
                 // 就认为不能加入新的k-v
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    else if (p instanceof TreeNode)//如果当前的table的已有的Node 是红黑树，就按照红黑树的方式处理
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                        //如果找到的结点，后面是链表，就循环比较
                        for (int binCount = 0; ; ++binCount) {//死循环
                            if ((e = p.next) == null) {//如果整个链表，没有和他相同,就加到该链表的最后
                                p.next = newNode(hash, key, value, null);
                                //加入后，判断当前链表的个数，是否已经到8个，到8个，后
                                //就调用 treeifyBin 方法进行红黑树的转换
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash && //如果在循环比较过程中，发现有相同,就break,就只是替换value
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value; //替换，key对应value
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;//每增加一个Node ,就size++
                if (++size > threshold[12-24-48])//如size > 临界值，就扩容
                    resize();
                afterNodeInsertion(evict);
                return null;
            }

              5. 关于树化(转成红黑树)
              //如果table 为null ,或者大小还没有到 64，暂时不树化，而是进行扩容.
              //否则才会真正的树化 -> 剪枝
              final void treeifyBin(Node<K,V>[] tab, int hash) {
                int n, index; Node<K,V> e;
                if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                    resize();

            }
         */


    }
}

```



> ###### 模拟HashMap 触发扩容、树化情况

```java
@SuppressWarnings({"all"})
public class HashMapSource2 {
    public static void main(String[] args) {


        HashMap hashMap = new HashMap();
        for(int i = 1; i <= 12; i++) {
            hashMap.put(i, "hello");
        }

        hashMap.put("aaa", "bbb");

        System.out.println("hashMap=" + hashMap);//12个 k-v

        //布置一个任务，自己设计代码去验证，table 的扩容
        //0 -> 16(12) -> 32(24) -> 64(64*0.75=48)-> 128 (96) ->
        //自己设计程序，验证-》 增强自己阅读源码能力. 看别人代码.
    }
}

class A  {
    private int num;

    public A(int num) {
        this.num = num;
    }

    //所有的A对象的hashCode都是100
//    @Override
//    public int hashCode() {
//        return 100;
//    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}

```



#### Map 接口实现类 - HashTable

##### 基本介绍

- 存放的元素是键值对 ： 即 K - V
- HashTable 的键和值都不能为 null ，否则会抛出 NullPointerException
- HashTable 使用方法和 HashMap 一样
- HashTable 是线程安全的（synchronized)，hashMap 是线程不安全的



##### HashMap 和 HashTable 对比

|           | 版本 | 线程安全（同步） | 效率 | 允许null键null值 |
| --------- | ---- | ---------------- | ---- | ---------------- |
| HashMap   | 1.2  | 不安全           | 高   | 可以             |
| HashTable | 1.0  | 安全             | 较低 | 不可以           |



#### Map 接口实现类 - Properties

##### 基本介绍

- Properties 类 继承自 HashTable 类 并且实现了 Map 接口，也是使用一种 键值对的形式来保存数据的
- 他的使用特点和 HashTable 类似
- Properties 还可以用于 从 xxx.properties 文件中，加载数据到 Properties 类对象，并进行读取和修改
- xxx.properties 文件 通畅作为配置文件



##### 基本使用

```java
@SuppressWarnings({"all"})
public class Properties_ {
    public static void main(String[] args) {

        //解读
        //1. Properties 继承  Hashtable
        //2. 可以通过 k-v 存放数据，当然key 和 value 不能为 null
        //增加
        Properties properties = new Properties();
        //properties.put(null, "abc");//抛出 空指针异常
        //properties.put("abc", null); //抛出 空指针异常
        properties.put("john", 100);//k-v
        properties.put("lucy", 100);
        properties.put("lic", 100);
        properties.put("lic", 88);//如果有相同的key ， value被替换

        System.out.println("properties=" + properties);

        //通过k 获取对应值
        System.out.println(properties.get("lic"));//88

        //删除
        properties.remove("lic");
        System.out.println("properties=" + properties);

        //修改
        properties.put("john", "约翰");
        System.out.println("properties=" + properties);

        


    }
}

```



### 总结

---

> **在开发中，选择什么集合实现类，主要取决于 业务操作点，然后根据集合实现类特性进行选择**



#### 开发中如何选择集合实现类

- 先判断存储的类型（一组对象【单列】 或 一组键值对【双列】）
  - 一组对象【单列】： Collection 接口
    - 允许重复：List
      - 增删多：LinkedList【底层维护了一个双向链表】
      - 改查多：ArrayList 【底层维护 Object 类型的动态数组】
    - 不允许重复：Set
      - 无序：HashSet 【底层是 HashMap,维护了一个哈希表 即：数组+链表+红黑树
      - 排序：TreeSet
      - 插入和取出顺序一致：LinkedHashSet 【维护 数组 + 双向链表】
  - 一组键值对[双列] ： Map
    - 键无序：HashMap 【底层是 哈希表 JDK 7 ： 数组 + 链表 + 红黑树】
    - 键排序：TreeMap 
    - 键插入和取出顺序一致 ： LinkedHashMap
    - 读取文件 ：Properties

> ##### TreeSet代码示例

```java
@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {

        //解读
        //1. 当我们使用无参构造器，创建TreeSet时，仍然是无序的
        //2. 老师希望添加的元素，按照字符串大小来排序
        //3. 使用TreeSet 提供的一个构造器，可以传入一个比较器(匿名内部类)
        //   并指定排序规则
        //4. 简单看看源码
        //解读
        /*
        1. 构造器把传入的比较器对象，赋给了 TreeSet的底层的 TreeMap的属性this.comparator

         public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
         2. 在 调用 treeSet.add("tom"), 在底层会执行到

             if (cpr != null) {//cpr 就是我们的匿名内部类(对象)
                do {
                    parent = t;
                    //动态绑定到我们的匿名内部类(对象)compare
                    cmp = cpr.compare(key, t.key);
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else //如果相等，即返回0,这个Key就没有加入
                        return t.setValue(value);
                } while (t != null);
            }
         */

//        TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //下面 调用String的 compareTo方法进行字符串大小比较
                //如果老韩要求加入的元素，按照长度大小排序
                //return ((String) o2).compareTo((String) o1);
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        //添加数据.
        treeSet.add("jack");
        treeSet.add("tom");//3
        treeSet.add("sp");
        treeSet.add("a");
        treeSet.add("abc");//3


        System.out.println("treeSet=" + treeSet);

    }
}

```



> ##### TreeMap 代码示例

```java
@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {

        //使用默认的构造器，创建TreeMap, 是无序的(也没有排序)
        /*
            要求：按照传入的 k(String) 的大小进行排序
         */
//        TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照传入的 k(String) 的大小进行排序
                //按照K(String) 的长度大小排序
                //return ((String) o2).compareTo((String) o1);
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "斯密斯");
        treeMap.put("hsp", "韩顺平");//加入不了

        System.out.println("treemap=" + treeMap);

        /*

            解读源码：
            1. 构造器. 把传入的实现了 Comparator接口的匿名内部类(对象)，传给给TreeMap的comparator
             public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
            2. 调用put方法
            2.1 第一次添加, 把k-v 封装到 Entry对象，放入root
            Entry<K,V> t = root;
            if (t == null) {
                compare(key, key); // type (and possibly null) check

                root = new Entry<>(key, value, null);
                size = 1;
                modCount++;
                return null;
            }
            2.2 以后添加
            Comparator<? super K> cpr = comparator;
            if (cpr != null) {
                do { //遍历所有的key , 给当前key找到适当位置
                    parent = t;
                    cmp = cpr.compare(key, t.key);//动态绑定到我们的匿名内部类的compare
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else  //如果遍历过程中，发现准备添加Key 和当前已有的Key 相等，就不添加
                        return t.setValue(value);
                } while (t != null);
            }
         */

    }
}

```





### Collections 工具类

---



#### 工具类介绍

- Collections 是一个操作 Set 、List 和 Map 等集合的工具类
- Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作



#### 排序操作

##### reverse(List)

> 反转 List 中元素的顺序

```java
// reverse(List)： 反转 List 中元素的顺序
Collections.reverse(list);
```



##### shuffle(List)

> 对 List 集合元素进行随机排序

```java
// shuffle(List)： 对 List 集合元素进行随机排序
```



##### sort(List)

> 根据元素的自然顺序对指定 List 集合元素按升序排序

```java
// sort(List)： 根据元素的自然顺序对指定 List 集合元素按升序排序
Collections.sort(list);
```



##### sort(List,Comparator)

> 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序

```java
// sort(List， Comparator)： 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
//我们希望按照 字符串的长度大小排序
Collections.sort(list, new Comparator() {
@Override
public int compare(Object o1, Object o2) {
//可以加入校验代码.
return ((String) o2).length() - ((String) o1).length();
}
});
System.out.println("字符串长度大小排序=" + list);
// swap(List， int， int)： 将指定 list 集合中的 i 处元素和 j 处元素进行交换
```



##### swap(List,int,int)

> 将指定 List 集合中的 i 处 元素 和 j 处 元素进行交换

```java
// swap(List， int， int)： 将指定 list 集合中的 i 处元素和 j 处元素进行交换
//比如
Collections.swap(list, 0, 1);
System.out.println("交换后的情况");
System.out.println("list=" + list);
```



#### 查找、替换操作

##### Object max(Collection)

> 根据元素的自然顺序，返回给定集合中的最大元素

```java
//Object max(Collection)： 根据元素的自然顺序， 返回给定集合中的最大元素
System.out.println("自然顺序最大元素=" + Collections.max(list));
```



##### Object max(Collection,Comparator)

> 根据 Comparator 指定的顺序，返回给定集合中的最大元素

```java
//Object max(Collection， Comparator)： 根据 Comparator 指定的顺序， 返回给定集合中的最大元素
//比如， 我们要返回长度最大的元素
Object maxObject = Collections.max(list, new Comparator() {
    @Override
    public int compare(Object o1, Object o2) {
    return ((String)o1).length() - ((String)o2).length();
    }
});
    System.out.println("长度最大的元素=" + maxObject);
```



##### Object min(Collection

> 根据元素的自然顺序，返回给定集合中的最小元素





##### Object min(Collection,Comparator)

> 根据 Comparator 指定的顺序，返回给定集合中的最小元素





##### int frequency(Collection,Object)

> 返回指定集合中指定元素的出现次数

```java
//int frequency(Collection， Object)： 返回指定集合中指定元素的出现次数
System.out.println("tom 出现的次数=" + Collections.frequency(list, "tom"));
```



##### void copy(List dest,List src)

> 将 src 中的内容复制到 dest 中

```java
    //void copy(List dest,List src)： 将 src 中的内容复制到 dest 中
    ArrayList dest = new ArrayList();
    //为了完成一个完整拷贝， 我们需要先给 dest 赋值， 大小和 list.size()一样
    for(int i = 0; i < list.size(); i++) {
        dest.add("");
    } //
    拷贝
    Collections.copy(dest, list);
    System.out.println("dest=" + dest);
```



##### boolean replaceAll(List list,Onject oldVal,Object newVal)

> 使用新值替换 List 对象的所有旧值

```java
//boolean replaceAll(List list， Object oldVal， Object newVal)： 使用新值替换 List 对象的所有旧值
//如果 list 中， 有 tom 就替换成 汤姆
Collections.replaceAll(list, "tom", "汤姆");
```







## 泛型

> **泛型程序设计（Generic programing) 意味着编写的代码可以被很多不同类型的对象所重用**



### 泛型的介绍与好处

---

#### 泛型的好处

- 编译时，检查添加元素的类型，提高了安全性
- 减少了类型转换的次数，提高了效率
- 不再编译警告



> ##### 类比

- 不使用泛型：Dog - 加入 - > Object - 取出 - > Dog  //放入到ArrayList 会先转成 Object，在取出时，还需要转换成 Dog
- 使用泛型：Dog ->  Dog -> Dog // 放入时和取出时，不需要类型转换，提高效率

 

#### 泛型介绍

> ##### 理解 

 泛（广泛）型（类型） = > Integer,String....

- 泛型又称参数化类型，是 JDK 5.0 出现的新特性，解决数据类型的安全性问题
- 在类声明或实例化时只要指定好需要的具体的类型即可
- Java 泛型可以保证如果程序编译时如果没有发出警告，运行时就不会抛出 ClassCastException 异常。同时代码更加简洁，健壮
- 泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型

> ##### 代码示例

```java
public class Generic03 {
    public static void main(String[] args) {

        //注意，特别强调： E具体的数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型
        Person<String> person = new Person<String>("韩顺平教育");
        person.show(); //String

        /*
            你可以这样理解，上面的Person类
            class Person {
                String s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

                public Person(String s) {//E也可以是参数类型
                    this.s = s;
                }

                public String f() {//返回类型使用E
                    return s;
                }
            }
         */

        Person<Integer> person2 = new Person<Integer>(100);
        person2.show();//Integer

        /*
            class Person {
                Integer s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

                public Person(Integer s) {//E也可以是参数类型
                    this.s = s;
                }

                public Integer f() {//返回类型使用E
                    return s;
                }
            }
         */
    }
}

//泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，
// 或者是某个方法的返回值的类型，或者是参数类型

class Person<E> {
    E s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

    public Person(E s) {//E也可以是参数类型
        this.s = s;
    }

    public E f() {//返回类型使用E
        return s;
    }

    public void show() {
        System.out.println(s.getClass());//显示s的运行类型
    }
}
```





### 泛型的语法

---

#### 泛型的声明

```java
interface 接口 <T>{}
or
class 类 <K,V>{}
```



> ##### 说明

- 其中 T,K,V 不代表值，而是表示类型
- 任意字母都可以。常用 T 表示，是Type  的缩写



#### 泛型的实例化

> 要在类名后面指定类型参数的值（类型）。如：
>
> - List<String> strList = new ArrayList<String>();
> - Iterator<Customer> iterator = customer.iterator();



#### 泛型使用示例

```java
@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args) {
        //使用泛型方式给HashSet 放入3个学生对象
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("jack", 18));
        students.add(new Student("tom", 28));
        students.add(new Student("mary", 19));

        //遍历
        for (Student student : students) {
            System.out.println(student);
        }

        //使用泛型方式给HashMap 放入3个学生对象
        //K -> String V->Student
        HashMap<String, Student> hm = new HashMap<String, Student>();
        /*
            public class HashMap<K,V>  {}
         */
        hm.put("milan", new Student("milan", 38));
        hm.put("smith", new Student("smith", 48));
        hm.put("hsp", new Student("hsp", 28));

        //迭代器 EntrySet
        /*
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> es;
            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
         */
        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        /*
            public final Iterator<Map.Entry<K,V>> iterator() {
                return new EntryIterator();
            }
         */
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        System.out.println("==============================");
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
            
        }

    }
}
/**
 * 创建  3个学生对象
 * 放入到HashSet中学生对象, 使用.
 * 放入到  HashMap中，要求 Key 是 String name, Value 就是 学生对象
 * 使用两种方式遍历
 */
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```





### 泛型使用的注意事项和细节

---

- interface List<T>{} , public class HashSet<E>{}
  - 说明：T,E 只能是引用类型
- 在给泛型指定具体类型后，可以传入该类型或其子类类型
- 泛型使用形式
  - List<Integer> list1 = new ArrayList<Integer>();
  - List<Integer> list2 = new ArrayList<>();
- 如果写成  List list3 = new ArrayList<>(); 默认给它的 泛型是[<E>  E 就是 Object]

> #### 代码演示

```java
@SuppressWarnings({"all"})
public class GenericDetail {
    public static void main(String[] args) {
        //1.给泛型指向数据类型是，要求是引用类型，不能是基本数据类型
        List<Integer> list = new ArrayList<Integer>(); //OK
        //List<int> list2 = new ArrayList<int>();//错误

        //2. 说明
        //因为 E 指定了 A 类型, 构造器传入了 new A()
        //在给泛型指定具体类型后，可以传入该类型或者其子类类型
        Pig<A> aPig = new Pig<A>(new A());
        aPig.f();
        Pig<A> aPig2 = new Pig<A>(new B());
        aPig2.f();

        //3. 泛型的使用形式
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        //在实际开发中，我们往往简写
        //编译器会进行类型推断, 老师推荐使用下面写法
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        ArrayList<Pig> pigs = new ArrayList<>();

        //4. 如果是这样写 泛型默认是 Object
        ArrayList arrayList = new ArrayList();//等价 ArrayList<Object> arrayList = new ArrayList<Object>();

        /*
            public boolean add(Object e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }
         */
        Tiger tiger = new Tiger();
        /*

            class Tiger {//类
                Object e;

                public Tiger() {}

                public Tiger(Object e) {
                    this.e = e;
                }
            }

         */

    }
}
class Tiger<E> {//类
    E e;

    public Tiger() {}

    public Tiger(E e) {
        this.e = e;
    }
}

class A {}
class B extends A {}

class Pig<E> {//
    E e;

    public Pig(E e) {
        this.e = e;
    }

    public void f() {
        System.out.println(e.getClass()); //运行类型
    }
}
```





### 自定义泛型

---

#### 基本语法

```java
class 类名 <T,R...> { // 表示可以有多个泛型
    //成员
}
```



#### 细节

- 普通成员可以使用泛型（属性、方法）
- 使用泛型的数组不能初始化
- 静态方法中不能使用类的泛型
- 泛型类的类型,是在创建对象时确定的（因为创建对象时，需要指定类型）
- 如果在创建对象时，没有指定类型，默认为 Object

> ##### 代码示例

```java
@SuppressWarnings({"all"})
public class CustomGeneric_ {
    public static void main(String[] args) {

        //T=Double, R=String, M=Integer
        Tiger<Double,String,Integer> g = new Tiger<>("john");
        g.setT(10.9); //OK
        //g.setT("yy"); //错误，类型不对
        System.out.println(g);
        Tiger g2 = new Tiger("john~~");//OK T=Object R=Object M=Object
        g2.setT("yy"); //OK ,因为 T=Object "yy"=String 是Object子类
        System.out.println("g2=" + g2);

    }
}

//解读
//1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
//2, T, R, M 泛型的标识符, 一般是单个大写字母
//3. 泛型标识符可以有多个.
//4. 普通成员可以使用泛型 (属性、方法)
//5. 使用泛型的数组，不能初始化
//6. 静态方法中不能使用类的泛型
class Tiger<T, R, M> {
    String name;
    R r; //属性使用到泛型
    M m;
    T t;
    //因为数组在new 不能确定T的类型，就无法在内存开空间
    T[] ts;

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(R r, M m, T t) {//构造器使用泛型

        this.r = r;
        this.m = m;
        this.t = t;
    }

    public Tiger(String name, R r, M m, T t) {//构造器使用泛型
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    //因为静态是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM就无法完成初始化
//    static R r2;
//    public static void m1(M m) {
//
//    }

    //方法使用泛型

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {//方法使用到泛型
        this.r = r;
    }

    public M getM() {//返回类型可以使用泛型.
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}
```



#### 自定义泛型接口

##### 基本语法

```java
interface 接口名<T,R...>{
    
}
```

##### 细节

- 接口中，静态成员也不能使用泛型（这个和泛型规定一样）
- 泛型接口的类型，在 **继承接口** 或者 **实现接口** 时确定
- 没有指定类型，**默认为 Object**

> ###### 代码示例

```java
public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}

/**
 *  泛型接口使用的说明
 *  1. 接口中，静态成员也不能使用泛型
 *  2. 泛型接口的类型, 在继承接口或者实现接口时确定
 *  3. 没有指定类型，默认为Object
 */

//在继承接口 指定泛型接口的类型
interface IA extends IUsb<String, Double> {

}
//当我们去实现IA接口时，因为IA在继承IUsu 接口时，指定了U 为String R为Double
//，在实现IUsu接口的方法时，使用String替换U, 是Double替换R
class AA implements IA {

    @Override
    public Double get(String s) {
        return null;
    }
    @Override
    public void hi(Double aDouble) {

    }
    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}

//实现接口时，直接指定泛型接口的类型
//给U 指定Integer 给 R 指定了 Float
//所以，当我们实现IUsb方法时，会使用Integer替换U, 使用Float替换R
class BB implements IUsb<Integer, Float> {

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}
//没有指定类型，默认为Object
//建议直接写成 IUsb<Object,Object>
class CC implements IUsb { //等价 class CC implements IUsb<Object,Object> {
    @Override
    public Object get(Object o) {
        return null;
    }
    @Override
    public void hi(Object o) {
    }
    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }

}

interface IUsb<U, R> {

    int n = 10;
    //U name; 不能这样使用

    //普通方法中，可以使用接口泛型
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    //在jdk8 中，可以在接口中，使用默认方法, 也是可以使用泛型
    default R method(U u) {
        return null;
    }
}
```



#### 自定义泛型方法

```java
class Apple<T,R,M>{//自定义泛型类
    public<E>void fly(E e){//泛型方法
        System.out.println(e.getClass().getSimpleName());
    }
    public void eat(U u)//错误，因为U没有声明
    public void run(M m){}//ok
}
```



#### 泛型的继承和通配符说明

- 泛型不具有继承性
- <?> : 支持任意泛型类型
- <? extends A> : 支持 A 类 以及 A 类的子类，规定了泛型的上限
- <? super A> :  支持 A 类 以及 A 类的父类，不限于直接父类，规定了泛型的下限

> ##### 代码示例

```java
public class GenericExtends {
    public static void main(String[] args) {

        Object o = new String("xx");

        //泛型没有继承性
        //List<Object> list = new ArrayList<String>();

        //举例说明下面三个方法的使用
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //如果是 List<?> c ，可以接受任意的泛型类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //List<? extends AA> c： 表示 上限，可以接受 AA或者AA子类
//        printCollection2(list1);//×
//        printCollection2(list2);//×
        printCollection2(list3);//√
        printCollection2(list4);//√
        printCollection2(list5);//√

        //List<? super AA> c: 支持AA类以及AA类的父类，不限于直接父类
        printCollection3(list1);//√
        //printCollection3(list2);//×
        printCollection3(list3);//√
        //printCollection3(list4);//×
        //printCollection3(list5);//×


        //冒泡排序

        //插入排序

        //....


    }
    // ? extends AA 表示 上限，可以接受 AA或者AA子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

    //说明: List<?> 表示 任意的泛型类型都可以接受
    public static void printCollection1(List<?> c) {
        for (Object object : c) { // 通配符，取出时，就是Object
            System.out.println(object);
        }
    }



    // ? super 子类类名AA:支持AA类以及AA类的父类，不限于直接父类，
    //规定了泛型的下限
    public static void printCollection3(List<? super AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

}

class AA {
}

class BB extends AA {
}

class CC extends BB {
}
```





### JUnit

---

#### 为什么需要 JUit

- 一个类有很多功能代码需要测试，为了测试，就需要写入到 main 方法中
- 如果有很多个功能代码测试，就需要来回注释，切换很麻烦
- 如果直接运行一个方法，就方便很多，并且给出相关信息就好了 -> JUit



#### 基本介绍

- JUit 是一个 Java 语言的单元测试框架
- 多数 Java 的开发环境都已经继承了 JUit 作为单元测试的工具

> ##### 代码示例

```java
public class JUnit_ {
    public static void main(String[] args) {
        //传统方式
        //new JUnit_().m1();
        //new JUnit_().m2();

    }


    @Test
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }

    @Test
    public void m3() {
        System.out.println("m3方法被调用");
    }
}
```



## JAVA 事件处理机制





### 基本说明

---

> java 事件处理是采取 “ 委派事件模型”。当事件发生时，产生事件的对象，会把此 “ 信息” 传递给 “ 事件的监听者 ” 处理，这里所说的 “信息” ，实际上就是 java.awt.event 事件类库里某个类所创建的对象，把它称为 " 事件的对象"



#### 示意图

事件源 ---- 事件/对象  ---- 事件监听者【事件处理方法】



#### 事件处理机制深入理解

- 事件源：事件源就是一个产生事件的对象，比如按钮，窗口等
- 事件：事件就是承载事件源状态改变时的对象，比如当键盘事件，鼠标事件，窗口事件等等，会生成一个事件对象，该对象保存着当前事件很多信息，比如 KeyEvent 对象有含有被按下键的 code 值。java.awt.event 包  和 javax.swing,event 包中定义类各种事件类型
- 事件类型：查阅jdk 文档
- 事件监听器接口
  - 当事件源产生一个事件，可以传送给事件监听者处理
  - 事件监听者实际上就是一个类，该类实现了某个事件监听器接口，比如前面所说的 MyPanle 就是一个类，他实现了 KeyListener 接口，他就可以作为 一个事件监听者，对接收到的事件进行处理
  - 事件监听器接口有很多种，不同的事件监听器接口可以监听不同的事件，一个类可以实现多个监听接口
  - 这些接口在 java.awt.event 包  和 javax.swing.event 包中定义







## 多线程基础



### 线程相关概念

---

- #### 程序

  ​		是为完成特定任务、用某种语言编写的一组指令的集合。- 代码

- #### 进程

  - 进程是指运行中的程序，比如我们使用QQ,就启动了一个进程，操作系统就会为
    该进程分配内存空间。当我们使用迅雷，又启动了一个进程，操作系统将为迅雷分
    配新的内存空间。
  - 进程是程序的一次执行过程，或是正在运行的一个程序。是动态过程：有它自身的
    产生、存在和消亡的过程

- #### 什么是线程

  - 线程由进程创建的，是进程的一个实体
  - 一个进程可以拥有多个线程

- #### 其他相关概念

  - ##### 单线程

    ​			同一时刻，只允许执行一个线程

  - ##### 多线程

     					同一时刻，可以执行多个线程，比如：一个qq进程，可以同时打开多个聊天窗口，一个迅雷进程，可以同时下载多个文件

  - ##### 并发

    ​	 	同一时刻，多个任务交替执行，造成一种 "貌似同时" 的错觉，简单来说，单核 cpu 实现的多任务就是并发

  - ##### 并行

    ​		同一时刻，多个任务同时执行，多核cpu可以实现并行





### 线程基本使用

---

#### 创建线程的两种方式

- 继承 Thread 类，重写 run 方法
- 实现 Runnable 接口，重写 run 方法





#### 继承 Thread 类

##### 说明

- 当一个类继承了 Thread 类， 该类就可以当做线程使用
-  我们会重写 run 方法， 写上自己的业务代码
- run Thread 类 实现了 Runnable 接口的 run 方法  

> ##### 代码示例

```java
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {

        //创建Cat对象，可以当做线程使用
        Cat cat = new Cat();

        //源码
        /*
            (1)
            public synchronized void start() {
                start0();
            }
            (2)
            //start0() 是本地方法，是JVM调用, 底层是c/c++实现
            //真正实现多线程的效果， 是start0(), 而不是 run
            private native void start0();

         */

        cat.start();//启动线程-> 最终会执行cat的run方法



        //cat.run();//run方法就是一个普通的方法, 没有真正的启动一个线程，就会把run方法执行完毕，才向下执行
        //说明: 当main线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行
        //这时 主线程和子线程是交替执行..
        System.out.println("主线程继续执行" + Thread.currentThread().getName());//名字main
        for(int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }

    }
}

//说明
//1. 当一个类继承了 Thread 类， 该类就可以当做线程使用
//2. 我们会重写 run方法，写上自己的业务代码
//3. run Thread 类 实现了 Runnable 接口的run方法
/*
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 */



class Cat extends Thread {

    int times = 0;
    @Override
    public void run() {//重写run方法，写上自己的业务逻辑

        while (true) {
            //该线程每隔1秒。在控制台输出 “喵喵, 我是小猫咪”
            System.out.println("喵喵, 我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());
            //让该线程休眠1秒 ctrl+alt+t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 80) {
                break;//当times 到80, 退出while, 这时线程也就退出..
            }
        }
    }
}
```





#### 实现 Runnable 接口

##### 说明

- java 是单继承的，在某些情况下下一个类可能已经继承了某个父类，这时在用继承 Thread 类方法来创建线程显然已经不可能了
- java 设计者们提供了另外一个方式来创建线程，就是通过实现 Runnable 接口来创建线程

> ##### 代码示例

```java
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start(); 这里不能调用start
        //创建了Thread对象，把 dog对象(实现Runnable),放入Thread
        Thread thread = new Thread(dog);
        thread.start();

//        Tiger tiger = new Tiger();//实现了 Runnable
//        ThreadProxy threadProxy = new ThreadProxy(tiger);
//        threadProxy.start();
    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {

    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫....");
    }
}

//线程代理类 , 模拟了一个极简的Thread类
class ThreadProxy implements Runnable {//你可以把Proxy类当做 ThreadProxy

    private Runnable target = null;//属性，类型是 Runnable

    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定（运行类型Tiger）
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();//这个方法时真正实现多线程方法
    }

    public void start0() {
        run();
    }
}


class Dog implements Runnable { //通过实现Runnable接口，开发线程

    int count = 0;

    @Override
    public void run() { //普通方法
        while (true) {
            System.out.println("小狗汪汪叫..hi" + (++count) + Thread.currentThread().getName());

            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }
}
```



#### 继承 Thread 类 和 实现 Runnable 接口的区别

- 从 java 的设计来看，通过继承 Thread 类 或 实现 Runnable 接口来创建线程本质上没有区别，从 jdk 帮助文档我们可以看到 Thread 类 本身就实现了 Runnable 接口
- 实现 Runnable 接口方式更加适合多个线程共享一个资源的情况，并且避免了 单继承的限制，建议使用 Runnable 



### 线程终止

---



#### 基本说明

- 当线程完成任务后，会自动退出
- 还可以通过 使用变量 来控制 run 方法退出的方式停止线程，即通知方式

> ##### 代码示例

```java
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        //如果希望main线程去控制t1 线程的终止, 必须可以修改 loop
        //让t1 退出run方法，从而终止 t1线程 -> 通知方式

        //让主线程休眠 10 秒，再通知 t1线程退出
        System.out.println("main线程休眠10s...");
        Thread.sleep(10 * 1000);
        t1.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    //设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {

            try {
                Thread.sleep(50);// 让当前线程休眠50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中...." + (++count));
        }

    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
```







### 线程常用方法

---



#### 用户线程和守护线程

- 用户线程：也叫工作线程当线程的任务执行完或通知方式结束
- 守护线程：一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
- 常见的守护线程：垃圾回收机制 



> ##### 代码示例

```java
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望当main线程结束后，子线程自动结束
        //,只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        for( int i = 1; i <= 10; i++) {//main线程
            System.out.println("宝强在辛苦的工作...");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    public void run() {
        for (; ; ) {//无限循环
            try {
                Thread.sleep(1000);//休眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋喆快乐聊天，哈哈哈~~~");
        }
    }
} 
```







#### 常用方法第一组

##### setName 

> 设置线程名称，使之与参数 name 相同

##### getName

> 返回该线程的名称

##### start

> 使该线程开始执行；Java虚拟机底层调用该线程的 start0 方法

##### run

> 调用线程对象的 run 方法

##### setPriority

> 更改线程的优先级

##### getPriority 

> 获取线程的优先级

##### sleep 

> 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）

##### interrupt

> 中断线程



#### 注意事项和细节

- start 底层会创建新的线程，调用 run ，run 就是一个简单的方法调用，不会启动新的线程
- 线程的优先级范围
- interrupt ，中断线程，但并没有真正的结束线程。所以一般用于中断正在休眠线程
- sleep ： 线程的静态方法，使当前线程休眠



> ##### 代码示例

```java
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        //测试相关的方法
        T t = new T();
        t.setName("csq");
        t.setPriority(Thread.MIN_PRIORITY);//1
        t.start();//启动子线程


        //主线程打印5 hi ,然后我就中断 子线程的休眠
        for(int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        System.out.println(t.getName() + " 线程的优先级 =" + t.getPriority());//1

        t.interrupt();//当执行到这里，就会中断 t线程的休眠.



    }
}

class T extends Thread { //自定义的线程类
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                //Thread.currentThread().getName() 获取当前线程的名称
                System.out.println(Thread.currentThread().getName() + "  吃包子~~~~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(20000);//20秒
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt 方法时，就会catch 一个 异常, 可以加入自己的业务代码
                //InterruptedException 是捕获到一个中断异常.
                System.out.println(Thread.currentThread().getName() + "被 interrupt了");
            }
        }
    }
}
```



#### 常用方法第二组

##### yield 

> 线程的礼让。让出 cpu,让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功

##### join 

> 线程的插队。插队的线程一旦成功，则肯定先执行完插入的线程所有的任务



> ###### 案例
>
> 先执行完插入的线程所有的任务
> 案例：main线程创建一个子线程，
> 每隔1s输出hello,
> 输出20次，主线程每隔1秒，输出hi,输出20次.要求：
> 两个线程同时执行，当主线程输出5次后，就让子线程
> 运行完毕，主线程再继续，



> #### 代码示例

```java
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {

        T2 t2 = new T2();
        t2.start();

        for(int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程(小弟) 吃了 " + i  + " 包子");
            if(i == 5) {
                System.out.println("主线程(小弟) 让 子线程(老大) 先吃");
                //join, 线程插队
                //t2.join();// 这里相当于让t2 线程先执行完毕
                Thread.yield();//礼让，不一定成功..
                System.out.println("线程(老大) 吃完了 主线程(小弟) 接着吃..");
            }

        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);//休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(老大) 吃了 " + i +  " 包子");
        }
    }
}
```





### 线程的生命周期

---

> JDK 中用 Thread.State 枚举了几种线程状态





#### 线程状态转换图

![image-20220630175125221](D:\C\Java\com\out\image-20220630175125221.png)



#### 线程状态

- ##### NEW

  尚未启动的线程处于此状态。

- ##### RUNNABLE

  在Java虚拟机中执行的线程处于此状态。

- ##### BLOCKED

  被阻塞等待监视器锁定的线程处于此状态。

- ##### WAITING

  正在等待另一个线程执行特定动作的线程处于此状态。

- ##### TIMED WAITING

  正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。

- ##### TERMINATED

  已退出的线程处于此状态。







### 线程的同步

---



#### Synchronized

##### 线程同步机制

- 在多线程编程，一些敏感数据不允许被多个线程同时访问，此时就使用同步访问技术，保证数据在任何同一时刻，最多有一个线程访问，以保证数据的完整性
- 也可以这里理解：线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，直到该线程完成操作，其他线程才能对该内存地址进行操作



##### 同步具体方法 - Synchronized

1. 同步代码块

   **syschronized(对象) { //得到对象的锁，才能操作同步代码**

   ​	**//需要被同步代码**

   **}**

2. synchronized 还可以放在 方法声明中，表示整个方法  - 为 同步方法

   **public synchronized void m (String name){**	

   ​	**// 需要被同步代码**

   **}**



> ##### 代码示例

```java

/**
 * @author C7eric
 * @version 1.0
 * 使用多线程，模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {

        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //这里我们会出现超卖..
//        sellTicket01.start();//启动售票线程
//        sellTicket02.start();//启动售票线程
//        sellTicket03.start();//启动售票线程


//        System.out.println("===使用实现接口方式来售票=====");
//        SellTicket02 sellTicket02 = new SellTicket02();
//
//        new Thread(sellTicket02).start();//第1个线程-窗口
//        new Thread(sellTicket02).start();//第2个线程-窗口
//        new Thread(sellTicket02).start();//第3个线程-窗口

        //测试一把
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第1个线程-窗口
        new Thread(sellTicket03).start();//第2个线程-窗口
        new Thread(sellTicket03).start();//第3个线程-窗口

    }
}


//实现接口方式, 使用synchronized实现线程同步
class SellTicket03 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum
    private boolean loop = true;//控制run方法变量
    Object object = new Object();


    //同步方法（静态的）的锁为当前类本身
    //解读
    //1. public synchronized static void m1() {} 锁是加在 SellTicket03.class
    //2. 如果在静态方法中，实现一个同步代码块.
    /*
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1() {

    }
    public static  void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    //说明
    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象
    public /*synchronized*/ void sell() { //同步方法, 在同一时刻， 只能有一个线程来执行sell方法

        synchronized (/*this*/ object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2
        }
    }

    @Override
    public void run() {
        while (loop) {

            sell();//sell方法是一共同步方法
        }
    }
}

//使用Thread方式
// new SellTicket01().start()
// new SellTicket01().start();
class SellTicket01 extends Thread {

    private static int ticketNum = 100;//让多个线程共享 ticketNum

//    public void m1() {
//        synchronized (this) {
//            System.out.println("hello");
//        }
//    }

    @Override
    public void run() {


        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));

        }
    }
}


//实现接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2

        }
    }
}

```





### 分析同步原理

---







### 互斥锁

---



#### 基本介绍

- Java 语言中，引入了 对象互斥锁的概念，来保证共享数据操作的完整性
- 每个对象都对应于一个可称为 “ 互斥锁” 的标记，这个标记 用来保证在任一时刻，只能有一个线程访问该对象
- 关键字 synchronized 来与对象的互斥锁联系。当某个对象用 synchronized 修饰时，表明该对象在任一时刻只能由一个线程访问
- 同步的局限性：导致程序的执行效率 要降低
- 同步方法（非静态的）的锁可以是 this ，也可以是其他对象（要求是同一个对象）
- 同步方法（静态的）的锁为当前类本身



#### 注意事项和细节

- 同步方法如果没有用 static 修饰：默认锁对象为 this 
- 如果方法使用 static 修饰，，默认锁对象：当前类.class
- 实现的落地步骤
  - 需要先分析上锁的代码
  - 选择 同步代码块或者 同步方法
  - 要求多个线程的锁对象w为同一个即可



> ##### 代码示例

```java
public class SellTicket {
    public static void main(String[] args) {

        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //这里我们会出现超卖..
//        sellTicket01.start();//启动售票线程
//        sellTicket02.start();//启动售票线程
//        sellTicket03.start();//启动售票线程


//        System.out.println("===使用实现接口方式来售票=====");
//        SellTicket02 sellTicket02 = new SellTicket02();
//
//        new Thread(sellTicket02).start();//第1个线程-窗口
//        new Thread(sellTicket02).start();//第2个线程-窗口
//        new Thread(sellTicket02).start();//第3个线程-窗口

        //测试一把
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第1个线程-窗口
        new Thread(sellTicket03).start();//第2个线程-窗口
        new Thread(sellTicket03).start();//第3个线程-窗口

    }
}


//实现接口方式, 使用synchronized实现线程同步
class SellTicket03 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum
    private boolean loop = true;//控制run方法变量
    Object object = new Object();


    //同步方法（静态的）的锁为当前类本身
    // 解读
    //1. public synchronized static void m1() {} 锁是加在 SellTicket03.class
    //2. 如果在静态方法中，实现一个同步代码块.
    /*
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1() {

    }
    public static  void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    //说明
    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象
    public /*synchronized*/ void sell() { //同步方法, 在同一时刻， 只能有一个线程来执行sell方法

        synchronized (/*this*/ object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2
        }
    }

    @Override
    public void run() {
        while (loop) {

            sell();//sell方法是一共同步方法
        }
    }
}

//使用Thread方式
// new SellTicket01().start()
// new SellTicket01().start();
class SellTicket01 extends Thread {

    private static int ticketNum = 100;//让多个线程共享 ticketNum

//    public void m1() {
//        synchronized (this) {
//            System.out.println("hello");
//        }
//    }

    @Override
    public void run() {


        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));

        }
    }
}


//实现接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2

        }
    }
}

```







### 线程的死锁

---



#### 基本介绍

> 多个线程都占用了对方的锁资源，但不肯相让，导致了死锁，在编程时一定要避免死锁的发生



> ##### 代码示例

```java
/**
 * @author C7eric
 * @version 1.0
 * 模拟线程死锁
 */
public class DeadLock_ {
    public static void main(String[] args) {
        //模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");
        A.start();
        B.start();
    }
}


//线程
class DeadLockDemo extends Thread {
    static Object o1 = new Object();// 保证多线程，共享一个对象,这里使用static
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {//构造器
        this.flag = flag;
    }

    @Override
    public void run() {

        //下面业务逻辑的分析
        //1. 如果flag 为 T, 线程A 就会先得到/持有 o1 对象锁, 然后尝试去获取 o2 对象锁
        //2. 如果线程A 得不到 o2 对象锁，就会Blocked
        //3. 如果flag 为 F, 线程B 就会先得到/持有 o2 对象锁, 然后尝试去获取 o1 对象锁
        //4. 如果线程B 得不到 o1 对象锁，就会Blocked
        if (flag) {
            synchronized (o1) {//对象互斥锁, 下面就是同步代码
                System.out.println(Thread.currentThread().getName() + " 进入1");
                synchronized (o2) { // 这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName() + " 进入2");
                }
                
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3");
                synchronized (o1) { // 这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName() + " 进入4");
                }
            }
        }
    }
}
```







### 释放锁

---



#### 会释放锁的操作

- 当前线程的同步方法、同步代码块执行结束
  案例：上厕所，完事出来
- 当前线程在同步代码块、同步方法中遇到break、return。.
  案例：没有正常的完事，经理叫他修改bug,不得已出来
- 当前线程在同步代码块、
  同步方法中出现了未处理的Error?或Exception,导致异常结束
  案例：没有正常的完事，发现忘带纸，不得已出来
- 当前线程在同步代码块、同步方法中执行了线程对象的wait0方法，当前线程暂停，并释
  放锁。
  案例：没有正常完事，觉得需要酝酿下，所以出来等会再进去



#### 不会释放锁的操作

- 线程执行同步代码块或同步方法时，

  程序调用Thread.sleep()、Thread.yield()方法暂停当前线程的执行，不会释放锁

  案例：上厕所，太困了，在坑位上眯了一会

  

- 线程执行同步代码块时，其他线程调用了该线程的suspend0方法将该线程挂起，该线程不会释放锁。

  提示：应尽量避免使用suspend()和resume0来控制线程，方法不再推荐使用



> ##### 案例

```java
public class Homework02 {
    public static void main(String[] args) {
        T t = new T();
        Thread thread1 = new Thread(t);
        thread1.setName("t1");
        Thread thread2 = new Thread(t);
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }
}

//编程取款的线程
//1.因为这里涉及到多个线程共享资源，所以我们使用实现Runnable方式
//2. 每次取出 1000
class T implements  Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {

            //解读
            //1. 这里使用 synchronized 实现了线程同步
            //2. 当多个线程执行到这里时，就会去争夺 this对象锁
            //3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块, 执行完后，会释放this对象锁
            //4. 争夺不到this对象锁，就blocked ，准备继续争夺
            //5. this对象锁是非公平锁.

            synchronized (this) {//
                //判断余额是否够
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取出了1000 当前余额=" + money);
            }

            //休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```











## IO 流





### 文件

---

#### 什么是文件

文件是保存数据的地方，比如常用的 Word 文档，txt 文档... 都是文件，它即可以保存一张照片，也可以保存视频，音频...



#### 文件流

文件在程序中是以流的方式来操作的 

- Java 程序（内存）----(输出流) ---->  文件（磁盘）
- 文件（磁盘）----（输入流）----> Java 程序（内存）



##### 流

数据在数据源（文件）和程序（内存）之间经历的路径



##### 输入流

数据从数据源（文件） 到程序（内存）的路径



##### 输出流

数据从程序（内存）到数据源（文件）的路径



### 常用的文件操作

---



#### 创建文件对象相关构造器 和 方法

##### new File(String pathname) 

> 根据路径构建一个 File 对象

```java
//方式1 new File(String pathname)
    @Test
    public void create01() {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
```





##### new File(File parent,String child)

> 根据父目录文件 + 子路径构建

```java
//方式2 new File(File parent,String child) //根据父目录文件+子路径构建
    //e:\\news2.txt
    @Test
    public  void create02() {
        File parentFile = new File("e:\\");
        String fileName = "news2.txt";
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile 方法，才会真正的，在磁盘创建该文件
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```





##### new File(String parent,String child)

>  根据父目录 + 子路径 构建

```java
//方式3 new File(String parent,String child) //根据父目录+子路径构建
    @Test
    public void create03() {
        //String parentPath = "e:\\";
        String parentPath = "e:\\";
        String fileName = "news4.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```





#### 获取文件的相关信息

##### getName



##### getAbsolutePath  



##### getParent  



##### length 



##### exists 



##### isFlie 



##### isDirectory







#### 目录的操作和文件删除

##### mkdir



##### mkdirs



##### delete

 





### IO 流原理及流的分类

---



#### Java IO 流原理

- I / O 是 Input / Output 的缩写，I / O 技术是非常实用的技术，用于处理数据传输。如读写文件，网络通讯等
- Java 程序中，对于数据的输入 / 输出操作以  "流（Stream）" 的方式进行。
- Java.io 包下提供了各种 “流” 类 和接口，用以获取不同种类的数据，并通过方法输入或输出数据
- 输入 input : 读取外部数据（磁盘、光盘等存储设备的数据） 到 程序（内存）中
- 输出 output ：将程序（内存）中的数据输出到磁盘、光盘等存储设备中





#### 流的分类

- 按操作数据单位不同分为 ： 
  - 字节流（8 bit ) 二进制文件
  - 字符流（按字符）文本文件
- 按数据流的流向不同分为：
  - 输入流
  - 输出流
- 按流的角色不同分为：
  - 节点流
  - 处理流 / 包装流



| 抽象基类 | 字节流       | 字符流 |
| -------- | ------------ | ------ |
| 输入流   | InputStream  | Reader |
| 输出流   | OutputStream | Writer |

- Java 的 IO 流共涉及 40多个类，实际上非常规则，都是从如上 四个抽象基类派生的
- 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀





### IO流体系

---



#### Java IO 流

- ##### 字节流

  - InputStream
    - FileStream
    - PipedInputStream
    - ObjectInputStream
    - ByteArrayInputStream
    - SequenceInputStream
    - FilterInputStream
      - BufferedInputStream
      - DigestInuputStream
      - DataInputStream
  - OutputStream
    - FileOutputStream
    - PipedOutputStream
    - ObjectOutputStream
    - ByteArrayOutputStream
    - FilterOutputStream
      - BufferedOutputStream
      - DigestOutuputStream
      - DataOutputStream
      - PrintStream

- ##### 字符流

  - Reader
    - InputStreamReader
      - FileReader
    - BufferedReader
    - CharArrayReader
    - FilterReader
    - PipedReader
    - StringReader
  - Writer
    - OutputStreamWriter
      - FileWriter
    - BufferedWriter
    - CharArrayWriter
    - FilterWriter
    - PipedWriter
    - StringWriter



#### 文件 vs 流







### 常用类

---



#### FileInputStream

##### FileInputStream 应用实例

```java
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示读取文件...
     * 单个字节的读取，效率比较低
     * -> 使用 read(byte[] b)
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。 如果没有输入可用，此方法将阻止。
            //如果返回-1 , 表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char)readData);//转成char显示
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用 read(byte[] b) 读取文件，提高效率
     */
    @Test
    public void readFile02() {
        String filePath = "e:\\hello.txt";
        //字节数组
        byte[] buf = new byte[8]; //一次读取8个字节.
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
            //如果返回-1 , 表示读取完毕
            //如果读取正常, 返回实际读取的字节数
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));//显示
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
```





#### FileOutputStream

##### FileOutputStream 应用实例

```java
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    /**
     * 演示使用FileOutputStream 将数据写到文件中,
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile() {

        //创建 FileOutputStream对象
        String filePath = "e:\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //得到 FileOutputStream对象 对象
            //说明
            //1. new FileOutputStream(filePath) 创建方式，当写入内容是，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容是，是追加到文件后面
            fileOutputStream = new FileOutputStream(filePath, true);
            //写入一个字节
            //fileOutputStream.write('H');//
            //写入字符串
            String str = "hsp,world!";
            //str.getBytes() 可以把 字符串-> 字节数组
            //fileOutputStream.write(str.getBytes());
            /*
            write(byte[] b, int off, int len) 将 len字节从位于偏移量 off的指定字节数组写入此文件输出流
             */
            fileOutputStream.write(str.getBytes(), 0, 3);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java
public class FileCopy {
    public static void main(String[] args) {
        //完成 文件拷贝，将 e:\\Koala.jpg 拷贝 c:\\
        //思路分析
        //1. 创建文件的输入流 , 将文件读入到程序
        //2. 创建文件的输出流， 将读取到的文件数据，写入到指定的文件.
        String srcFilePath = "e:\\Koala.jpg";
        String destFilePath = "e:\\Koala3.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //定义一个字节数组,提高读取效果
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //读取到后，就写入到文件 通过 fileOutputStream
                //即，是一边读，一边写
                fileOutputStream.write(buf, 0, readLen);//一定要使用这个方法

            }
            System.out.println("拷贝ok~");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输入流和输出流，释放资源
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```







#### FlieReader

##### 相关方法

###### new FileReader(File/String)



###### read

> 每次读取单个字符，返回该字符，如果到文件末尾返回 -1



###### read(char[])

> 批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾返回 -1



##### 相关 API

- new String (char[]) : 将 char[] 转换成 String
- new  String (char[],off,len) : 将 char[] 的指定部分转换成 String



#### FileWriter

##### 常用方法

###### new FileWriter(File / String)

> 覆盖模式，相当于流的指针在首端



###### new FileWriter(File/String,true)

> 追加模式，相当于流的指针在尾端



###### write(int)

> 写入单个字符



###### write（char[])

> 写入指定数组



###### write(char[],off,len)

> 写入指定数组的指定部分



###### write(String)

> 写入整个字符串



###### write( String,off,len)

> 写入字符串的指定部分



##### 相关 API

- String 类：toCharArray : 将String 转换成 char[]



##### 注意事项

FileWriter 使用后，必须要关闭（close）或刷新（flush)，否则写入不到指定的文件



#### FileReader 和 FileWriter 应用案例

##### 使用 FileReader 从 story.txt 读取内容， 并显示  

```java
public class FileReader_ {
    public static void main(String[] args) {


    }

    /**
     * 单个字符读取文件
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        //1. 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read, 单个字符读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符数组读取文件
     */
    @Test
    public void readFile02() {
        System.out.println("~~~readFile02 ~~~");
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;

        int readLen = 0;
        char[] buf = new char[8];
        //1. 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read(buf), 返回的是实际读取到的字符数
            //如果返回-1, 说明到文件结束
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

##### 使用 FileWriter 将 “风雨之后， 定见彩虹” 写入到 note.txt 文件中  

```java
public class FileWriter_ {
    public static void main(String[] args) {

        String filePath = "e:\\note.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
//            3) write(int):写入单个字符
            fileWriter.write('H');
//            4) write(char[]):写入指定数组
            fileWriter.write(chars);
//            5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);
//            6) write（string）：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");
//            7) write(string,off,len):写入字符串的指定部分
            fileWriter.write("上海天津", 0, 2);
            //在数据量大的情况下，可以使用循环操作.


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //对应FileWriter , 一定要关闭流，或者flush才能真正的把数据写入到文件
            //看源码.
            /*
                看看代码
                private void writeBytes() throws IOException {
        this.bb.flip();
        int var1 = this.bb.limit();
        int var2 = this.bb.position();

        assert var2 <= var1;

        int var3 = var2 <= var1 ? var1 - var2 : 0;
        if (var3 > 0) {
            if (this.ch != null) {
                assert this.ch.write(this.bb) == var3 : var3;
            } else {
                this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
            }
        }

        this.bb.clear();
    }
             */
            try {
                //fileWriter.flush();
                //关闭文件流，等价 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println("程序结束...");


    }
}
```





### 节点流和处理流

---



#### 基本介绍

- 节点流k可以从一个特定的数据源读写数据
- 处理流（也叫包装流）是 “连接” 在已存在的流 （节点流或处理流）之上，为程序提供更为强大的读写功能，也更加灵活



#### 节点流和处理流的区别和联系

- 节点流是底层流/低级流，直接与数据源连接
- 处理流（包装流）包装节点流，既可以消除不同节点流的实现差异，也可以 提供更方便的方法来完成输入输出
- 处理流（包装流）对节点流进行包装，使用了修饰器设计模式，不会直接与数据源相连



#### 处理流的主要功能

- 性能的提高：主要以增加缓冲的方式来提高输入输出的效率
- 操作的便捷：处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据，使用更加灵活方便



#### 处理流 BufferedReader 和 BufferedWriter

- BufferedReader 和 BufferedWriter 属于字节流，是按照字符来读取数据的
- 关闭处理流时，只需要关闭外层流即可



> ##### 代码示例

```java
public class BufferedReader_ {
    public static void main(String[] args) throws Exception {

        String filePath = "e:\\a.java";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line; //按行读取, 效率高
        //说明
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流
        //FileReader。
        /*
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了.
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }

         */
        bufferedReader.close();

    }
}	
```



> ##### BufferedWriter 示例

```java
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\ok.txt";
        //创建BufferedWriter
        //说明:
        //1. new FileWriter(filePath, true) 表示以追加的方式写入
        //2. new FileWriter(filePath) , 表示以覆盖的方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hello, csq!");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello2, csqq!");
        bufferedWriter.newLine();
        bufferedWriter.write("hello3, csqqq!");
        bufferedWriter.newLine();

        //说明：关闭外层流即可 ， 传入的 new FileWriter(filePath) ,会在底层关闭
        bufferedWriter.close();

    }
}
```



> ##### BufferedReader 和 BufferedWriter 完成文本文件拷贝

```java
public class BufferedCopy_ {

    public static void main(String[] args) {


        //老韩说明
        //1. BufferedReader 和 BufferedWriter 是安装字符操作
        //2. 不要去操作 二进制文件[声音，视频，doc, pdf ], 可能造成文件损坏
        //BufferedInputStream
        //BufferedOutputStream
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a2.java";
//        String srcFilePath = "e:\\0245_韩顺平零基础学Java_引出this.avi";
//        String destFilePath = "e:\\a2韩顺平.avi";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            //说明: readLine 读取一行内容，但是没有换行
            while ((line = br.readLine()) != null) {
                //每读取一行，就写入
                bw.write(line);
                //插入一个换行
                bw.newLine();
            }
            System.out.println("拷贝完毕...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(br != null) {
                    br.close();
                }
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```





#### 处理流-BufferedInputStream 和 BufferedOutputStream  

##### 介绍BufferedInputStream

BufferedInputStream 是字节流，在创建 BufferedInputStream 时，会创建一个内部缓存区数组



##### 介绍 BufferedOutputStream

BufferedOutputStream 是字节流，实现缓冲的输出流，可以将多个字符写入调用底层系统



> ##### 图片/音乐的 拷贝 示例

```java
public class BufferedCopy02 {
    public static void main(String[] args) {

//        String srcFilePath = "e:\\Koala.jpg";
//        String destFilePath = "e:\\hsp.jpg";
//        String srcFilePath = "e:\\0245_韩顺平零基础学Java_引出this.avi";
//        String destFilePath = "e:\\hsp.avi";
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a3.java";

        //创建BufferedOutputStream对象BufferedInputStream对象
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //因为 FileInputStream  是 InputStream 子类
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            //循环的读取文件，并写入到 destFilePath
            byte[] buff = new byte[1024];
            int readLen = 0;
            //当返回 -1 时，就表示文件读取完毕
            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }

            System.out.println("文件拷贝完毕~~~");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //关闭流 , 关闭外层的处理流即可，底层会去关闭节点流
            try {
                if(bis != null) {
                    bis.close();
                }
                if(bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
```





#### 对象流-ObjectInputStream 和 ObjectOutputStream  

> **看一个需求**
>
> ​		1.将int num=100这个int数据保存到文件中，注意不是100数字，而是int100,并且，能够
> ​	从文件中直接恢复int100
>
> ​		2.将Dogdog=new Dog(“小黄”，3)这个dog对象保存到文件中，并且能够从文件恢复
>
> ​		3.上面的要求，就是能够将基本数据类型或者对象进行序列化和反序列化操作



##### 序列化和反序列化

- 序列化就是在保存数据时，保存数据的值和数据类型
- 反序列化就是在恢复数据时，恢复数据的值和数据类型
- 需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是序列化的，该类必须实现如下两个接口之一
  - Serializable 这是一个标记接口，没有方法
  - Externalizable 该接口有方法需要实现，因此我们一般实现上面的 Serializable 接口



##### 对象流介绍

提供了 对基本类型或对象类型的序列化和反序列化方法

- ObjectInputStream ： 提供 序列化功能
- ObjectOutputStream：提供反序列化功能

> ###### 代码示例

```java
/**
 * @author C7eric
 * @version 1.0
 * 演示ObjectOutputStream的使用, 完成数据的序列化
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String filePath = "e:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到 e:\data.dat
        oos.writeInt(100);// int -> Integer (实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("韩顺平教育");//String
        //保存一个dog对象
        oos.writeObject(new Dog("旺财", 10, "日本", "白色"));
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");


    }
}
```



> ###### 使用 ObjectInputStream 读取 data.dat 并反序列化恢复数据

```java
//
1.创建流对象
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\data.dat"));
// 2.读取， 注意顺序
System.out.println(ois.readInt());
System.out.println(ois.readBoolean());
System.out.println(ois.readChar());
System.out.println(ois.readDouble());
System.out.println(ois.readUTF());
System.out.println(ois.readObject());
System.out.println(ois.readObject());
System.out.println(ois.readObject());
// 3.关闭
ois.close();
System.out.println("以反序列化的方式读取(恢复)ok~");
```





##### 注意事项和细节

- 读写顺序要一致
- 要求序列化或反序列化对象，需要实现 Serializable 接口
- 序列化的类中，建议添加 SerialVersionUID ,为了提高版本的兼容性
- 序列化对象时，默认将里面所有的属性都序列化，但除了 static 和 transient 修饰的成员
- 序列化对象时，要求里面属性的类型也需要实现序列化接口
- 序列化具备可继承性，也就是说如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化



#### 标准输入输出流

##### 介绍

- System.in 标准输入        类型 InputStream   默认设备 键盘
- System.out  标准输出   类型 OutputStream  默认设备 显示器





#### 转换流-InputStreamReader 和 OutputStreamWriter  

- InputStreamReader :  Reader的子类，可以将InputStream(字节流)包
  装成（转换）Reader(字符流)
- OutputStreamWriter::Writer的子类，实现将OutputStream(字节流)
  包装成Writer(字符流)
- 当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文
  问题，所以建议将字节流转换成字符流
- 可以在使用时指定编码格式（比如utf-8,gbk,gb2312,IS08859-1等）



> ##### 应用案例

```java

/**
 * @author C7eric
 * @version 1.0
 * 演示使用 InputStreamReader 转换流解决中文乱码问题
 * 将字节流 FileInputStream 转成字符流  InputStreamReader, 指定编码 gbk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "e:\\a.txt";
        //解读
        //1. 把 FileInputStream 转成 InputStreamReader
        //2. 指定编码 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //将2 和 3 合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(
                                                    new FileInputStream(filePath), "gbk"));

        //4. 读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5. 关闭外层流
        br.close();

    }
}
```





### 打印流-PrintStream 和 PrintWriter  

---

打印流只有输出流，没有输入流



> #### 应用案例

```JAVA
/**
 * @author c7ERIC
 * @version 1.0
 * 演示PrintStream （字节打印流/输出流）
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //在默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器
        /*
             public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s);
            }

         */
        out.print("john, hello");
        //因为print底层使用的是write , 所以我们可以直接调用write进行打印/输出
        out.write("韩顺平,你好".getBytes());
        out.close();

        //我们可以去修改打印流输出的位置/设备
        //1. 输出修改成到 "e:\\f1.txt"
        //2. "hello, 韩顺平教育~" 就会输出到 e:\f1.txt
        //3. public static void setOut(PrintStream out) {
        //        checkIO();
        //        setOut0(out); // native 方法，修改了out
        //   }
        System.setOut(new PrintStream("e:\\f1.txt"));
        System.out.println("hello, 韩顺平教育~");


    }
}
```



### Properties 类

---

> 如下一个配置文件mysql..properties
> ip=192.168.0.13
> user=root
> pwd=12345
> 请问编程读取ip、user和pwd的值是多少

![image-20220629201633976](C:\Users\CSQ-PC\AppData\Roaming\Typora\typora-user-images\image-20220629201633976.png)



> #### 代码示例

```java
public class Properties01 {
    public static void main(String[] args) throws IOException {


        //读取mysql.properties 文件，并得到ip, user 和 pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) { //循环读取
            String[] split = line.split("=");
            //如果我们要求指定的ip值
            if("ip".equals(split[0])) {
                System.out.println(split[0] + "值是: " + split[1]);
            }
        }

        br.close();
    }
}
```





#### 基本介绍

- 专门用于读写配置文件的集合类

  ​		配置文件的格式：

  ​			键 = 值

  ​			键 = 值

- 注意： 键值对不需要有空格，值不需要用引号一起来。默认类型是 String



#### Properties 的常见方法

##### load

> 加载配置文件的键值对到 Properties 对象



##### list

> 将数据显示到指定设备



##### getProperty(key)

> 根据键获取值



##### setProperty(key,value)

> 设置键值对到 Properties 对象



##### store

> 将 Properties 中的键值对 存储到配置文件，在 idea 中，保存信息到配置文件，如果含有中文，会存储为 unicode 码



> ##### 应用案例

- 使用Properties类完成对mysql..properties的读取
- 使用Properties类添加key-val到新文件mysql2.properties中
- 使用Properties类完成对mysql2.properties的读取，并修改某个key-val

```java
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来读取mysql.properties 文件

        //1. 创建Properties 对象
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3. 把k-v显示控制台
        properties.list(System.out);
        //4. 根据key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码是=" + pwd);

    }
}
```

```java
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来创建 配置文件, 修改配置文件内容

        Properties properties = new Properties();
        //创建
        //1.如果该文件没有key 就是创建
        //2.如果该文件有key ,就是修改
        /*
            Properties 父类是 Hashtable ， 底层就是Hashtable 核心方法
            public synchronized V put(K key, V value) {
                // Make sure the value is not null
                if (value == null) {
                    throw new NullPointerException();
                }

                // Makes sure the key is not already in the hashtable.
                Entry<?,?> tab[] = table;
                int hash = key.hashCode();
                int index = (hash & 0x7FFFFFFF) % tab.length;
                @SuppressWarnings("unchecked")
                Entry<K,V> entry = (Entry<K,V>)tab[index];
                for(; entry != null ; entry = entry.next) {
                    if ((entry.hash == hash) && entry.key.equals(key)) {
                        V old = entry.value;
                        entry.value = value;//如果key 存在，就替换
                        return old;
                    }
                }

                addEntry(hash, key, value, index);//如果是新k, 就addEntry
                return null;
            }

         */
        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤姆");//注意保存时，是中文的 unicode码值
        properties.setProperty("pwd", "888888");

        //将k-v 存储文件中即可
        properties.store(new FileOutputStream("src\\mysql2.properties"), null);
        System.out.println("保存配置文件成功~");

    }
}
```









## 网络编程





### 网络的相关概念

---



#### 网络通信

##### 概念 

两台设备之前通过网络实现数据传输



##### 网络通信

将-数据通过网络从一台设备传输到另一台设备

Java.net 包下提供了一系列的类或接口，供程序员使用，完成网络通信



#### 网络

##### 概念

两台或多台设备通过一定物理设备连接起来构成了网络



##### 网络分类

- 局域网：覆盖范围最小，仅仅覆盖了一个教师或一个机房
- 城域网：覆盖范围较大，可以覆盖一整个城市
- 广域网：覆盖范围最大，可以覆盖全国，甚至全球，万维网是广域网的代表



#### ip地址

##### 概念

用于唯一标识网络中 的每台计算机/主机



##### 注意事项和细节

- 查看ip 地址 ：ipconfig
- ip 的表示形式：点分十进制 xx.xx.xx.xx
- 每一个十进制的范围 0 ~ 255
- ip 地址的组成 = 网络地址 + 主机地址 。比如 192.168.16.69
- IPv6 是互联网工程任务组设计的用于代替 IPv4 的下一代协议，其地址数量号称可以 为全世界每一粒沙子编上一个地址
- 由于IPv4 最大的问题在于网络地址资源有限，严重制约了互联网的应用与发展。IPv6 的使用，不仅能解决网络地址资源数量的问题，而且也解决了 多种接入设备连入互联网的障碍



##### IP 地址分类

![image-20220629230759945](C:\Users\CSQ-PC\AppData\Roaming\Typora\typora-user-images\image-20220629230759945.png)

![image-20220629230818062](C:\Users\CSQ-PC\AppData\Roaming\Typora\typora-user-images\image-20220629230818062.png)



#### 域名

>  www.4399.com



##### 好处

为了方便记忆，解决记 ip 的困难



##### 概念

将 IP 地址映射成 域名



##### 端口号

###### 概念

用于标识计算机上 某个特定的网络程序



###### 表示形式

以整数形式，端口范围  0 ~ 65535 [2 个 字节表示端口 0 ~ 2^16 - 1]



###### 注意事项和细节

- 0 ~ 1024 已经被占用，比如 ssh 22,ftp 21 , smtp 25  http 80
- 常见的网络程序端口号
  - tomcat:8080.
  - mysql : 3306
  - oracle : 1521
  - sqlserver : 1433



#### 网络通信协议

![image-20220629231657081](C:\Users\CSQ-PC\AppData\Roaming\Typora\typora-user-images\image-20220629231657081.png)



##### 协议（TCP/IP)

TCP / IP (Transmission Control Protocol / Internet Protocol) 的简写

中文译名为 传输控制协议 / 因特网互联协议，又叫网络通讯协议，这个协议是 Internet 最基本的协议、Internet 国际互联网络的基础，简单的说，就是由网络层的 IP 协议 和传输层的 TCP 协议组成的



| OSI 模型   | TCP/IP 模型       | TCP/IP模型各层对应协议    |
| ---------- | ----------------- | ------------------------- |
| 应用层     | 应用层            | HTTP、ftp、telnet、DNS... |
| 表示层     | 应用层            | HTTP、ftp、telnet、DNS... |
| 会话层     | 应用层            | HTTP、ftp、telnet、DNS... |
| 传输层     | 传输层（TCP)      | TCP、UDP...               |
| 网络层     | 网络层（IP)       | IP、ICMP、ARP...          |
| 数据链路层 | 物理 + 数据链路层 | Link                      |
| 物理层     | 物理 + 数据链路层 | Link                      |



#### TCP/UDP

##### TCP 协议 ：传输控制协议

- 使用 TCP 协议之前，须先建立 TCP 连接，形成传输数据通道
- 传输前，采用 “三次握手” 方式，是可靠的
- TCP 协议进行通信的两个应用进程 ： 客户端 、服务端
- 在连接中可进行大数据量的传输
- 传输完毕，需释放已建立的连接，效率低



##### UDP 协议 ： 用户数据协议

- 将数据、源、目的封装成数据包，不需要建立连接
- 每个数据包的大小限制在 64k 内，不适合传输大量数据
- 因无需连接，故是不可靠的
- 发送数据结束时无需释放资源（因为不是面向连接的），速度快
- 举例：发短信



### InetAddress 类

---



#### 相关方法

##### getLocalHost

> 获取本机 InetAddress 对象 



##### getByName

> 根据指定主机名/域名获取 IP 地址对象



##### getHostName

> 获取 InetAddress 对象的主机名



##### getHostAddress

> 获取 InetAddress 对象的地址



> #### 应用案例

```java
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //1. 获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DESKTOP-S4MP84S/192.168.12.1

        //2. 根据指定主机名 获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-S4MP84S");
        System.out.println("host1=" + host1);//DESKTOP-S4MP84S/192.168.12.1

        //3. 根据域名返回 InetAddress对象, 比如 www.baidu.com 对应
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2=" + host2);//www.baidu.com / 110.242.68.4

        //4. 通过 InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();//IP 110.242.68.4
        System.out.println("host2 对应的ip = " + hostAddress);//110.242.68.4

        //5. 通过 InetAddress 对象，获取对应的主机名/或者的域名
        String hostName = host2.getHostName();
        System.out.println("host2对应的主机名/域名=" + hostName); // www.baidu.com

    }
}
```







### Socket

---



#### 基本介绍

- 套接字（Socket) 开发网络应用程序被广泛应用，以至于成为事实上的标准
- 通信的两端都要有 Socket, 是两台机器间通信的端点
- 网络通信其实就是 Socket 间的通信
- Socket 允许程序把网络连接当成一个流，数据在两个 Socket 间通过 IO 传输
- 一般主动发起通信的应用属客户端，等待通信请求的是服务端

![image-20220701230742350](D:\C\Java\com\out\image-20220701230742350.png)





### TCP 网络通信编程

---



#### 基本介绍

- 基于 客户端 --- 服务端的网络通信
- 底层使用的是  TCP / IP 协议
- 应用场景举例：客户端发送数据，服务端接受并显示控制台
- 基于 Socket 的 TCP 编程





 













## 反射





### 反射机制

---



#### Java Reflection

- 反射机制允许程序在执行期j借助于 Reflection API 取得任何类的内部信息（比如成员变量、构造器、成员方法等），并能操作对象的属性及方法。反射在设计模式和框架底层都能用得到。
- 加载完类之后，在堆中就产生了一个 Class 类型的d对象（一个类只有一个 Class 对象），这个对象包含了类的完整结构信息。通过这个对象得到类的结构。这个 Class 对象就像一面镜子，透过这个镜子看到 类的结构，所以形象的称之为 ： 反射





#### Java 反射机制原理示意图

![image-20220702230935972](D:\C\Java\com\out\image-20220702230935972.png)



#### Java 反射机制可完成的操作

- 在运行时判断r任意一个对象所属的类
- 在运行时构造任意一个类的对象
- 在运行时得到任意一个类所具有的成员变量和方法
- 在运行时调用任意一个对象的成员变量和方法
- 生成动态代理



#### 反射相关的主要类

- Java.lang.Class :代表一个类，Class 对象表示某个类加载后在堆中的对象
- java.lang.reflect.Method : 代表类的方法，Method 对象表示某个类的方法
- java.lang.reflect.Field :代表类的成员变量，Field 对象表示某个类的成员变量
- java.lang.reflect.Constructor : 代表类的构造方法，Constructor 对象表示构造器



这些类都在 java.lang.reflect



> ##### 代码示例

```java
public class Reflection01 {

    public static void main(String[] args) throws Exception {



        //1. 使用Properties 类, 可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.hspedu.Cat"
        String methodName = properties.get("method").toString();//"hi"


        //2. 使用反射机制解决
        //(1) 加载类, 返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.hspedu.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass()); //运行类型
        //(3) 通过 cls 得到你加载的类 com.hspedu.Cat 的 methodName"hi"  的方法对象
        //    即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        //(4) 通过method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=============================");
        method1.invoke(o); //传统方法 对象.方法() , 反射机制 方法.invoke(对象)

        //java.lang.reflect.Field: 代表类的成员变量, Field对象表示某个类的成员变量
        //得到name字段
        //getField不能得到私有的属性
        Field nameField = cls.getField("age"); //
        System.out.println(nameField.get(o)); // 传统写法 对象.成员变量 , 反射 :  成员变量对象.get(对象)

        //java.lang.reflect.Constructor: 代表类的构造方法, Constructor对象表示构造器
        Constructor constructor = cls.getConstructor(); //()中可以指定构造器参数类型, 返回无参构造器
        System.out.println(constructor);//Cat()



        Constructor constructor2 = cls.getConstructor(String.class); //这里老师传入的 String.class 就是String类的Class对象
        System.out.println(constructor2);//Cat(String name)
    }
}

```



#### 反射优点和缺点

##### 优点

可以动态的创建和使用对象（也是框架底层核心），使用灵活，没有反射机制，框架技术就失去底层支撑



##### 缺点

使用反射机制基本是解释执行，对执行速率有影响



> ##### 代码示例

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 测试反射调用的性能，和优化方案
 */
public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //Field
        //Method
        //Constructor
        m1();
        m2();
        m3();
    }

    //传统方法来调用hi
    public static void m1() {

        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1() 耗时=" + (end - start));
    }

    //反射机制调用方法hi
    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);//反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("m2() 耗时=" + (end - start));
    }

    //反射调用优化 + 关闭访问检查

    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);//在反射调用方法时，取消访问检查
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);//反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("m3() 耗时=" + (end - start));
    }
}
```



#### 反射调用优化 - 关闭访问检查

- Method 和 Field 、Constructor 对象 都有 setAccessible() 方法
- setAccessible 作用是启动和禁用访问安全检查的开关
- 参数值为 true 表示反射的对象在使用时取消访问安全检查，提高反射的效率。参数值为 false 则表示 反射的对象执行访问安全检查



> ##### 代码示例

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 对Class类特点的梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //看看Class类图
        //1. Class也是类，因此也继承Object类
        //Class
        //2. Class类对象不是new出来的，而是系统创建的
        //(1) 传统new对象
        /*  ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //Cat cat = new Cat();
        //(2) 反射方式, 刚才老师没有debug到 ClassLoader类的 loadClass, 原因是，我没有注销Cat cat = new Cat();
        /*
            ClassLoader类, 仍然是通过 ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls1 = Class.forName("com.hspedu.Cat");

        //3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        Class cls2 = Class.forName("com.hspedu.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        Class cls3 = Class.forName("com.hspedu.Dog");
        System.out.println(cls3.hashCode());

        

    }
}
```















### Class 类

---



#### 基本介绍

- Class 也是类，因此也继承 Object 类
- Class 类对象不是 new出来的，而是系统创建的
- 对于某个类的 Class 类对象，在内存中只有一份，因为类只加载一次
- 每个类的实例都会记得自己是由哪个 Class 实例所生成
- 通过 Class 对象可以完整的得到一个类的完整结构，通过一系列 API
- Class 对象是存放在堆的
- 类的字节码二进制，是放在方法区的，有的地方称为类的元数据（包括方法代码，变量名，方法名，访问权限等等）



#### Class 类常用方法

##### static Class forName(String name)

返回指定类名name的Class对象

##### Object newlnstance()

调用缺省构造函数，返回该Class对象的一个实例

##### getName()

返回此Cass对象所表示的实体（类、接口、数组类、基本类型等）名称

##### Class [] getInterfaces()

获取当前Class对象的接口

##### ClassLoader getClassLoader()

返回该类的类加载器

##### Class getSuperclass()

返回表示此Classl所表示的实体的超类的Class

##### Constructor[]getConstructors()

返回一个包含某些Constructori对象的数组

##### Field[]getDeclaredFields()

返回Field对象的一个数组

##### Method getMethod

返回一个Methodi对象，此对象的形参类型为paramType



> ##### 代码示例

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 演示Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        String classAllPath = "com.hspedu.Car";
        //1 . 获取到Car类 对应的 Class对象
        //<?> 表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);
        //2. 输出cls
        System.out.println(cls); //显示cls对象, 是哪个类的Class对象 com.hspedu.Car
        System.out.println(cls.getClass());//输出cls运行类型 java.lang.Class
        //3. 得到包名
        System.out.println(cls.getPackage().getName());//包名
        //4. 得到全类名
        System.out.println(cls.getName());
        //5. 通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.toString()
        //6. 通过反射获取属性 brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));//宝马
        //7. 通过反射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));//奔驰
        //8 我希望大家可以得到所有的属性(字段)
        System.out.println("=======所有的字段属性====");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());//名称
        }


    }
}
```



#### 获取 Class 类对象

- 前提 ： 已知一个类的全类名，且该类在类路径下，可通过 Class 类的静态方法  forName() 获取，可能抛出  ClassNotFoundException ，实例 ： Class cls1 = Class.forName("java.lang.cat")

  应用场景：多用于配置文件，读取类全路径，加载类

- 前提：已知某个类的实例，调用该实例的 getClass() 方法获取 Class 对象，实例：Class cls3 = 对象.getClass(); //运行类型

  应用场景：通过创建好的对象，获取 Class 对象

- 前提：若已知具体的类，通过类的Class 获取，该方式 最为安全可靠，程序性能最高。实例：Class cls2 = Cat.class;

  应用场景 ： 多用于参数传递，比如通过反射得到对应构造器对象

- 其他方法：

  - ClassLoader cl = 对象.getClass().getClassLoader();
  - Class cl4 = cl.loadClass("类的全名");

- 基本数据类型（int，char，boolean，float，double，byte，short，long) 按如下方式得到 Class类 对象

  - Class cls  = 基本数据类型.class

- 基本数据类型对应的包装类，可以通过  .TYPE 得到 Class 类 对象

  - Class cls = 包装类.TYPE

> ##### 代码示例

```java
/**
 * @author Cs7eric	
 * @version 1.0
 * 演示得到Class对象的各种方式(6)
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {

        //1. Class.forName
        String classAllPath = "com.hspedu.Car"; //通过读取配置文件获取
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2. 类名.class , 应用场景: 用于参数传递
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3. 对象.getClass(), 应用场景，有对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4. 通过类加载器【4种】来获取到类的Class对象
        //(1)先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //cls1 , cls2 , cls3 , cls4 其实是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5. 基本数据(int, char,boolean,float,double,byte,long,short) 按如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int

        //6. 基本数据类型对应的包装类，可以通过 .TYPE 得到Class类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE; //其它包装类BOOLEAN, DOUBLE, LONG,BYTE等待
        System.out.println(type1);

        System.out.println(integerClass.hashCode());//?
        System.out.println(type1.hashCode());//?
    }
}

```



#### 哪些类型有 Class 对象  

##### 如下类型有 Class 对象  

- 外部类，成员内部类，静态内部类，局部内部类，匿名内部类
- interface : 接口
- 数组
- enum : 枚举
- annotation ：注解
- 基本数据类型
- void



> ##### 代码示例

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 演示哪些类型有Class对象
 */
public class AllTypeClass {
    public static void main(String[] args) {

        Class<String> cls1 = String.class;//外部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Integer[]> cls3 = Integer[].class;//数组
        Class<float[][]> cls4 = float[][].class;//二维数组
        Class<Deprecated> cls5 = Deprecated.class;//注解
        //枚举
        Class<Thread.State> cls6 = Thread.State.class;
        Class<Long> cls7 = long.class;//基本数据类型
        Class<Void> cls8 = void.class;//void数据类型
        Class<Class> cls9 = Class.class;//

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
    }
}
```





### 类加载

---



#### 基本说明

反射机制是 Java 实现动态语言的关键，也就是通过反射实现类动态加载

- 静态加载：编译时加载相关的类，如果没有则报错 ，依赖性太强
- 动态加载：运行时加载相关的类，如果运行时不用该类，即使不存在该类，则不报错，降低了依赖性



#### 类加载时机

- 当创建对象时（new） // 静态加载
- 当子类被加载时，父类也加载  //静态加载
- 调用l类中的静态成员时 // 静态加载
- 通过反射 // 动态加载



#### 类加载过程图

![image-20220705130429878](D:\C\Java\com\out\image-20220705130429878.png)



#### 类加载各阶段完成任务

![image-20220705130519904](D:\C\Java\com\out\image-20220705130519904.png)



#### 加载阶段

JVM 在该阶段的主要目的是将 字节码从不同的数据源（可能是 class 文件，也可能是 jar 包，甚至网络）转化为 二进制字节流加载到内存中，并生成一个代表该类的 java.lang.Cass  对象 



#### 连接阶段 - 验证

- 目的是为了确保 Class 文件的字节流中包含的信息符合当前虚拟机的要求，并且不会威胁当前虚拟自身的安全
- 包括：文件格式验证（是否以魔数 oxcafebabe 开头)，元数据验证，字节码验证和符号引用验证
- 可以考虑使用 - Xverify:none 参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间



#### 连接阶段 - 准备

- JVM 会在该阶段对静态变量，分配内存并默认初始化（对应数据类型的默认初始化，如 0 ，null,0L,false等），这些变量所使用的内存都将在方法区中j进行分



> ##### 代码示例

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 我们说明一个类加载的链接阶段-准备
 */
public class ClassLoad02 {
    public static void main(String[] args) {

    }
}
class A {
    //属性-成员变量-字段
    //老韩分析类加载的链接阶段-准备 属性是如何处理
    //1. n1 是实例属性, 不是静态变量，因此在准备阶段，是不会分配内存
    //2. n2 是静态变量，分配内存 n2 是默认初始化 0 ,而不是20
    //3. n3 是static final 是常量, 他和静态变量不一样, 因为一旦赋值就不变 n3 = 30
    public int n1 = 10;
    public static  int n2 = 20;
    public static final  int n3 = 30;
}

```



#### 连接阶段 - 解析

- 虚拟机将常量池中的符号引用替换成直接引用的过程



#### Initialization (初始化)

- 到初始化阶段，才真正开始执行类中定义的 Java 程序代码，此阶段是执行<clinit>() 方法的过程
- <clinit>() 方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有静态变量的赋值操作和静态代码块中的语句，并进行合并
- 虚拟机会保证一个类的 <clinit>() 方法在多线程环境中被正确的j加锁，同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>() 方法，其他线程都需要 阻塞等待，直到活动线程 执行<clinit> () 方法执行完毕



> 代码示例

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 演示类加载-初始化阶段
 */
public class ClassLoad03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //老韩分析
        //1. 加载B类，并生成 B的class对象
        //2. 链接 num = 0
        //3. 初始化阶段
        //    依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句,并合并
        /*
                clinit() {
                    System.out.println("B 静态代码块被执行");
                    //num = 300;
                    num = 100;
                }
                合并: num = 100

         */

        //new B();//类加载
        //System.out.println(B.num);//100, 如果直接使用类的静态属性，也会导致类的加载

        //看看加载类的时候，是有同步机制控制
        /*
        protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
        {
            //正因为有这个机制，才能保证某个类在内存中, 只有一份Class对象
            synchronized (getClassLoadingLock(name)) {
            //....
            }
            }
         */
        B b = new B();
    }
}

class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B() {//构造器
        System.out.println("B() 构造器被执行");
    }
}
```



### 通过反射获取类的结构信息  

---



#### java.lang.Class 类  

- getName : 获取全类名
- getSimpleName : 获取简单类名
- getFields : 获取所有 public 修饰的属性，包含本类以及父类的
- getDeclaredFields : 获取本类中所有属性
- getMethods : 获取所有 public 修饰的方法，包含本类以及父类的
- getDeclaredMethods : 获取本类中所有方法
- getConstructors : 获取本类所有 public 修饰的构造器
- getDeclaredConstructors : 获取本类中所有构造器
  getPackage : 以Package形式返回包信息
- getSuperClass: 以Class形式返回父类信息
- getInterfaces: 以Class[]形式返回接口信息
- getAnnotations: 以Annotation[]形式返回注解信息



#### java.lang.reflect.Field 类  

- getModifiers : 以int形式返回修饰符
  [说明：默认修饰符是0，public是1，private是2，protected是4，static是8，final是16]，public(1)+static(8)=9
- getType:以Classj形式返回类型

- getName : 返回属性名



#### java.lang.reflect.Method 类  

- getModifiers : 以 int 形式返回修饰符

  [说明：默认修饰符是0，public是1，private是2，protected是4，static是8，final是16]

- getReturnType : 以 Class 形式获取返回类型

- getName : 返回方法名

- getParameterTypes : 以 Class[] 返回参数类型数组



#### java.lang.reflect.Constructor 类  

- getModifiers:以int形式返回修饰符
- getName:返回构造器名（全类名）
- getParameterTypes :  以 Class[] 返回参数类型数组



> #### 代码示例

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 演示如何通过反射获取类的结构信息
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_02() throws ClassNotFoundException, NoSuchMethodException {
        //得到Class对象
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");
        //getDeclaredFields:获取本类中所有属性
        //规定 说明: 默认修饰符 是0 ， public  是1 ，private 是 2 ，protected 是 4 , static 是 8 ，final 是 16
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName()
                    + " 该属性的修饰符值=" + declaredField.getModifiers()
                    + " 该属性的类型=" + declaredField.getType());
        }

        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName()
                    + " 该方法的访问修饰符值=" + declaredMethod.getModifiers()
                    + " 该方法返回类型" + declaredMethod.getReturnType());

            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型=" + parameterType);
            }
        }

        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("====================");
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//这里老师只是输出名

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }



        }

    }

    //第一组方法API
    @Test
    public void api_01() throws ClassNotFoundException, NoSuchMethodException {

        //得到Class对象
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");
        //getName:获取全类名
        System.out.println(personCls.getName());//com.hspedu.reflection.Person
        //getSimpleName:获取简单类名
        System.out.println(personCls.getSimpleName());//Person
        //getFields:获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {//增强for
            System.out.println("本类以及父类的属性=" + field.getName());
        }
        //getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName());
        }
        //getMethods:获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类以及父类的方法=" + method.getName());
        }
        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName());
        }
        //getConstructors: 获取所有public修饰的构造器，包含本类
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类的构造器=" + constructor.getName());
        }
        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//这里老师只是输出名
        }
        //getPackage:以Package形式返回 包信息
        System.out.println(personCls.getPackage());//com.hspedu.reflection
        //getSuperClass:以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的class对象=" + superclass);//
        //getInterfaces:以Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息=" + anInterface);
        }
        //getAnnotations:以Annotation[] 形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息=" + annotation);//注解
        }


    }
}

class A {
    public String hobby;

    public void hi() {

    }

    public A() {
    }

    public A(String name) {
    }
}

interface IA {
}

interface IB {

}

@Deprecated
class Person extends A implements IA, IB {
    //属性
    public String name;
    protected static int age; // 4 + 8 = 12
    String job;
    private double sal;

    //构造器
    public Person() {
    }

    public Person(String name) {
    }

    //私有的
    private Person(String name, int age) {

    }

    //方法
    public void m1(String name, int age, double sal) {

    }

    protected String m2() {
        return null;
    }

    void m3() {

    }

    private void m4() {

    }
}
```





### 通过反射创建对象  

---

- 方式一：调用类中的oublic修饰的无参构造器
- 方式二：调用类中的指定构造器
- Class类相关方法
  - newlnstance：调用类中的无参构造器，获取对应类的对象
  - getConstructor(Class..clazz):根据参数列表，获取对应的publici构造器对象
  - getDecalaredConstructor(Class..clazz):根据参数列表，获取对应的所有构造器对象
- Constructor类相关方法
  - setAccessible:暴破
  - newInstance(Object..obj):调用构造器



> #### 案例演示

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 演示通过反射机制创建实例
 */
public class ReflecCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //1. 先获取到User类的Class对象
        Class<?> userClass = Class.forName("com.hspedu.reflection.User");
        //2. 通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3. 通过public的有参构造器创建实例
        /*
            constructor 对象就是
            public User(String name) {//public的有参构造器
                this.name = name;
            }
         */
        //3.1 先得到对应构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //3.2 创建实例，并传入实参
        Object hsp = constructor.newInstance("hsp");
        System.out.println("hsp=" + hsp);
        //4. 通过非public的有参构造器创建实例
        //4.1 得到private的构造器对象
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2 创建实例
        //暴破【暴力破解】 , 使用反射可以访问private构造器/方法/属性, 反射面前，都是纸老虎
        constructor1.setAccessible(true);
        Object user2 = constructor1.newInstance(100, "张三丰");
        System.out.println("user2=" + user2);
    }
}

class User { //User类
    private int age = 10;
    private String name = "韩顺平教育";

    public User() {//无参 public
    }

    public User(String name) {//public的有参构造器
        this.name = name;
    }

    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}
```





### 通过反射访问类中的成员  

---



#### 访问属性

- 根据属性名获取Field对象

  Field f = clazz对象.getDeclaredField(属性名)：

- 暴破：f.setAccessible(true); //f是Field

- 访问

  - f.set(o,值)：/o表示对象
  - syso(f.get(o):/o表示对象

- **注意**：如果是静态属性，则set和get中的参数o,可以写成null



> ##### 代码示例

```java
/**
 * @author Cs7eric
 * @version 1.0
 * 演示反射操作属性
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        //1. 得到Student类对应的 Class对象
        Class<?> stuClass = Class.forName("com.hspedu.reflection.Student");
        //2. 创建对象
        Object o = stuClass.newInstance();//o 的运行类型就是Student
        System.out.println(o.getClass());//Student
        //3. 使用反射得到age 属性对象
        Field age = stuClass.getField("age");
        age.set(o, 88);//通过反射来操作属性
        System.out.println(o);//
        System.out.println(age.get(o));//返回age属性的值

        //4. 使用反射操作name 属性
        Field name = stuClass.getDeclaredField("name");
        //对name 进行暴破, 可以操作private 属性
        name.setAccessible(true);
        //name.set(o, "老韩");
        name.set(null, "老韩~");//因为name是static属性，因此 o 也可以写出null
        System.out.println(o);
        System.out.println(name.get(o)); //获取属性值
        System.out.println(name.get(null));//获取属性值, 要求name是static

    }
}

class Student {//类
    public int age;
    private static String name;

    public Student() {//构造器
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}
```



#### 访问方法

- 根据方法名和参数列表获取Method方法对象：Method  m= clazz.getDeclaredMethod(方法名，XX.class);  //得到本类的所有方法
- 获取对象：Object o=clazz.newlnstance() ;
- 暴破：m.setAccessible(true);
- 访问：Object returnValue=m.invoke(o,实参列表);  //  o 就是对象
- 注意：如果是静态方法，则invoke的参数o,可以写成null



> ##### 代码示例

```java
/**
 * @author C
 * @version 1.0
 * 演示通过反射调用方法
 */
public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //1. 得到Boss类对应的Class对象
        Class<?> bossCls = Class.forName("com.hspedu.reflection.Boss");
        //2. 创建对象
        Object o = bossCls.newInstance();
        //3. 调用public的hi方法
        //Method hi = bossCls.getMethod("hi", String.class);//OK
        //3.1 得到hi方法对象
        Method hi = bossCls.getDeclaredMethod("hi", String.class);//OK
        //3.2 调用
        hi.invoke(o, "韩顺平教育~");

        //4. 调用private static 方法
        //4.1 得到 say 方法对象
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //4.2 因为say方法是private, 所以需要暴破，原理和前面讲的构造器和属性一样
        say.setAccessible(true);
        System.out.println(say.invoke(o, 100, "张三", '男'));
        //4.3 因为say方法是static的，还可以这样调用 ，可以传入null
        System.out.println(say.invoke(null, 200, "李四", '女'));

        //5. 在反射中，如果方法有返回值，统一返回Object , 但是他运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型=" + reVal.getClass());//String


        //在演示一个返回的案例
        Method m1 = bossCls.getDeclaredMethod("m1");
        Object reVal2 = m1.invoke(o);
        System.out.println("reVal2的运行类型=" + reVal2.getClass());//Monster


    }
}

class Monster {}
class Boss {//类
    public int age;
    private static String name;

    public Boss() {//构造器
    }

    public Monster m1() {
        return new Monster();
    }

    private static String say(int n, String s, char c) {//静态方法
        return n + " " + s + " " + c;
    }

    public void hi(String s) {//普通public方法
        System.out.println("hi " + s);
    }
}
```

















































## 简答题

### 1. == 与 equals 的区别

> == : 
>
> **概念:** 比较运算符    **用于基本数据类型：** 可以，判断值是否相等   **用于引用类型：** 可以，判断两个对象是否相等

> **equals:**
>
> **概念：** Object类的方法  **用于基本数据类型：** 不可以  **用于引用类型：** 可以，默认两个对象是否为一个对象，但是子类往往重写该方法，比较子类属性是否相等



### 2. 什么是多态

> **多态：** 方法或者对象具有多种形态，是 OOP 的第三大特征，是建立在封装和继承基础之上
>
> > **多态具体提现**
> >
> > - 方法多态
> >
> >   1.重载体现多态  2.重写体现多态
> >
> > - 对象多态
> >
> >   **1.对象的编译类型和运行类型可以不一致，编译类型在定义时就确定，不能变化**
> >
> >   **2.对象的运行类型是可以变化的，可以通过 getClass() 来查看运行类型  **
> >
> >   **3.编译类型看定义时 = 号 左边，运行类型看 = 号 右边**
> >   testing

### 3.Java 的动态绑定机制







#### HashSet 和 TreeSet 如何去重







而我【【【00
