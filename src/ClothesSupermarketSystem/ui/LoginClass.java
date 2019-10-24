package ClothesSupermarketSystem.ui;

import ClothesSupermarketSystem.bean.User;
import ClothesSupermarketSystem.service.UserService;
import ClothesSupermarketSystem.service.impl.UserServiceImpl;
import ClothesSupermarketSystem.util.BusinessException;

/**
 * @author zy
 * @date 2019-10-23 12:04
 * @reason :
 */
public class LoginClass extends BaseClass{

    public void login() throws BusinessException {
        print(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);//登陆成功返回user对象  后面用

        if(user!=null){  //返回查找有此用户 表示成功
            currUser=user;   //当前操作用户
        }else{
            throw new BusinessException("login.error");
        }

    }


}
