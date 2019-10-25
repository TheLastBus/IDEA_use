package ClothesSupermarketSystem.util;

import ClothesSupermarketSystem.bean.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zy                 工具类
 * @date 2019-10-24 17:29
 * @reason : 订单情况 和UserIo一样 存的是对象啊 生成是obj 存入文件(本来数据库)操作
 *
 *
 *
 *  看好是静态方法 还是普通方法
 *
 */
public class OrderIo {
    private static List<Order> orders = new ArrayList<>();  //订单列表
    private static final String ORDER_FILE="order.obj";


    //写文件      不是主动读入写到方法里  通过调用才读写的!!!!!!!!!! 标记就无用了  抛异常只能在别的异常里抛
    private boolean writeOrders() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            out.writeObject(orders);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    //读文件
    private boolean readOrders() {
        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ORDER_FILE));
            orders = (List<Order>) in.readObject();
            in.close();
            return true;
        } catch (IOException |ClassNotFoundException e) {
            e.printStackTrace();  //未找到文件


        }
        return false;
    }

    //增加订单
    public void add(Order order) throws BusinessException {
            orders.add(order);  //只用到集合
            writeOrders();  //写记录 这才用到写文件
    }
    //查询全部订单
    public List<Order> list() throws BusinessException {

        readOrders(); //读记录   首次点肯定错 空指针了     购买的获取id也是它不过 因为扔出异常会继续执行创建
        return orders;

    }

    //通过id查找订单  后面会捕获空指针的  非空判断
    public Order findByOrderId(int orderId) throws BusinessException {

        Order order = null;
        int oid ;
        for (Order order1 : orders) {
            oid=order1.getOrderId();
            if(oid==orderId){
                order = order1;
                break;
            }
        }

        return order;
    }
}
