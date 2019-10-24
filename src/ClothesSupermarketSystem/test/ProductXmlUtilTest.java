package ClothesSupermarketSystem.test;

import ClothesSupermarketSystem.bean.Clothes;
import ClothesSupermarketSystem.util.ProductsXmlUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 19:47
 * @reason :
 */
public class ProductXmlUtilTest {
    @Test
    public void test(){
        List<Clothes> clothes = ProductsXmlUtils.parseProductFromXml();

  //      System.out.println(Arrays.toString(clothes.toArray()));

        for (Clothes clothe : clothes) {
            System.out.println(clothe);
        }


    }

}
