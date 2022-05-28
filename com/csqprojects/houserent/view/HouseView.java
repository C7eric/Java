package Java.com.csqprojects.houserent.view;

import Java.com.csqprojects.houserent.domain.House;
import Java.com.csqprojects.houserent.service.HouseService;
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

    // 设置数组大小为 10
    private HouseService houseService = new HouseService(10);

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
                    addHouse();
                    break;
                case '2' :
                    findHouse();
                    break;
                case '3' :
                    delHosue();
                    break;
                case '4' :
                    updateHouse();
                    break;
                case '5' :
                    listHouses();
                    break;
                case '6' :
                    exitSystem();
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入");
            }
        }while (loop);
    }


    public void listHouses(){

        System.out.println("===============房屋信息显示===============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();

        for (int i = 0; i < houses.length && houses[i] != null; i++) {

            System.out.println(houses[i]);
        }
        System.out.println("==============房屋信息显示完毕==============");
        System.out.println();
    }

    public void addHouse() {

        System.out.println("===============添加房屋信息===============");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(11);
        System.out.print("地址：");
        String address = Utility.readString(25);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(20);

        // 注意 id 是系统分配的，用户不能输入
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    public void delHosue() {

        System.out.println("===============删除房屋信息===============");
        System.out.print("请输入待删除房屋的编号(-1退出):");
        int delId = Utility.readInt();
        if(delId == -1) {
            System.out.println("放弃删除房屋信息");
            return;
        }

        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            if(houseService.del(delId)){
                System.out.println("删除房屋信息成功");
            } else {
                System.out.println("删除失败，房屋编号不存在");
            }
        } else {
            System.out.println("放弃删除房屋信息");
        }
    }

    public void exitSystem() {
        System.out.println("===============退出房屋信息系统===============");
        if(houseService.exit()){
            loop = false;
            System.out.println("你退出了房屋管理系统");
        }
    }

    public void findHouse(){

        System.out.println("===============查询房屋信息===============");
        System.out.println("请输入你要查询的房屋id");
        int findId = Utility.readInt();
        if(houseService.findById(findId) != null){
            System.out.println(houseService.findById(findId));
        } else {
            System.out.println("查询不存在");
        }
    }

    public void updateHouse(){

        System.out.println("===============修改房屋信息===============");
        System.out.println("请输入你要修改的房屋id(-1退出)");
        int updateId = Utility.readInt();
        if(updateId == -1){
            return;
        }
        House house = houseService.findById(updateId);
        if(house == null){
            System.out.println("你要修改的房屋id 不存在" );
            return;
        }

        System.out.println("姓名(" + house.getName() + ")");
        String name = Utility.readString(8,"");
        if(!"".equals(name)){
            house.setName(name);
        }
        System.out.println("电话(" + house.getPhone() + ")");
        String phone = Utility.readString(8,"");
        if(!"".equals(phone)){
            house.setPhone(phone);
        }
        System.out.println("地址(" + house.getAddress() + ")");
        String address = Utility.readString(200,"");
        if(!"".equals(address)){
            house.setAddress(address);
        }
        System.out.println("月租(" + house.getRent() + ")");
        int rent = Utility.readInt(-1);
        if(rent != -1){
            house.setRent(rent);
        }
        System.out.println("状态(" + house.getState() + ")");
        String state = Utility.readString(8,"");
        if(!"".equals(state)){
            house.setState(state);
        }

        System.out.println("修改房屋信息成功！");
    }
}
