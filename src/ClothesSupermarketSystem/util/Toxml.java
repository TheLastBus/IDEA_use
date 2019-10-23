package ClothesSupermarketSystem.util;

import ClothesSupermarketSystem.bean.Clothes;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author zy
 * @date 2019-10-23 16:35
 * @reason :private String id;       //商品编号
 *     private String brand;    //品牌
 *     private String style;    // 款式
 *     private String color;    //颜色
 *     private String size;     //尺寸
 *     private int num;         //库存
 *     private float price;     //单价
 *     private String description;  //描述
 */
public class Toxml {

    public static void main(String[] args) {

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("clothes.xml"));
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            //先构建 cloth对象 在转换成xml
            Clothes cloth = new Clothes();
            cloth.setId("A001");
            cloth.setBrand("拉夏贝尔");
            cloth.setColor("蓝白色");
            cloth.setDescription("青春有活力");
            cloth.setSize("xl");
            cloth.setNum(100);
            cloth.setPrice(280.5f);
            cloth.setStyle("春季新款");

            xmlEncoder.writeObject(cloth);
            xmlEncoder.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
