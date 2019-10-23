package ClothesSupermarketSystem.util;

/**
 * @author zy
 * @date 2019-10-22 23:53
 * @reason :  异常类运行时   自己写 可以在可能错的放抛出自己
 */
public class BusinessException extends RuntimeException{

    public BusinessException() {
    }

    public BusinessException(String errormessage) {
        super(errormessage);
    }
}
