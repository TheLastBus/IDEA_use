package ClothesSupermarketSystem.util;

import ClothesSupermarketSystem.bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zy                   工具类
 * @date 2019-10-23 0:08
 * @reason :  用户放集合     对象流传输集合
 *
 * 要操作对象 直接把对象集合放过来 对象操作就过来了(添加 查询...)
 *
 */
public class UserIO {

    private static List<User> users = new ArrayList<>();    //静态 每次也只读一次
    private static final String USER_FILE = "user.obj";   //存储数据的文件名

    //写入用户列表
    public boolean wirteUsers() throws BusinessException {    //和下面解决的没联系  抛出异常的语句不同

        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(USER_FILE)));
            out.writeObject(users);  //每次新加一个 就要把数组用户重新存一边
            out.close();
            return true;
        } catch (IOException e) { //异常打印是 调用一个自己的
            throw new BusinessException("io.write.error");  //被异常捕获时候 显示自己的(以前这个放到条件判断的)
        }
    }

    //读取用户
    public boolean readUsers() throws BusinessException{
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(USER_FILE)));
            users = (List<User>) in.readObject();     //list定义在外面  读写都是它  只是有新增删除用户后 List也会不一样!
            in.close();                                         //所以这里没有返回值  只是看是否成功
            return true;
        } catch (IOException |ClassNotFoundException e) {
            throw new BusinessException("io.read.error");  //不用读取调用直接抛出了??????
        }

    }

    //添加用户
    public void add(User user) {
        user.setId(users.size() + 1);  //id自增的那就是用户数量
        users.add(user);
    }

    //-登陆
    public User findUser(String username,String password){
        for (User user : users) {
            if((user.getUsername().equals(username)) &&(user.getPassword().equals(password))){
                return user;
            }
        }
        return null;
    }


}
