package Java.com.csqprojects.houserent;

import Java.com.csqprojects.houserent.view.HouseView;

public class HouseRentApp {

    public static void main(String[] args) {

        //创建 HouseView 对象，并且显示主菜单，是整个程序的入口
        new HouseView().mainMenu();
        System.out.println("你退出了房屋出租系统");
    }
}
