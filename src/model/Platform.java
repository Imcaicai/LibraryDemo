package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Platform{
    public static final Platform platform = new Platform();
    public ArrayList<User> users = new ArrayList<>();
    //创建管理员
    private  User manager = new User("manager","123456",1);
    public Platform(){
        users.add(manager);
    }

    //用户注册
    public int register(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入用户名：");
        String name = sc.next();
        System.out.printf("请输入密码：");
        String password = sc.next();
        User user = new User(name,password,0);
        users.add(user);
        System.out.println("注册成功！");


        return users.size()-1;
    }

    //用户登录
    public int login(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入用户名：");
        String name = sc.next();
        System.out.printf("请输入密码：");
        String password = sc.next();
        for(int i = 0; i < users.size(); i++){
            //System.out.println((users.get(i) == null));
            if(users.get(i).getUsername().equals(name)){
                if(users.get(i).getPassword().equals(password)){
                    return i;
                }
                else System.out.println("密码错误！");
                return -1;
            }
        }
        System.out.println("用户名不存在！");
        return -1;
    }
}
