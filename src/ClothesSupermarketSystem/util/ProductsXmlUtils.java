package ClothesSupermarketSystem.util;

import ClothesSupermarketSystem.bean.Clothes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zy
 * @date 2019-10-23 18:25
 * @reason : xml存了很多衣服
 *
 *   没有对象操作 只是做一个变化功能 写出来模块化   用静态方法 更方便
 *
 * 就是用来解析xml文件的
 */
public class ProductsXmlUtils {

    //解析xml (静态方法) 直接类名调用
    public static List<Clothes> parseProductFromXml(){
        List<Clothes> products = new ArrayList<>();  //cloth 对象的集合

        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());  //   用后面的显示信息替换
        xStream.alias("clothes",Clothes.class);     //和写入时候一样....
        xStream.useAttributeFor(Clothes.class,"id");

        try {
            BufferedInputStream inputStream = new BufferedInputStream(
                    new FileInputStream("clothes.xml"));
            products = (List<Clothes>) xStream.fromXML(inputStream); //即List<Clothes> products  读出来的也是一个个对象!!和写进去的一样
                        //写进去是用集合存多个clothes的 接收就可以强转为集合了(里面本来就是多个cloth对象)
                inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return products;
    }

    // 如果卖出去了 再存一遍刷新     静态方法 类名调用
    public static void writeProductTOxml(List<Clothes> products){
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());  // 从转码又给导回来了   用后面的显示信息替换
        xStream.alias("clothes",Clothes.class);     //反转码化变回来了
        xStream.useAttributeFor(Clothes.class,"id");

        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream("clothes.xml"));
            bos.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());
            xStream.toXML(products,bos);
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
