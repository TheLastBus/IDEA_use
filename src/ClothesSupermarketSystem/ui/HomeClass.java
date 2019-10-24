package ClothesSupermarketSystem.ui;

import ClothesSupermarketSystem.bean.Clothes;
import ClothesSupermarketSystem.bean.Order;
import ClothesSupermarketSystem.bean.OrderItem;
import ClothesSupermarketSystem.service.ClothesService;
import ClothesSupermarketSystem.service.OrderService;
import ClothesSupermarketSystem.service.impl.ClothesServiceImpl;
import ClothesSupermarketSystem.service.impl.OrderServiceImpl;
import ClothesSupermarketSystem.util.BusinessException;
import ClothesSupermarketSystem.util.ConsoleTable;
import ClothesSupermarketSystem.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 19:52
 * @reason :  进去主界面  为了显示 又定义了工具类ClothesService
 */
public class HomeClass extends BaseClass {

    private OrderService orderService = new OrderServiceImpl();  //下面多个方法用
    private ClothesService clothesService = new ClothesServiceImpl();

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
                    try {
                        buyProduct();
                        flag=false;
                    } catch (BusinessException e) {
                        println(e.getMessage());  //抛出必须捕获这里  ClothesServiceImpl.findById  input.error  然后flag没变就继续循环
                    }
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

    /**
     * 购买商品
     * @throws BusinessException
     */
    private void buyProduct()throws BusinessException {   //clothesServiceimpl抛出的 自己没解决(位置不合适 ) 也抛出
        //生成订单  需要id 和数量
        boolean flag = true;
        int count = 1;  //订单数
        float sum = 0.0f; //订单总金额
        Order order = new Order();
        while (flag) {
            println(getString("product.input.id"));
            String id = input.nextLine();            // 输入复杂没法捕获 条件判断麻烦 ---只能解决空指针了!!!--
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();

            OrderItem orderItem = new OrderItem();
            Clothes clothes=null;
  //          try {
            clothes = clothesService.findById(id);
   //         } catch (BusinessException e) {        //id不对返回对象空指针了!!
    //            println(getString(e.getMessage()));   // 如果上一个主要是bus异常必须捕获 才能正常 空指针本来解决了
    //        }                                         //clothesServiceImpl 抛出异常这里正确捕获后  try里面赋值就不执行了 人为对象制空了!!!
                                                        // 因为下面马上用到对象 所以错误爆出来还是空指针了  和registclass情况不一样
                                                        //没解决抛出了 给case "3"
            //如果id错误就没有clothes 就空指针了  所以要么更前面返回值判断非空  要么输入时候规定输入
            int num = Integer.parseInt(shoppingNum);
            if (num > clothes.getNum()) {
                println(getString("product.num.error"));  //new buss异常不能在这 必须有捕获地方才可以!
            }else{
                //一条订单明细
                clothes.setNum(clothes.getNum() - num);       //减去库存
            }
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice()*num);  //一个订单的金额
            sum+=orderItem.getSum(); //每个订单金额累计  总营业额
            orderItem.setItemId(count++);
            //加到总订单
            order.getOrderItemList().add(orderItem);
            println(getString("product.buy.continue"));
            String s = input.nextLine();
            switch (s) {
                case "y":
                    flag=true;   //等于什么没做
                    break;
                case "n":
                    flag=false;
                    break;
                default:
                    flag=false;
                    break;
            }
        }

        order.setCreateDate(DateUtil.toDate(new Date()));  //这就获取当前系统时间了
        order.setUserId(currUser.getId());
        order.setSum(sum);  //营业额
        order.setOrderId(orderService.list().size()+1);  //订单总数 就是ID

        orderService.buyProduct(order);  //调用IO方法

        clothesService.update();               //更新库存
        show();
    }
    private void findList(){

    }
    private void findOrderById(){

    }
    private void showProduct() {
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
