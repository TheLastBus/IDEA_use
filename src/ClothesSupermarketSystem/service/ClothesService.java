package ClothesSupermarketSystem.service;

import ClothesSupermarketSystem.bean.Clothes;
import ClothesSupermarketSystem.util.BusinessException;

import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 20:16
 * @reason :查询列表功能接口    写第二个工具类
 *
 *           clothes 主要是 1 用来做展示和库存  2.在购买时候 订单需要
 *
 */
public interface ClothesService {

    //获取衣服列表
    public List<Clothes> list() throws BusinessException;
    //通过衣物ID找衣服信息
    public Clothes findById(String cid) throws BusinessException;
    //更新库存
    public void update() throws BusinessException;
}
