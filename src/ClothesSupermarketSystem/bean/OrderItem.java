package ClothesSupermarketSystem.bean;

import java.io.Serializable;

/**
 * @author zy
 * @date 2019-10-22 21:48
 * @reason : 订单明细  其中某一个人的
 */
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 4458683683654079450L;
    private int itemId;       //货物id
    private Clothes clothes;  //商品
    private int shoppingNum;  //购买数量
    private float sum;        //购买金额


    public OrderItem() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
