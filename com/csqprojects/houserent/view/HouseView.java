package Java.com.csqprojects.houserent.view;

import Java.com.csqprojects.houserent.utilities.Utility;

/**
 *  1. 显示界面
 *  2. 接受用户的输入
 *  3. 调用 HouseService 完成对房屋信息的各种操作
 */
public class HouseView {

    /**
     *  控制显示菜单
     */
    private boolean loop = true;

    /**
     *  接受用户选择
     */
    private char key;

    public void mainMenu() {

        do{
            System.out.println("===============房屋出租系统===============");
            System.out.println("\t\t\t1. 新增房源");
            System.out.println("\t\t\t2. 查找房源");
            System.out.println("\t\t\t3. 删除房屋");
            System.out.println("\t\t\t4. 修改房屋信息");
            System.out.println("\t\t\t5. 显示房屋信息");
            System.out.println("\t\t\t6. 退出系统 ");
            System.out.println("请输入你的选择");
            key = Utility.readChar();
            switch (key) {
                case '1' :
                    System.out.println("\t\t\t1. 新增房源");
                    break;
                case '2' :
                    System.out.println("\t\t\t1. 查找房源");
                    break;
                case '3' :
                    System.out.println("\t\t\t1. 删除房源");
                    break;
                case '4' :
                    System.out.println("\t\t\t1. 修改房源");
                    break;
                case '5' :
                    System.out.println("\t\t\t1. 显示房源");
                    break;
                case '6' :
                    System.out.println("\t\t\t1. 退出系统   ");
                    loop = false;
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入");
            }
        }while (loop);
    }
}
