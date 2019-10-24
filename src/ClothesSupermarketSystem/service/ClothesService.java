package ClothesSupermarketSystem.service;

import ClothesSupermarketSystem.bean.Clothes;
import ClothesSupermarketSystem.util.BusinessException;

import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 20:16
 * @reason :查询列表功能接口    写第二个工具类
 */
public interface ClothesService {

    //获取衣服列表
    public List<Clothes> list() throws BusinessException;
}
