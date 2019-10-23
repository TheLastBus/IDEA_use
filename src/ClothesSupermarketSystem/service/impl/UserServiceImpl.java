package ClothesSupermarketSystem.service.impl;

import ClothesSupermarketSystem.bean.User;
import ClothesSupermarketSystem.service.UserService;
import ClothesSupermarketSystem.util.BusinessException;
import ClothesSupermarketSystem.util.EmptyUtils;
import ClothesSupermarketSystem.util.UserIO;

/**
 * @author zy
 * @date 2019-10-23 0:00
 * @reason :   这就是一个工具类啊 各种工具------  通用性-只定义了需要接收的变量 具体值都是传入进来
 * 被观察者实现类?
 *
 * 注册需要有存储 数据库没学先用文件---新建一个操作文件类 UserIO
 */
public class UserServiceImpl implements UserService {

    //注册(存起来)
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.wirteUsers();
        return user;
    }

    //登陆
    @Override
    public User login(String username, String password) throws BusinessException {
        //判断不为空
        if(EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if(EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }
        UserIO userIO = new UserIO();
        User user = userIO.findUser(username, password);
        return user;
    }


}
