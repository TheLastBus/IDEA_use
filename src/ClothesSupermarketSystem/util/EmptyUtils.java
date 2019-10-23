package ClothesSupermarketSystem.util;

/**
 * @author zy
 * @date 2019-10-23 12:18
 * @reason :  判断用户输入是否为空
 */
public class EmptyUtils {
    public static boolean isEmpty(String s){
        if(null== s||"".equals(s)){
            return true;
        }else{
            return false;
        }
    }
}
