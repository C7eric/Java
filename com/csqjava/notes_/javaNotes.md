#  Java 笔记

## **面向对象OOP**

### **类变量**

---

##### **1.什么是 类变量**

---

> 类变量也叫静态变量/静态属性，是该类的所有对象共享的变量，任何一个该类的对象去访问它时，取到的都是相同的值，同样任何一个该类的对象去修改它时，修改的也是同一个变量。
>



##### **2.如何定义类变量**

---

> **定义语法**
>
> 访问修饰符 static 数据类型 变量名
>



##### **3.如何访问类变量**

---

> 类名.类变量名 
>
> 或者  对象名.类变量名 **静态变量的访问修饰符的访问权限和范围 和 普通属性是一样的**
>
> ```java
>public static void mian(String[] args){
> 
> // 类名.类变量名
>  // 说明： 类变量是随着类的加载而创建的，所以即使没有创建对象实例也可以访问
> System.out.println(A.name);
> 
> // 通过对象名.类变量名 也可以访问
>   A a = new A();
> System.out.println(a.name);
> }
>
> class A {
> // 类变量
>  // 类变量的访问，必须遵守相关的访问权限
> public static String name = "csq";
> }
> ```
>     



##### **4.类变量的使用注意事项和细节**

---

> **1.什么时候需要用类变量**
>
> > 当我们需要让某个类的所有对象都共享一个变量时，就可以考虑是类变量(静态变量)。比如： 定义学生类，统计所有学生共交多少钱，Student(name,static fee)
>
> **2.类变量和实例(普通属性)变量的区别**
>
> > 类变量是该类的所有对象共享的，而实例变量是每个对象独享的
>
> **3.加上 static  称为类变量或静态变量，否则称为实例变量/普通变量/非静态变量**
>
> **4.类变量可以通过类名.类变量名 或 对象名.类变量名 访问  前提是满足修饰符的访问权限和范围**
>
>  **5.实例变量不能通过 类名.类变量名 方式访问**
>
> **6.类变量是在类加载的时候就初始化了，也就是说，即使没有创建对象，只要类加载了，就可以使用类变量**
>
> **7.类变量的生命周期是随着类的加载开始，随着类的消亡而销毁**



### **类方法**

---

##### **1.类方法基本介绍**

---

> 类方法也叫静态方法
>
> **形式如下**
>
> 访问修饰符 static 数据返回类型 方法名（）{}
>
> > **类方法的调用**
> >
> > 类名.类方法名   对象名.类方法名 **前提是满足访问修饰符的访问权限和范围**
> >
> > ```java
> > public static void main(String[] args) {
> > 	//创建 2 个学生对象，叫学费
> > 	Stu tom = new Stu("tom");
> > 	//tom.payFee(100);
> > 	Stu.payFee(100);//对不对?对
> > 	Stu mary = new Stu("mary");
> > 	//mary.payFee(200);
> > 	Stu.payFee(200);//对
> > 	//输出当前收到的总学费
> > 	Stu.showFee();//300
> > 	//如果我们希望不创建实例，也可以调用某个方法(即当做工具来使用)
> > 	//这时，把方法做成静态方法时非常合适
> > 	System.out.println("9 开平方的结果是=" + Math.sqrt(9));
> > 	System.out.println(MyTools.calSum(10, 30));
> > 	}
> > }
> > 
> > //开发自己的工具类时，可以将方法做成静态的，方便调用
> > class MyTools {
> > 	//求出两个数的和
> > 	public static double calSum(double n1, double n2) {
> > 	return n1 + n2;
> > 	}
> > 
> > //可以写出很多这样的工具方法... }
> > class Stu {
> > 
> > 	private String name;//普通成员
> > 	//定义一个静态变量，来累积学生的学费
> > 	private static double fee = 0;
> > 	public Stu(String name) {
> > 	this.name = name;
> > }
> > 	//说明
> > 	//1. 当方法使用了 static 修饰后，该方法就是静态方法
> > 	//2. 静态方法就可以访问静态属性/变量
> > public static void payFee(double fee) {
> > 	Stu.fee += fee;//累积到
> > }
> > 
> > public static void showFee() {
> > 	System.out.println("总学费有:" + Stu.fee);
> > 	}
> > }
> > ```
> >



##### **2.类方法经典的使用场景**

---

> > > 当方法中不涉及到任何和对象相关的成员，则可以将方法设计成静态方法，提高开发效率
> > >
> > > **如果我们希望不创建实例，也可以调用某个方法（即当作工具使用）**
> > >
> > > 
> > >
> > > 比如： 工具类中方法 utils
> > >
> > > Math 类、Array 类、Collections 集合类
> > >



**小结**

---

> > > 在程序实际开发中，往往会将一些通用的方法，设计成静态方法，这样我们不需要创建对象就可以使用，比如打印一维数组，冒泡排序，完成某个计算任务
> > >



##### **3.类方法使用注意事项和细节**

---

> > > **1.类方法和普通方法都是随着类的加载而加载，将结构信息储存在方法区：**
> > >
> > > 类方法中无 this 的参数
> > >
> > > 普通方法中隐含着 this 的参数
> > >
> > > **2.类方法可以通过类名调用，也可以通过对象名调用**
> > >
> > > **3.普通方法和对象有关，需要通过对象名调用，比如对象名.方法名（参数），不能通过类名调用**
> > >
> > > **4.类方法中不允许使用和对象有关的关键字，比如 this 和 super 。普通方法（成员方法）可以**
> > >
> > > **5.类方法（静态方法）中只能访问 静态变量 或 静态方法**
> > >
> > > **6.普通成员方法，既可以访问 非静态成员，也可以访问静态成员**
> > >
> > > > **小结**
> > > >
> > > > 静态方法，只能访问静态的成员，非静态的方法，可以访问静态成员和非静态成员 **前提是必须遵守访问权限和范围**



###  **main() 方法**

---

##### **1.main 方法的形式**

---

> ```java
>public static void main(String [] args){}
> ```
> 
> > **1. main 方法是虚拟机调用**
>>
> > **2. Java 虚拟机需要调用类的 main 方法，所以该方法的访问权限必须是 public **
> >
> > **3. Java 虚拟机在执行 main 方法时不必创建对象，所以该方法必须是 static**
> >
> > **4.该方法接收 String 类型的数组参数，该数组中保存执行 Java 命令时传递给所运行的类的参数**
> >
> > **5. Java 执行的程序 参数1 参数2 参数3 **
> 



##### **特别提示**

---

> > **1.在 main 方法中，我们可以直接调用 main 方法所在类的静态方法 或 静态属性**
>>
> > **2. 但是不能直接访问该类中的非静态成员，必须创建该类的一个实例对象后，才可以通过这个对象去访问类中的非静态成员**



###  **代码块**

---

##### **1.基本介绍**

---

> 代码块又称 初始化块 ，属于类中的成员[即 是类的一部分]，类似于方法，将逻辑语句封装在方法体中，通过 {} 包围起来
>
> 但和方法不同，没有方法名 ，没有返回，没有参数，只有方法体，而且不用通过对象或类 显式调用，而是加载类时，或创建对象时隐式调用



##### **2.基本语法**

---

> ```java
>(修饰符){
> };
>```
> 
>> **说明注意**
> 
>1. 修饰符可选，要写的话，也只能写 static
> 2. 代码块分为两类，使用 static 修饰的叫 静态代码块，没有 static 修饰的，叫普通代码块/非静态代码块
> 3. 逻辑语句可以为任何逻辑语句（输入，输出，方法调用，循环，判断等）
> 4.  ；可以写，也可以省略 
> 



##### **3.代码块的好处**

---

> - 相当于另外一种形式的构造器（对构造器的补充机制），可以做初始化的操作
>- **场景：** 如果多个构造器中都有重复的语句，可以抽取到初始化块中，提高代码的重用性
> 
>```java
> public class CodeBlock01 {
>public static void main(String[] args) {
> 
>    Movie movie = new Movie("你好，李焕英");
> 	System.out.println("===============");
> 	Movie movie2 = new Movie("唐探 3", 100, "陈思诚");
> 	}
> }
>class Movie {
> 
>	private String name;
> 	private double price;
> 	private String director;
> 	//3 个构造器-》重载
> 	//(1) 下面的三个构造器都有相同的语句
>	//(2) 这样代码看起来比较冗余
> 	//(3) 这时我们可以把相同的语句，放入到一个代码块中，即可
>	//(4) 这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容
> 	//(5) 代码块调用的顺序优先于构造器.. {
> 	System.out.println("电影屏幕打开...");
>	System.out.println("广告开始...");
> 	System.out.println("电影正是开始...");
> };
> 
> public Movie(String name) {
> 
>     System.out.println("Movie(String name) 被调用...");
> 	this.name = name;
> }
> 
> public Movie(String name, double price) {
>     
>     this.name = name;
> 	this.price = price;
> }
> public Movie(String name, double price, String director) {
> 
>     System.out.println("Movie(String name, double price, String director) 被调用...");
> 	this.name = name;
> 	this.price = price;
> 	this.director = director;
> 	}
> }
> ```
> 



##### **4.代码块的使用注意事项和细节**

---

> 1.  static 代码块也叫做 静态代码块，作用就是对类进行初始化，而且谈随着 **类的加载** 而执行，并且只会执行一次，如果是普通代码块，每创建一个对象，就执行一次
>2. **类什么时候被加载**
>    1. 创建对象实例的时候（new)
>   2. 创建子类对象实例的时候，父类也会被加载
>    3. 使用类的静态成员时（静态属性/静态方法）
>3. 普通的代码块，在创建对象实例时，会被隐式调用，被创建一次，调用一次  **如果只是使用类的静态成员时，普通代码块并不会执行**
> 



##### **5.小结**

---

> 1.  static 代码块是在类加载时，执行，且只执行一次
>2. 普通代码块是在创建对象时调用的，创建一次，调用一次
> 3. 类加载的 3 种 情况需要记住
>
> ```java
>public class CodeBlockDetail01 {
> 
>public static void main(String[] args) {
> 
> 	//类被加载的情况举例
> 	//1. 创建对象实例时(new)
> 	// AA aa = new AA();
>	//2. 创建子类对象实例，父类也会被加载, 而且，父类先被加载，子类后被加载
> 	// AA aa2 = new AA();
>	//3. 使用类的静态成员时(静态属性，静态方法)
> 	// System.out.println(Cat.n1);
> 	//static 代码块，是在类加载时，执行的，而且只会执行一次. // DD dd = new DD();
> 	// DD dd1 = new DD();
> 	//普通的代码块，在创建对象实例时，会被隐式的调用。
>	// 被创建一次，就会调用一次。
> 	// 如果只是使用类的静态成员时，普通代码块并不会执行
>	System.out.println(DD.n1);//8888, 静态模块块一定会执行
> 	}
> }
>
> class DD {
> 
>     public static int n1 = 8888;//静态属性
> 	//静态代码块
> 	static {
> 		System.out.println("DD 的静态代码 1 被执行...");//
> }
> 
> 	//普通代码块, 在 new 对象时，被调用，而且是每创建一个对象，就调用一
> 	//可以这样简单的，理解 普通代码块是构造器的补充
>     	{
> 		System.out.println("DD 的普通代码块...");
> 	}
> }
> 
> class Animal {
> //静态代码块
> 	static {
> 		System.out.println("Animal 的静态代码 1 被执行...");//
> 	}
> }
> class Cat extends Animal {
> 
>     public static int n1 = 999;//静态属性
> 	//静态代码块
> 	static {
> 			System.out.println("Cat 的静态代码 1 被执行...");//
> 	}
> }
> class BB {
> //静态代码块
> 	static {
> 			System.out.println("BB 的静态代码 1 被执行...");//1
> 	}
> }
> class AA extends BB {
> 
>     //静态代码块
> 	static {
> 		System.out.println("AA 的静态代码 1 被执行...");//2
> 	};
> }
> ```
> 
> **4.创建一个对象时，在 一个类 调用顺序是（重点、难点）**
>
> 1.  调用静态代码块和静态属性初始化（注意：静态代码块和静态属性初始化调用的优先级一样，如果有多个静态代码块和多个静态变量初始化，则按他们定义的顺序调用）
>2. 调用普通代码块和普通属性的初始化（注意：普通代码块和普通属性初始化调用的优先级一样，如果有多个普通代码块和普通属性初始化，则按定义顺序调用
> 3. 调用构造方法
> 
> ```java
> public class CodeBlockDetail02 {
> public static void main(String[] args) {
> 
>    A a = new A();
>     // (1) A 静态代码块 01 (2) getN1 被调用...(3)A 普通代码块 01(4)getN2 被调用...(5)A() 构造器被调用
>	}
> }
> class A {
> 
>    { //普通代码块
> 	System.out.println("A 普通代码块 01");
> }
>     	private int n2 = getN2();//普通属性的初始化
> 	static { //静态代码块
>     	System.out.println("A 静态代码块 01");
> }
> 	//静态属性的初始化
> 	private static int n1 = getN1();
> 	public static int getN1() {
> 	System.out.println("getN1 被调用...");
> 	return 100;
> }
> 	public int getN2() { //普通方法/非静态方法
> 		System.out.println("getN2 被调用...");
> 		return 200;
> }
> 	//无参构造器
> 	public A() {
> 		System.out.println("A() 构造器被调用");
> 	}
> }
> 
> 	```
> 
> 5.构造器的最前面其实隐含了 super() 和 调用普通代码块，静态相关的代码块，属性初始化，在类加载时，就加载完毕，因此是优先于 构造器和 普通代码块执行的
> 
> ```java
> public class CodeBlockDetail03 {
>     public static void main(String[] args) {
> 
>     new BBB();//(1)AAA 的普通代码块(2)AAA() 构造器被调用(3)BBB 的普通代码块(4)BBB() 构造器被调用
> 	}
> }
> class AAA { //父类 Object
> 
>     {
> 		System.out.println("AAA 的普通代码块");
> }
> public AAA() {
> 
>     //(1)super()
> 	//(2)调用本类的普通代码块
> 	System.out.println("AAA() 构造器被调用....");
> 		}
> }
> 
> class BBB extends AAA {
> 
>     {
> 	System.out.println("BBB 的普通代码块...");
> }
> public BBB() {
> 
>     //(1)super()
> 	//(2)调用本类的普通代码块
> 	System.out.println("BBB() 构造器被调用....");	
> 	}
> }
> class BBB extends AAA {
> 
>     {
> 		System.out.println("BBB 的普通代码块...");
> }
> public BBB() {
>
>     //(1)super()
>	//(2)调用本类的普通代码块
> 	System.out.println("BBB() 构造器被调用....");
> 	}
> }
>```
> 
> **6.创建一个子类对象时（继承关系） ，他们的 静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序如下**
> 
> 	1. 父类的静态代码块和静态属性(优先级一样，按定义顺序执行)
> 2. 子类的静态代码块和静态属性(优先级一样，按定义顺序执行)
> 3. 父类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
> 4. 父类的构造方法
> 5. 子类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
> 6. 子类的构造方法
> 
> ```java
> public class CodeBlockDetail04 {
> public static void main(String[] args) {
> 
> 
>     //(1) 进行类的加载
> 	//1.1 先加载 父类 A02 1.2 再加载 B02
> 	//(2) 创建对象
> 	//2.1 从子类的构造器开始
> 	//new B02();//对象
> 	new C02();
> 	}
> }
> class A02 { //父类
> 
>     private static int n1 = getVal01();
> 	static {
> 		System.out.println("A02 的一个静态代码块..");//(2)
> 	}
> 	{
> 	System.out.println("A02 的第一个普通代码块..");//(5)
> }
> 	public int n3 = getVal02();//普通属性的初始化
> 	public static int getVal01() {
>	System.out.println("getVal01");//(1)
> 	return 10;
>}
> 
> public int getVal02() {
> 
>     System.out.println("getVal02");//(6)
> 	return 10;
> }
> 
> public A02() {//构造器
> 	//隐藏
> 	//super()
> 	//普通代码和普通属性的初始化...... System.out.println("A02 的构造器");//(7)
> 	}
> 	}
> class C02 {
> 
>     private int n1 = 100;
> 	private static int n2 = 200;
> 	private void m1() {
> }
> 
> private static void m2() {
> 	}
> 	static {
> 	//静态代码块，只能调用静态成员
> 	//System.out.println(n1);错误
> 	System.out.println(n2);//ok
> 	//m1();//错误
> 	m2();
> 	}
> {
> 
>     //普通代码块，可以使用任意成员
> 	System.out.println(n1);
> 	System.out.println(n2);//ok
> 	m1();
> 	m2();
> 
> 	}
> }
> 
> class B02 extends A02 { //
> 
>     private static int n3 = getVal03();
> 
>     static {
>		System.out.println("B02 的一个静态代码块..");//(4)
> }
>
> public int n5 = getVal04();
> 
>     {
> 		System.out.println("B02 的第一个普通代码块..");//(9)
> }
> 
>	public static int getVal03() {
> 		System.out.println("getVal03");//(3)
> 	return 10;
> }
> 
> public int getVal04() {
> 	System.out.println("getVal04");//(8)
> 	return 10;
> }
> 
> //一定要慢慢的去品.. public B02() {//构造器
> //隐藏了
> //super()
> //普通代码块和普通属性的初始化... System.out.println("B02 的构造器");//(10)
> // TODO Auto-generated constructor stub
> }
> }
> ```
> 
> 
> 
> **7.静态代码块只能调用静态成员(静态属性和静态方法)，普通代码块可以调用任意成员**



### **设计模式**



##### **1.什么是设计模式**

---

> 1. 静态方法和属性的经典使用
>2. 设计模式是在大量的实践中总结和理论化之后优选的代码结构、编码风格、以及解决问题的思考方式。设计模式就像是经典的棋谱，不同的棋局，我们用不同的棋谱，免去我们自己再思考和摸索



##### **2.单例模式**

> ---
>
> > **什么是单例**
>>
> > ---
> 
> > 1. 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法
>> 2. 单例模式有两种方式 ：**1.饿汉式  2.懒汉式**
> >



##### **3.单例模式应用实例 -  饿汉式** 

> > ---
>>
> > **步骤如下**
>>
> > 1. 构造器私有化  -> **防止用户直接 new **
> >
> > 2. 类的内部创建对象
>>
> > 3. 向外暴露一个静态的公共方法  - **getInstance**
> >
> > 4. 代码实现
> >
> >    ```java
> >    class GirlFriend {
> >        private String name;
> >    
> >        // 为了能够在静态方法中返回 gf 对象，需要将其修饰为 static 
> >        private static GirlFriend gf = new GirlFriend("q");
> >    
> >        private GirlFriend(String name){
> >            this.name = name;
> >        }
> >    
> >        // 提供一个公共的 static 方法，返回 gf 对象
> >        public static GirlFriend getInstance(){
> >            return gf;
> >        }
> >    }
> >    ```
> >
> > **饿汉式可能造成创建了对象，但是没有使用，造成资源浪费**



##### **4.单例应用案例 - 懒汉式**

> > ---
>>
> > **步骤如下**
>>
> > 1. 构造器私有化
> >
> > 2. 定义一个 static 静态属性对象
>>
> > 3. 提供一个公共的 static 方法，可以返回一个对象
> >
> > 4. 代码实现
> >
> >    ```java
> >    class Cat{
> >        private String name;
> >    
> >        private static Cat cat;
> >        private Cat(String name){
> >            this.name = name;
> >        }
> >    
> >        public static Cat(){
> >            if(cat == null){
> >                cat = new Cat("xx");
> >            }
> >    
> >            return cat;
> >        }
> >    }
> >    ```
> >
> > **类加载之后，构造器也不会调用**
> >



##### **5.懒汉式和饿汉式的区别**

> > ---
>>
> > 1. 两者最主要的区别在于创建对象的时机不同：**饿汉式是在类加载时就创建了对象实例，而懒汉式是在使用时才创建**
>> 2. 饿汉式不存在线程安全问题，懒汉式存在线程安全问题
> > 3. 饿汉式存在资源浪费的可能。因为一个程序员一个对象实例都没有使用，那么饿汉式创建的对象实例就浪费了，懒汉式是使用时才创建，就不存在这个问题。
> > 4. 在我们 JavaSE 标准类中，java.lang.Runtime  就是经典的单例模式
> >
>> 
> >
> > > **模板设计模式**
> >
> > ---
> >
> > 



### **final**

---

> **final 可以修饰类，属性，方法和局部变量**
>
> > **final的使用场景**
> >
> > 1. 当不希望类被继承时，可以用 final 修饰
> > 2. 当不希望父类的某个方法被子类覆盖/重写时，可以用 final 修饰
> > 3. 当不希望某个类的某个属性的值被修改，可以用 final 修饰
> > 4. 当不希望某个局部变量被修改时，可以用 final 修饰
>



##### **final的注意事项和细节**

> > 1. final 修饰的常量，一般用 XX_XX_XX_XX 来命名
>>
> > 2. final 修饰的属性在定义时，必须赋值，并且之后不可再修改，赋值可以在如下位置
> >
> >    1. 在定义时 ： 如 **public final double MAX_VALUE = 10.1;**
> >    2. 在构造器中
> >    3. 在代码块中
> >
>> 3. 如果 final 修饰的属性是静态的，则初始化的位置只能是 
>  >
>>    **1.定义时    2.在静态代码块          不能在构造器中赋值**
> >
> > 4. final 类不能继承，但是可以有实例化对象
> >
> > 5. 如果类不是 final 类，但是含有 final 方法，则该方法虽然不能重写，但是可以被继承
> >
> > 6. 一般来说，如果一个类是 final 类了，就没有必要再将方法，修饰成 final 方法了，
> >
> > 7. final 不能修饰构造方法（即 构造器）
> >
> > 8. final 和 static 往往搭配使用，效率更高，底层编译器做了优化处理
> >
> > 9. 包装类（Integer,Double,Float,Boolean 等 都是 final )String 也是 final 类



### **抽象类**

---

>**当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象方法，那么这个类就是抽象类**
>
>```java
>abstract class Animal {
>    
>	private String name;
>	public Animal(String name) {
>	this.name = name;
>}
>	//思考：这里 eat 这里你实现了，其实没有什么意义
>	//即： 父类方法不确定性的问题
>	//===> 考虑将该方法设计为抽象(abstract)方法
>	//===> 所谓抽象方法就是没有实现的方法
>	//===> 所谓没有实现就是指，没有方法体
>	//===> 当一个类中存在抽象方法时，需要将该类声明为 abstract 类
>	//===> 一般来说，抽象类会被继承，有其子类来实现抽象方法.
>    // public void eat() {
>	// System.out.println("这是一个动物，但是不知道吃什么..");
>	//}
>    public abstract void eat() ;
>```
>
>> **当父类的一些方法不能确定时，可以用 abstract 关键字来修饰该方法，这个方法就是抽象方法，用 abstract 来修饰该类就是抽象类，一般来说，抽象类会被继承，抽象方法会让子类来实现**
>



##### 1.**抽象类介绍**

>---
>
>1. 用 abstract 关键字l来修饰一个类，这个类就叫做抽象类，
>
>     ```java
> 访问修饰符 abstract 类名{
>
>  }
> ```
>
>​     2.用 abstract 关键字来修饰一个方法 时，这个方法就是抽象方法
>
>​      	**访问修饰符 abstract 返回类型 方法名（参数列表）； // 没有方法体**
>
>​     3.抽象类的价值更多作用在于设计，是设计者设计好后，让子类继承并实现抽象类
>
>       4. 抽象类，是重点，在框架h和设计模式使用较多
>



##### **2.抽象类的使用事项和细节**

>---
>
>1. 抽象类不能实例化
>2. 抽象类不一定要b包含 abstract 方法，**也就是说 ：抽象类可以 没有 abstract 方法**
>    3. 一旦类包含了 abstract 方法，**则这个类必须声明为 abstract**
>4. abstract 只能修饰 类 和 方法，不能修饰属性和其他的
>5. 抽象类可以有任何成员（**抽象类还是类**），比如：非抽象方法，构造器，静态属性
>6. 抽象方法，不能有主体，即不能实现
>7. 如果一个类继承了 抽象 类，则他必须 实现抽象类 的所有抽象方法，除非 他自己也声明为  abstract 类    **所谓实现，就是要有方法体**
>8. 抽象方法不能使用 **private 、final、static **来修饰，因为这些关键字 都是和重写相违背的



### **接口**

---

> **借口就是给出一些没有实现的方法，封装到一起，到某个类要使用时，再根据具体的情况把这些方法写出来**

#### 1.语法

---

> ```java
> interface 接口名{
>     // 属性
>     // 抽象方法
> }
> 
> class 类名 implements 接口 {
>     //自己的属性;
>     //自己的方法;
>     //必须实现的借口的抽象方法
> }
> ```
>
> > **小结：** 借口是更加抽象的抽象类，抽象类里的方法可以有方法体，接口里的所有方法都没有方法体【jdk 7.0】。接口体现了程序设计的多态和高内聚低耦合的设计思想
> >
> > **特别说明：** Jdk 8.0 后接口类可以有静态方法，默认方法，也就是说接口中可以有方法的具体实现



#### 2.注意事项和细节

---

> 1. 接口**不能被实例化**
> 2. 接口中的所有方法是 public 方法，接口中抽象方法，可以不用 abstract 修饰
> 3. 一个普通类实现接口，就必须将该借口的所有方法都实现
> 4. 抽象类实现接口，可以不用实现接口的方法
> 5. 一个类同是**可以实现多个接口**
> 6. 接口中的属性，只能是 **final** 的，而且是 **public static final** 修饰符
> 7. 接口属性的访问形式 ： **接口名.属性名**
> 8. **接口中不能继承其他类**，但是可以继承多个接口
> 9. 接口的修饰符，只能是 **public 默认**，这点和类的修饰符是一样的  



#### 3.实现接口 vs 继承类

---

> **接口和继承解决的问题不同**
>
> - 继承的价值主要在于 ：**解决代码的复用性和可维护性**
> - 接口的价值主要在于： **设计，设计好各种规范（方法），让其他类去实现这些方法。即更加的灵活**
>
> **接口比继承更加灵活**
>
> - 接口比继承更加灵活，继承是满足  is - a 的关系，而接口只需满足 like - a 的关系。
>
> **接口在一定程度上实现代码解耦【即： 接口规范性 + 动态绑定机制】**



#### 4.接口的多态性

---

> - **多态参数** 
>
>   ```java
>   public class InterfacePolyParameter {
>   public static void main(String[] args) {
>   	//接口的多态体现
>   	//接口类型的变量 if01 可以指向 实现了 IF 接口类的对象实例
>   	IF if01 = new Monster();
>   	if01 = new Car();
>   	//继承体现的多态
>   	//父类类型的变量 a 可以指向 继承 AAA 的子类的对象实例
>   	AAA a = new BBB();
>   	a = new CCC();
>   	}
>   }
>   interface IF {}
>   class Monster implements IF{}
>   class Car implements IF{}
>   class AAA {
>   }
>   class BBB extends AAA {}
>   class CCC extends AAA {
>   ```
>
> 
>
> - **多态数组**
>
>   ```java
>   public class InterfacePolyArr {
>   	public static void main(String[] args) {
>   	//多态数组 -> 接口类型数组
>   	Usb[] usbs = new Usb[2];
>   	usbs[0] = new Phone_();
>   	usbs[1] = new Camera_();
>   	/*
>   	给 Usb 数组中，存放 Phone 和 相机对象，Phone 类还有一个特有的方法 call（），
>   	请遍历 Usb 数组，如果是 Phone 对象，除了调用 Usb 接口定义的方法外，
>   	还需要调用 Phone 特有方法 call
>   	*/
>   	for(int i = 0; i <usbs.length; i++) {
>   	sbs[i].work();//动态绑定.. //和前面一样，我们仍然需要进行类型的向下转型
>   	if(usbs[i] instanceof Phone_) {//判断他的运行类型是 Phone_
>   		((Phone_) usbs[i]).call();
>   			}
>   		}
>   	}
>   }
>   interface Usb{
>   	void work();
>   }
>   
>   class Phone_ implements Usb {
>   	public void call() {
>   	System.out.println("手机可以打电话...");
>   }
>   	@Override
>   	public void work() {
>   	System.out.println("手机工作中...");
>   	}
>   }
>   	class Camera_ implements Usb {
>   
>   		@Override
>       	public void work() {
>           System.out.println("相机工作中...");
>   	}
>   }
>   ```
>
> 
>
> - **接口存在多态传递现象** 
>
>   ```java
>   /**
>   * 演示多态传递现象
>   */
>   public class InterfacePolyPass {
>   
>   	public static void main(String[] args) {
>   	//接口类型的变量可以指向，实现了该接口的类的对象实例
>   	IG ig = new Teacher();
>   	//如果 IG 继承了 IH 接口，而 Teacher 类实现了 IG 接口
>   	//那么，实际上就相当于 Teacher 类也实现了 IH 接口. //这就是所谓的 接口多态传递现象. IH ih = new Teacher();
>   	}
>   }
>   interface IH {
>   	void hi();
>   }
>   
>   interface IG extends IH{ }
>   
>   class Teacher implements IG
>       @Override
>   	public void hi() {
>   	}
>   }
>   ```

###  内部类

---

#### 1.基本介绍

> 一个类的内部完整的嵌套了另一个类结构。**被嵌套的类成为内部类（inner class）**，**嵌套其他类的类统称外部类（outer class）**，是我们类的第五大成员
>
> 内部类最大的特点就是 **可以直接访问私有属性，并且可以体现类与类之间的包含关系**
>
> 注意：**内部类是学习的难点，同时也是重点，底层源码里有大量内部类**



#### 2.基本语法

---

> ```java
> class Outer{
>     class Inner{
>         
>     }
> }
> 
> class Other{
>     
> }
> ```
>
> > **示例**
> >
> > ```java
> > public class InnerClass01 { //外部其他类
> > public static void main(String[] args) {
> > 	}
> > }
> > class Outer { //外部类
> >     
> > 	private int n1 = 100;//属性
> >     
> > 	public Outer(int n1) {//构造器
> > 		this.n1 = n1;
> > 	}
> >     
> > 	public void m1() {//方法
> > 		System.out.println("m1()");
> > 	}
> > 	{//代码块
> > 		System.out.println("代码块...");
> > 	}
> > 	class Inner { //内部类, 在 Outer
> >         
> >     }
> > }
> > ```



#### 3.内部类的分类

---

> - 定义在外部类局部位置上（比如方法内）：
>   1. 局部内部类（有类名）
>   2. **匿名内部类（没有类名，重点）**
> - 定义在外部类成员位置上：
>   1. 成员内部类（没用 static 修饰）
>   2. 静态内部类（使用 static 修饰）



#### 4.局部内部类

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
>    > **Outer.this 本质就是 外部类的对象**，即哪个对象调用了方法，Outer.this 就指向哪个对象
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

 

#### 5.匿名内部类

---

> **1.本质是类   2.内部类    3.该类没有名字     4.同时还是对象**
>
> **说明：** 匿名内部类是定义在外部类的局部位置，比如方法中，并且没有名字



##### 1.基本语法

---

> ```java
> new 类/接口(参数列表){
> 	//类体
> }
> ```
>
> 





















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
> > testing

### 3.Java 的动态绑定机制