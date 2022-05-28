package Java.com.csqprojects.houserent.service;

import Java.com.csqprojects.houserent.domain.House;
import Java.com.csqprojects.houserent.utilities.Utility;

/**
 * 业务层
 *  定义 House 数组，保存 House 对象
 *  响应 HouseService 的调用
 *  完成对房屋信息的各种操作  CRUD
 */
public class HouseService {

    // 保存 House 对象
    private House[] houses;

    // 记录当前有多少个房屋信息
    private int houseNums = 1;

    // 记录当前的 id 自增长到哪个值
    private int idCounter = 1;

    public HouseService(int size) {

        // 当创建 HouseService 对象时，指定数组大小
        houses = new House[size];

        // 为了测试列表信息，在这里初始化一个 House 对象
        houses[0] = new House(  10001,"csq","2686","商丘市香格里拉·城市花园",1500,"未出租");

    }

    /**
     *
     * @return  返回 houses 数组信息
     */
    public House[] list(){

        return houses;
    }

    public boolean add(House newHouse){

        // 判断是否还可以添加
        if(houseNums >= houses.length ){
            System.out.println("数组已满，不能继续添加");
            return false;
        }

        // 将 newHouse 加入到数组的最后
        houses[houseNums++] = newHouse;

        // 需要设计一个 id 自增长的机制
        newHouse.setId(++idCounter);
        return true;
    }

    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = 0; i < houseNums - 1; i++) {

            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;
        return true;
    }

    public boolean exit(){
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            return true;
        }
        return false;
    }

    public House findById(int findId) {

        if(findId < 0 && findId > idCounter){
            return null;
        }
        for (int i = 0; i < houseNums; i++) {
            if(findId == houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }
}

