#  Java 笔记

## **知识点**

### **类变量**

> **什么是 类变量**
>
> 类变量也叫静态变量/静态属性，是该类的所有对象共享的变量，任何一个该类的对象去访问它时，取到的都是相同的值，同样任何一个该类的对象去修改它时，修改的也是同一个变量。
>
> 
>
> **如何定义类变量**
>
> **定义语法**
>
> 访问修饰符 static 数据类型 变量名
>
>  
>
> **如何访问类变量**
>
> 类名.类变量名 
>
> 或者  对象名.类变量名 **静态变量的访问修饰符的访问权限和范围 和 普通属性是一样的**
>
> ```java
> public static void mian(String[] args){
>     
>     // 类名.类变量名
>     // 说明： 类变量是随着类的加载而创建的，所以即使没有创建对象实例也可以访问
>     System.out.println(A.name);
>     
>     // 通过对象名.类变量名 也可以访问
>     A a = new A();
>     System.out.println(a.name);
> }
> 
> class A {
>     // 类变量
>     // 类变量的访问，必须遵守相关的访问权限
>     public static String name = "csq";
> }
> ```
>
> > **类变量的使用注意事项和细节**
>
> 
>
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
> **5.实例变量不能通过 类名.类变量名 方式访问**
>
> **6.类变量是在类加载的时候就初始化了，也就是说，即使没有创建对象，只要类加载了，就可以使用类变量**
>
> **7.类变量的生命周期是随着类的加载开始，随着类的消亡而销毁**



### **类方法**

> **类方法基本介绍**
>
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
> > > > **类方法经典的使用场景**
> > >
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
> > >   
> > >
> > > > **小结**
> > >
> > > 在程序实际开发中，往往会将一些通用的方法，设计成静态方法，这样我们不需要创建对象就可以使用，比如打印一维数组，冒泡排序，完成某个计算任务
> > >
> > >  
> > >
> > > > **类方法使用注意事项和细节**
> > >
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

> > **main 方法的形式**
>
> ```java
> public static void main(String [] args){}
> ```
>
> > **1. main 方法是虚拟机调用**
> >
> > **2. Java 虚拟机需要调用类的 main 方法，所以该方法的访问权限必须是 public **
> >
> > **3. Java 虚拟机在执行 main 方法时不必创建对象，所以该方法必须是 static**
> >
> > **4.该方法接收 String 类型的数组参数，该数组中保存执行 Java 命令时传递给所运行的类的参数**
> >
> > **5. Java 执行的程序 参数1 参数2 参数3 **
>
> 
>
> > **特别提示**
> >
> > **1.在 main 方法中，我们可以直接调用 main 方法所在类的静态方法 或 静态属性**
> >
> > **2. 但是不能直接访问该类中的非静态成员，必须创建该类的一个实例对象后，才可以通过这个对象去访问类中的非静态成员**



###  **代码块**

> >  **基本介绍**
>
> 代码块又称 初始化块 ，属于类中的成员[即 是类的一部分]，类似于方法，将逻辑语句封装在方法体中，通过 {} 包围起来
>
> 但和方法不同，没有方法名 ，没有返回，没有参数，只有方法体，而且不用通过对象或类 显式调用，而是加载类时，或创建对象时隐式调用
>
> > **基本语法**
>
> ```java
> (修饰符){
> };
> ```
>
> > **说明注意**
>
> 1. 修饰符可选，要写的话，也只能写 static
> 2. 代码块分为两类，使用 static 修饰的叫 静态代码块，没有 static 修饰的，叫普通代码块/非静态代码块
> 3. 逻辑语句可以为任何逻辑语句（输入，输出，方法调用，循环，判断等）
> 4.  ；可以写，也可以省略 
>
> > **代码块的好处**
>
> - 相当于另外一种形式的构造器（对构造器的补充机制），可以做初始化的操作
> - **场景：** 如果多个构造器中都有重复的语句，可以抽取到初始化块中，提高代码的重用性
>
> ```java
> public class CodeBlock01 {
> public static void main(String[] args) {
> 
>     Movie movie = new Movie("你好，李焕英");
> 	System.out.println("===============");
> 	Movie movie2 = new Movie("唐探 3", 100, "陈思诚");
> 	}
> }
> class Movie {
>     
> 	private String name;
> 	private double price;
> 	private String director;
> 	//3 个构造器-》重载
> 	//(1) 下面的三个构造器都有相同的语句
> 	//(2) 这样代码看起来比较冗余
> 	//(3) 这时我们可以把相同的语句，放入到一个代码块中，即可
> 	//(4) 这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容
> 	//(5) 代码块调用的顺序优先于构造器.. {
> 	System.out.println("电影屏幕打开...");
> 	System.out.println("广告开始...");
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
> > **代码块的使用注意事项和细节**
>
> 1.  static 代码块也叫做 静态代码块，作用就是对类进行初始化，而且谈随着 **类的加载** 而执行，并且只会执行一次，如果是普通代码块，每创建一个对象，就执行一次
> 2. **类什么时候被加载**
>    1. 创建对象实例的时候（new)
>    2. 创建子类对象实例的时候，父类也会被加载
>    3. 使用类的静态成员时（静态属性/静态方法）
> 3. 普通的代码块，在创建对象实例时，会被隐式调用，被创建一次，调用一次  **如果只是使用类的静态成员时，普通代码块并不会执行**
>
> > **小结**
>
> 1.  static 代码块是在类加载时，执行，且只执行一次
> 2. 普通代码块是在创建对象时调用的，创建一次，调用一次
> 3. 类加载的 3 种 情况需要记住
>
> ```java
> public class CodeBlockDetail01 {
>     
> public static void main(String[] args) {
>     
> 	//类被加载的情况举例
> 	//1. 创建对象实例时(new)
> 	// AA aa = new AA();
> 	//2. 创建子类对象实例，父类也会被加载, 而且，父类先被加载，子类后被加载
> 	// AA aa2 = new AA();
> 	//3. 使用类的静态成员时(静态属性，静态方法)
> 	// System.out.println(Cat.n1);
> 	//static 代码块，是在类加载时，执行的，而且只会执行一次. // DD dd = new DD();
> 	// DD dd1 = new DD();
> 	//普通的代码块，在创建对象实例时，会被隐式的调用。
> 	// 被创建一次，就会调用一次。
> 	// 如果只是使用类的静态成员时，普通代码块并不会执行
> 	System.out.println(DD.n1);//8888, 静态模块块一定会执行
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
> 	{
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
> 		System.out.println("Cat 的静态代码 1 被执行...");//
> 	}
> }
> class BB {
> //静态代码块
> 	static {
> 		System.out.println("BB 的静态代码 1 被执行...");//1
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
> 2. 调用普通代码块和普通属性的初始化（注意：普通代码块和普通属性初始化调用的优先级一样，如果有多个普通代码块和普通属性初始化，则按定义顺序调用
> 3. 调用构造方法
>
> ```java
> public class CodeBlockDetail02 {
> public static void main(String[] args) {
> 	
>     A a = new A();
>     // (1) A 静态代码块 01 (2) getN1 被调用...(3)A 普通代码块 01(4)getN2 被调用...(5)A() 构造器被调用
> 	}
> }
> class A {
> 
>     { //普通代码块
> 	System.out.println("A 普通代码块 01");
> }
> 	private int n2 = getN2();//普通属性的初始化
> 	static { //静态代码块
> 	System.out.println("A 静态代码块 01");
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
> ```
>
> 5.构造器的最前面其实隐含了 super() 和 调用普通代码块，静态相关的代码块，属性初始化，在类加载时，就加载完毕，因此是优先于 构造器和 普通代码块执行的
>
> ```java
> public class CodeBlockDetail03 {
> public static void main(String[] args) {
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
> 	}
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
> 	//(2)调用本类的普通代码块
> 	System.out.println("BBB() 构造器被调用....");
> 	}
> }
> ```
>
> **6.创建一个子类对象时（继承关系） ，他们的 静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序如下**
>
> 1. 父类的静态代码块和静态属性(优先级一样，按定义顺序执行)
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
> 	System.out.println("getVal01");//(1)
> 	return 10;
> }
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
> }
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
> 		System.out.println("B02 的一个静态代码块..");//(4)
> }
>     
> public int n5 = getVal04();
> 
>     {
> 		System.out.println("B02 的第一个普通代码块..");//(9)
> }
>     
> 	public static int getVal03() {
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