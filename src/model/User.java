package model;

import java.util.ArrayList;
import java.util.Scanner;

public class User{
    protected String username;
    protected String password;
    private int role;
    private static final int MAX_NUMBER = 4;
    ArrayList<Book> books = new ArrayList<>();
    //创建管理员
    private static final User manager = new User("manager","123456",1);

    public User(String username,String password,int role){
        this.username = username;
        this.password = password;
        this.role = 0;
    }

    //借书
    public void borrowBook(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入书籍名称：");
        String bookName = sc.next();
        if(books.size() >= MAX_NUMBER){
            System.out.println("超过最大借书容量");
        }
        else{
            ArrayList<Book> libraryBook = Library.library.libraryBook;
            for(int i = 0; i < libraryBook.size(); i++){
                if(libraryBook.get(i).getBookName().equals(bookName)){
                    if(libraryBook.get(i).getIsBorrow()){
                        System.out.println("此书已被借出！");
                    }else{
                        books.add(libraryBook.get(i));
                        libraryBook.get(i).setIsBorrow(true);
                        System.out.println("借书成功！");
                    }
                    return;
                }
            }
            System.out.println("未找到此书！");
        }
    }

    //还书
    public void returnBook(){
        if(books.size() <= 0){
            System.out.println("你没有未归还的书");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入书籍名称：");
        String bookName = sc.next();
        int index = 0;
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getBookName().equals(bookName)){
                index = 1;
                books.get(i).setIsBorrow(false);
                books.remove(i);
                System.out.println("还书成功！");
                break;
            }
        }
        System.out.println("未借过该书籍!");
    }

    //输出借书人信息
    public void userInfo(){
        System.out.println("------------------------------借阅人信息------------------------------");
        System.out.println("借阅人姓名："+this.username);
        for(int i = 0; i < books.size(); i++){
            System.out.println("第"+(i+1)+"本书: ");
            System.out.println("书籍名称："+books.get(i).getBookName());
            System.out.println("书籍作者："+books.get(i).getAuthor());
            System.out.println("书籍页数："+books.get(i).getBookPage());
            System.out.println("书籍价格："+books.get(i).getBookPrice());
            System.out.println("书籍备注："+books.get(i).getRemark());
            System.out.println("书籍分类："+books.get(i).getLabel());
        }
        System.out.println("当前借阅书本数为: "+books.size()+" 剩余容量为: "+(MAX_NUMBER-books.size()));
        System.out.println("------------------------------------------------------------------------");
    }

}
