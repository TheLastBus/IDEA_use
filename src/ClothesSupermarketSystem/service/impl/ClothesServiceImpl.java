package ClothesSupermarketSystem.service.impl;

import ClothesSupermarketSystem.bean.Clothes;
import ClothesSupermarketSystem.service.ClothesService;
import ClothesSupermarketSystem.util.BusinessException;
import ClothesSupermarketSystem.util.ClothesIo;
import ClothesSupermarketSystem.util.ProductsXmlUtils;

import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 20:17
 * @reason :   clothes 主要是 1 用来做展示和库存  2.在购买时候 订单需要
 */
public class ClothesServiceImpl implements ClothesService {

    private ClothesIo clothesIo= new ClothesIo();

    @Override
    public List<Clothes> list() throws BusinessException {

        return clothesIo.list();

    }

    @Override
    public Clothes findById(String cid) throws BusinessException {

        return clothesIo.findById(cid);

    }
    @Override
    public void update() throws BusinessException {
        clothesIo.update();
    }

}
