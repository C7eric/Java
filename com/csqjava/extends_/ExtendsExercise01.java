package Java.com.csqjava.extends_;

public class ExtendsExercise01 {
    public static void main(String[] args) {

        PC pc1 = new PC("i9","16","512","DELL");
        NotePad pad1 = new NotePad("i5","32","1T","black");
        System.out.println(pc1.getDetail());
        System.out.println(pad1.getDetail());
    }
}

class Computer {

    String CPU;
    String RAM;
    String HD;

    public Computer(String CPU, String RAM, String HD) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.HD = HD;
    }

    public String getDetail(){
        return "CPU:" + CPU + "内存:" + RAM + "硬盘:" + HD;
    }
}

class PC extends Computer {

    public PC(String CPU, String RAM, String HD, String brand) {
        super(CPU, RAM, HD);
        this.brand = brand;
    }

    String brand;
}

class NotePad extends Computer {

    public NotePad(String CPU, String RAM, String HD, String color) {
        super(CPU, RAM, HD);
        this.color = color;
    }

    String color;
}
