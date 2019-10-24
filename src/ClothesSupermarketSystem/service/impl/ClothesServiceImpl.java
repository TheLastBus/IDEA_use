package ClothesSupermarketSystem.service.impl;

import ClothesSupermarketSystem.bean.Clothes;
import ClothesSupermarketSystem.service.ClothesService;
import ClothesSupermarketSystem.util.BusinessException;
import ClothesSupermarketSystem.util.ProductsXmlUtils;

import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 20:17
 * @reason :  第二个工具类    先读入衣服列表
 */
public class ClothesServiceImpl implements ClothesService {


    @Override
    public List<Clothes> list() throws BusinessException {

        List<Clothes> clothes = ProductsXmlUtils.paarseProductFromXml();  //获取衣服列表
        return clothes;
    }
}
