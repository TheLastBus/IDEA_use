package ClothesSupermarketSystem.freamwork;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @author zy
 * @date 2019-10-25 17:55
 * @reason :  创建bean(这里放 service 三个降低耦合依赖)
 */
public class BeanFactory {
    private Iterator<Element> iterator =null;   //初始化时候 初始出来就行

    public static BeanFactory beanFactory= null;
    //单例模式
    public static BeanFactory init(){
        if(beanFactory == null){
            synchronized (BeanFactory.class){
                if (beanFactory == null) {
                    beanFactory=new BeanFactory("bean.xml");
                }
            }
        }
        return beanFactory;
    }



private BeanFactory(String xml){
    InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);
    //创建DOM4J 解析对象
    SAXReader reader = new SAXReader();


    try {
        Document document = reader.read(is);
        Element rootElement = document.getRootElement();  //所有根节点
        iterator = rootElement.elementIterator();  //找到所用子节点 并给迭代器
        assert is != null;
        is.close();

    } catch (DocumentException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
    public Object getBean(String id) {  //配置文件
        while (iterator.hasNext()) {
            Element bean = iterator.next();
            String sid = bean.attributeValue("id");  //通过关键字 id 获得键
            if (sid.equals(id)) {
                String className = bean.attributeValue("class");//获得class 得到值  全限地址然后  反射对象

                try {
                    return Class.forName(className).newInstance();  //反射得到Class对象 然后得到实现类实例对象
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}