package ClothesSupermarketSystem.service;

import ClothesSupermarketSystem.bean.User;
import ClothesSupermarketSystem.util.BusinessException;

/**
 * @author zy
 * @date 2019-10-22 23:59
 * @reason : 用户模块的所有操作 都在这
 */
public interface UserService {

    //注册
    public User register(User user) throws BusinessException;
    //登陆
    public User login(String username,String password) throws BusinessException;

}
