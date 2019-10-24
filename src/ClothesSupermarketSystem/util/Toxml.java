package ClothesSupermarketSystem.util;

import ClothesSupermarketSystem.bean.Clothes;
import ClothesSupermarketSystem.bean.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 16:35
 * @reason :
 *
 *   看成进货 进了很多衣服 存到了xml
 *     这个不和IO一样写了集合放对象  那个要对象流存 对象要序列化  ,这个事转码java对象变成xml文件,只是用了集合也可以!!!
 *
 *
 */
public class Toxml {

    public static void main(String[] args) {

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("clothes.xml"));

            List<Clothes> clothes = new ArrayList<>();
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
            clothes.add(cloth);

            Clothes cloth2 = new Clothes();
            cloth2.setId("A002");
            cloth2.setBrand("森马");
            cloth2.setColor("黑色");
            cloth2.setDescription("稳重");
            cloth2.setSize("m");
            cloth2.setNum(150);
            cloth2.setPrice(300f);
            cloth2.setStyle("秋季新款");
            clothes.add(cloth2);

            Clothes cloth3 = new Clothes();
            cloth3.setId("A003");
            cloth3.setBrand("海澜之家");
            cloth3.setColor("白色");
            cloth3.setDescription("少女气息");
            cloth3.setSize("mm");
            cloth3.setNum(110);
            cloth3.setPrice(380.5f);
            cloth3.setStyle("夏季新款");
            clothes.add(cloth3);

            XStream xStream = new XStream(new Xpp3Driver());
            xStream.alias("clothes",Clothes.class);  //起别名   把一长串包名加文件名 变成了clothes
            xStream.useAttributeFor(Clothes.class,"id");  //  把属性id放到 类名clothes里面一起显示

            bos.write("<?xml version = \"1.0\" enconding=\"utf-8\" ?>".getBytes());
            xStream.toXML(clothes,bos);
            bos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void add(Clothes clothe){







    }


}
