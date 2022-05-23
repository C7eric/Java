package Java.com.csqhomeworks;

public class Homework01 {
    public static void main(String[] args){
        double[] arr = {1.0,2.5,1.6};
        A01 obj = new A01();
        System.out.println(obj.max(arr));
        System.out.println("--------------------------------------");
        A02 obj2 = new A02();
        String[] arrStr = {"dsds","dss","sqqq","csq"};
        obj2.find(arrStr,"csq");
        System.out.println(obj2.find(arrStr,"csq"));
        System.out.println("--------------------------------------");
        Book book1 = new Book("CSQ",188);
        book1.updatePrice();
        System.out.println(book1.price);
        Book book2 = new Book("csq",88);
        book2.updatePrice();
        System.out.println(book2.price);
        Book book3 = new Book("CSQQ",114);
        book3.updatePrice();
        System.out.println(book3.price);



    }
}

class A01 {

    public double max(double[] arr) {

        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }
}

class A02 {

    public int find(String[] arrStr,String string){
        if(arrStr == null){
            return -1;
        }
        int index = 0;
        for(int i = 0;i < arrStr.length;i++){
            if(arrStr[i].equals(string)){
                index++;
            } else {
                return index;
            }
        }

        return -1;
    }
}

class Book {

    int price;
    String name;
    public Book(String name,int price){
        this.name = name;
        this.price = price;
    }
    public void updatePrice(){

        if(this.price > 150){
            this.price = 150;
        } else if(this.price > 100 && this.price < 150) {
            this.price = 100;
        }
    }
}