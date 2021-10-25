package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu3 {
    public void menu(){

        Platform platform = Platform.platform;
        int op = 1;
        Scanner sc = new Scanner(System.in);
        while (op != 0) {
            System.out.println("---------------------管理员界面------------------");
            System.out.println("1.添加书籍              2.删除书籍");
            System.out.println("3.修改书籍              4.添加分类");
            System.out.println("5.删除分类              6.修改分类");
            System.out.println("7.查看所有书籍           8.查看所有用户信息");
            System.out.println("0.退出管理员界面");
            System.out.println("-------------------------------------------------");
            System.out.printf("请输入操作选项：");
            op = sc.nextInt();
            switch (op){
                case 1:
                    Library.library.addBook();
                    break;
                case 2:
                    Library.library.removeBook();
                    break;
                case 3:
                    Library.library.changeBook();
                    break;
                case 4:
                    Library.library.addLabel();
                    break;
                case 5:
                    Library.library.removeLabel();
                    break;
                case 6:
                    Library.library.changeLabel();
                    break;
                case 7:
                    Library.library.booksInfo();
                    break;
                case 8:
                    for(int i = 1; i < platform.users.size(); i++){
                        platform.users.get(i).userInfo();
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
