package ClothesSupermarketSystem.ui;

import ClothesSupermarketSystem.bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author zy
 * @date 2019-10-22 22:59
 * @reason :  抽象父类  基础类
 *
 * ResourceBundle  因为只读就用他了
 *
 */
public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in);
    protected static User currUser; //当前登陆的用户
    private static ResourceBundle r = ResourceBundle
            .getBundle("ClothesSupermarketSystem/res/r"); // ClothesSupermarketSystem.res.r   //这个类不能写全名

    // 把r调用封装一个方法  用来 获取properties 通过key获取内容
    public static String getString (String key){
        return r.getString(key);
    }

    //封装输出方法
    public static void println(String s){
        System.out.println(s);
    }
    //封装输出方法''''''
    public static void print(String s){
        System.out.println(s);
    }

}
