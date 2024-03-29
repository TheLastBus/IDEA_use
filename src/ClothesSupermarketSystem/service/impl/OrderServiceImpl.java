package ClothesSupermarketSystem.service.impl;

import ClothesSupermarketSystem.bean.Order;
import ClothesSupermarketSystem.service.OrderService;
import ClothesSupermarketSystem.util.BusinessException;
import ClothesSupermarketSystem.util.OrderIo;

import java.util.List;

/**
 * @author zy
 * @date 2019-10-24 18:14
 * @reason :         这里是直接与IO的操作
 */
public class OrderServiceImpl implements OrderService {

    private OrderIo orderIo = new OrderIo();
    boolean flag = false;
    @Override
    public void buyProduct(Order o) throws BusinessException {
        if (o != null) {
            orderIo.add(o);
        } else {
            throw new BusinessException("orderIo.add.error");
        }

    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIo.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIo.findByOrderId(orderId);
    }
}
