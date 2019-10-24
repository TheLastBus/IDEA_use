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
        userIO.readUsers();  //登陆前就有了
        boolean flag = true;
        while(flag){
            println(getString("info.login.reg"));
            println(getString("info.select"));
            String s = input.nextLine();  //输入序号
            switch(s){
                case "1":  //只有选了 1 或 2 才能退出来 否则就循环         这里正常不捕获就会中断 打印错误信息 try后打印自己的且程序不会停
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
                        println(getString("reg.success"));  //运行时为了显示自己的异常 throw 出来了就要捕获
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
        new HomeClass().show();  //登陆成功后  显示购买菜单

    }

}
