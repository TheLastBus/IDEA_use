package ClothesSupermarketSystem.util;

/**
 * @author zy
 * @date 2019-10-22 23:53
 * @reason :  异常类运行时   自己写   直接能引用配置文件里的
 */
public class BusinessException extends RuntimeException{

    public BusinessException() {
    }

    public BusinessException(String errormessage) {
        super(errormessage);
    }
}
