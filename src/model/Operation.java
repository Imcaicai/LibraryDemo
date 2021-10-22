package model;

import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {
        while (true) {
            new Menu1().menu();
            System.out.printf("请输入操作选项：");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            switch (op){
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    break;
            }
        }
    }
}
