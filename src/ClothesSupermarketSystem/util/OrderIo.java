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
 *  看好是静态方法 还是普通方法
 *
 */
public class OrderIo {
    private static List<Order> orders = new ArrayList<>();  //订单列表
    private static final String ORDER_FILE="order.obj";


    //先读写文件
    public boolean writeOrders() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            out.writeObject(orders);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;   //是否写入成功...
    }
    public boolean readOrders() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ORDER_FILE));
            orders = (List<Order>) in.readObject();
            in.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    //增加订单
    public void add(Order order) throws BusinessException {

        orders.add(order);
    }
    //查询全部订单
    public List<Order> list() throws BusinessException {

        return orders;
    }

    //通过id查找订单
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
