package ClothesSupermarketSystem.service;

import ClothesSupermarketSystem.bean.Order;
import ClothesSupermarketSystem.util.BusinessException;

import java.util.List;

/**
 * @author zy
 * @date 2019-10-24 18:09
 * @reason :
 */
public interface OrderService {

    //三个业务方法 买 查 找
    public void buyProduct(Order o) throws BusinessException;
    public List<Order> list () throws BusinessException;
    public Order findById(int orderId) throws BusinessException;

}
