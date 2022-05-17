package Java.com.csqjava.object_;

public class ToString_ {
    public static void main(String[] args) {

        /**
         * Object 的 toString() 源码
         *  1.getClass().getName() 类的全类名(包名 + 类名)
         *  2.Integer.toHasString(hasCode()) 将对象的hasCode值转成16进制字符串
         *
         *  public String toString(){
         *
         *  return getClass().getName() + "@" +Integer.toHexString(hasCode());
         *
         */

        /*
            重写 toString 方法,打印对象或者拼接对象时,都会自动调用该对象的toString形式

            当直接输出一个对象时,toString 方法会被默认的调用
         */
        Monster monster1 = new Monster("xm","巡山",200000);
        System.out.println(monster1.toString());
        System.out.println(monster1);
    }
}

    class Monster{

        private String name;
        private String job;
        private double sal;

        public Monster(String name, String job, double sal) {
            this.name = name;
            this.job = job;
            this.sal = sal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public double getSal() {
            return sal;
        }

        public void setSal(double sal) {
            this.sal = sal;
        }

        // 重写toString方法,输出对象的属性
        // 使用快捷键即可生成, alt + Insert -> toString

        @Override
        public String toString() {  // 一般是把对象的属性值输出,也可以自己定制
            return "Monster{" +
                    "name='" + name + '\'' +
                    ", job='" + job + '\'' +
                    ", sal=" + sal +
                    '}';
        }
    }

