package ClothesSupermarketSystem.bean;

/**
 * @author zy
 * @date 2019-10-22 21:48
 * @reason : 订单明细  其中某个人的
 */
public class OrderItem {
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
