package ClothesSupermarketSystem.ui;

import ClothesSupermarketSystem.bean.Clothes;
import ClothesSupermarketSystem.service.ClothesService;
import ClothesSupermarketSystem.service.impl.ClothesServiceImpl;
import ClothesSupermarketSystem.util.ConsoleTable;

import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 19:52
 * @reason :  进去主界面  为了显示 又定义了工具类ClothesService
 */
public class HomeClass extends BaseClass {


    public void show(){
    showProduct();   //显示商品
        println("welcome"+currUser.getUsername());
        boolean flag = true;
        while (flag) {
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select) {
                case "1":   //查询所有订单
                    findList();
                    flag=false;
                    break;
                case "2":  //查找订单
                    findOrderById();
                    flag=false;
                    break;
                case "3":  //购买
                    buyProduct();
                    flag=false;
                    break;
                case "0":  //退出
                    flag=false;
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }

    }

    private void findList(){

    }
    private void findOrderById(){

    }
    private void buyProduct(){

    }
    private void showProduct() {
        ClothesService clothesService = new ClothesServiceImpl();
        List<Clothes> clothes = clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();  //添加一行
        t.appendColum("id") //添加列
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");

        for (Clothes clothe : clothes) {
            t.appendRow();
            t.appendColum(clothe.getId())
                    .appendColum(clothe.getBrand())
                    .appendColum(clothe.getStyle())
                    .appendColum(clothe.getColor())
                    .appendColum(clothe.getSize())
                    .appendColum(clothe.getNum())
                    .appendColum(clothe.getPrice())
                    .appendColum(clothe.getDescription());
        }
        println(t.toString());
    }
}
