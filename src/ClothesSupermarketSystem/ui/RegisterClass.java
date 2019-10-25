package ClothesSupermarketSystem.ui;

import ClothesSupermarketSystem.bean.User;
import ClothesSupermarketSystem.service.UserService;
import ClothesSupermarketSystem.service.impl.UserServiceImpl;
import ClothesSupermarketSystem.util.BusinessException;

import javax.lang.model.element.VariableElement;

/**
 * @author zy
 * @date 2019-10-22 23:49
 * @reason :  所有UI (面向用户的类都继承Baseclass,里面由公共的东西)   如果注册失败给一个异常 放utils
 *  用户的所有 注册等操作 写service里  有接口有实现类
 *
 *
 * 注册功能类(模块)  收集用户信息 完成用户创建 存进系统文件
 */
public class RegisterClass extends BaseClass{
    private UserService userService;
    public RegisterClass(){
        userService= (UserService) beanFactory.getBean("userService");

    }

    //注册
    public void register() throws BusinessException {

        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username,password);  //收集好了 封装给用户对象
//        UserService userService = new UserServiceImpl();
        userService.register(user);  //用户注册





    }
}
