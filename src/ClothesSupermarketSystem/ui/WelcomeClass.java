package ClothesSupermarketSystem.ui;

import ClothesSupermarketSystem.ui.BaseClass;
import ClothesSupermarketSystem.util.BusinessException;
import ClothesSupermarketSystem.util.UserIO;

/**
 * @author zy
 * @date 2019-10-22 23:35
 * @reason : 大体写出来后 --写注册--ui里
 *
 * 看因为什么捕获的异常显示什么  login时候没有 io等异常 所以
 *
 */
public class WelcomeClass extends BaseClass {

    public void start(){
        println(getString("info.welcome"));
        UserIO userIO = new UserIO();
        userIO.readUsers();
        boolean flag = true;
        while(flag){
            println(getString("info.login.reg"));
            println(getString("info.select"));
            String s = input.nextLine();  //输入序号
            switch(s){
                case "1":  //只有选了 1 或 2 才能退出来 否则就循环
                    try {
                        new LoginClass().login();
                        println(getString("login.success"));
                        flag = false;
                    } catch (BusinessException e) {
                        println(getString(e.getMessage()));  //显示抛的内容  这才能调用无此用户 和login 重叠了...
                    }

                    break;
                case "2":
         //           System.out.println("注册");
                    try {
                        new RegisterClass().register();
                        println(getString("reg.success"));
                        flag = false;
                    } catch (BusinessException e) {
                        println(getString("reg.error"));


                    }
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }



    }

}