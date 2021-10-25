package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu2 {

    public void menu(int order){

        Platform platform = Platform.platform;
        int op = 1;
        Scanner sc = new Scanner(System.in);
        while (op != 0) {
            System.out.println("---------------------图书管理系统------------------");
            System.out.println("1.借书                2.还书");
            System.out.println("3.查看已借信息          4.进入管理员界面");
            System.out.println("0.退出登录");
            System.out.println("-------------------------------------------------");
            System.out.printf("请输入操作选项：");
            op = sc.nextInt();
            switch (op){
                case 1:
                    platform.users.get(order).borrowBook();
                    break;
                case 2:
                    platform.users.get(order).returnBook();
                    break;
                case 3:
                    platform.users.get(order).userInfo();
                    break;
                case 4:
                    if (order == 0){
                        new Menu3().menu();
                    }
                    else{
                        System.out.println("您没有管理员权限！");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
