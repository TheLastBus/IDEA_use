package ClothesSupermarketSystem.bean;

import ClothesSupermarketSystem.util.OrderStatusType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zy
 * @date 2019-10-22 21:45
 * @reason : 订单 一对多 订单明细   类与类
 *               一对一  用户      类与类
 *
 * 很多人的订单 商场总订单
 */
public class Order {
    private int orderId;  //订单Id
    private List<OrderItem> orderItemList = new ArrayList<>();   //一对多关系
    private String createDate;   //生成事件
    private float sum;   //总金额
    private OrderStatusType status = OrderStatusType.UNPAID;   //状态 枚举类型
    private int userId;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
