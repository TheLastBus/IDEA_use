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

    @Override   //防止空指针 非空判断
    public Clothes findById(String cid) throws BusinessException {
        Clothes c = c =  clothesIo.findById(cid);  //这没法捕获 没有错误,,


        if(c!=null){   //空指针的非空判断
            return c;
        }else{  //空指针时候抛出
            throw new BusinessException("input.error");  //抛出异常 并且自己不解决 throws扔出去
        }            //从扔程序默认的,变成了扔的自己的 ,但是没有捕获异常 应该像没变换前,输入错程序中断才对*/
    }
    @Override
    public void update() throws BusinessException {
        clothesIo.update();
    }

}
