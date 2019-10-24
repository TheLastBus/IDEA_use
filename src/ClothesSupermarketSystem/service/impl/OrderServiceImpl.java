package ClothesSupermarketSystem.service.impl;

import ClothesSupermarketSystem.bean.Order;
import ClothesSupermarketSystem.service.OrderService;
import ClothesSupermarketSystem.util.BusinessException;

import java.util.List;

/**
 * @author zy
 * @date 2019-10-24 18:14
 * @reason :         这里是直接与IO的操作
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void buyProduct(Order o) throws BusinessException {

    }

    @Override
    public List<Order> list() throws BusinessException {
        return null;
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return null;
    }
}
