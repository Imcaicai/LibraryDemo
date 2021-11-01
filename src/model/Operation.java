package model;

import java.util.Scanner;

public class Operation {
    public static void main(String[] args) throws Exception{
        int op = 1;
        int order;
        Platform platform = Platform.platform;
        Scanner sc = new Scanner(System.in);
        while (op != 0) {
            new Menu1().menu();
            System.out.printf("请输入操作选项：");
            op = sc.nextInt();
            switch (op){
                case 1:
                    order = platform.login();
                    if(order >= 0){
                        new Menu2().menu(order);
                    }
                    break;
                case 2:
                    order = platform.register();
                    new Menu2().menu(order);
                    break;
                case 0:
                    System.out.println("欢迎下次使用本系统");
                    return;
            }
        }
    }
}
