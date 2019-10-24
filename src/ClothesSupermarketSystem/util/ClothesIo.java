package ClothesSupermarketSystem.util;

import ClothesSupermarketSystem.bean.Clothes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zy
 * @date 2019-10-24 20:21
 * @reason :   clothes 主要是 1 用来做展示和库存  2.在购买时候 订单需要
 */
public class ClothesIo {
    private static List<Clothes> list = new ArrayList<>();

    public Clothes findById(String cid) throws BusinessException {
        for (Clothes clothes : list) {
            if(clothes.getId().equals(cid)){
                return clothes;
            }
        }
        return null;
    }

    public List<Clothes> list() throws BusinessException {
        if (list.size() == 0) {
            list = ProductsXmlUtils.parseProductFromXml();
        }
        return list;
    }

    //更新xml文件
    public void update() throws BusinessException {
        ProductsXmlUtils.writeProductTOxml(list);
    }


}
