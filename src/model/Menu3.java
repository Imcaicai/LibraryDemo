package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu3 {
    public void menu(){

        int op = 1;
        Scanner sc = new Scanner(System.in);
        while (op != 0) {
            System.out.println("---------------------管理员界面------------------");
            System.out.println("1.添加书籍              2.删除书籍");
            System.out.println("3.修改书籍              4.添加分类");
            System.out.println("5.删除分类              6.修改分类");
            System.out.println("7.反序列化书籍           8.反序列化用户");
            System.out.println("9.查找书籍              10.序列化用户");
            System.out.println("11.序列化书籍            0.退出管理员界面");
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
                    File file7 = new File("d:\\b.book");
                    try(ObjectInputStream out = new ObjectInputStream(new FileInputStream(file7)))
                    {
                        //执行反序列化读取
                        Book[] bookObject = (Book[])out.readObject();
                        List<Book> bookList = Arrays.asList(bookObject);
                        for(int i = 0; i < bookList.size(); i++){
                            System.out.println(bookList.get(i).toString());
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    File file8 = new File("d:\\a.user");
                    try(ObjectInputStream out = new ObjectInputStream(new FileInputStream(file8)))
                    {
                        //执行反序列化读取
                        User[] userObject = (User[])out.readObject();
                        List<User> userList = Arrays.asList(userObject);
                        for(int i = 0; i < userList.size(); i++){
                            System.out.println(userList.get(i).toString());
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    Library.library.checkBook();
                    break;
                case 10:
                    File file10 = new File("d:\\a.user");
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file10)))
                    {
                        //将list转换成数组
                        User[] userObj = new User[Platform.platform.users.size()];
                        Platform.platform.users.toArray(userObj);
                        //执行序列化存储
                        out.writeObject(userObj);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 11:
                    File file11 = new File("d:\\b.book");
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file11)))
                    {
                        //将list转换成数组
                        Book[] bookObj = new Book[Library.library.libraryBook.size()];
                        Library.library.libraryBook.toArray(bookObj);
                        //执行序列化存储
                        out.writeObject(bookObj);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
