package model;

import java.util.ArrayList;


public class User implements IUser{
    protected String username;
    protected String password;
    private int role;
    private static final int MAX_NUMBER = 4;
    ArrayList<Book> books = new ArrayList<Book>();

    //创建管理员
    private static final User manager = new User("manager","123456",1);

    public User(String username,String password,int role){
        this.username = username;
        this.password = password;
        this.role = 0;
    }

    //借书
    public void borrowBook(String bookName,int bookPage,float bookPrice,String remark,String label){
        if(books.size() >= MAX_NUMBER){
            System.out.println("超过最大借书容量");
        }
        else{
            books.add(new Book(bookName,bookPage,bookPrice,remark,label,true));
            //移除图书馆书籍，更新图书馆信息
        }
    }

    //还书
    public void returnBook(String bookName,int bookPage,float bookPrice,String remark,String label){
        if(books.size() <= 0){
            System.out.println("你没有未归还的书");
            return;
        }
        int index = -1;
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).bookName.equals(bookName) && books.get(i).bookPage == bookPage && books.get(i).bookPrice == bookPrice){
                index = i;
                books.get(i).isBorrow = false;
                books.remove(i);
                break;
            }
        }
        if(index < 0){
            System.out.println("你未借过该书籍");
            return;
        }
        //还入图书馆，更新图书馆信息

    }

    //输出借书人信息
    public void userInfo(){
        System.out.println("------------------------------借阅人信息------------------------------");
        System.out.println("借阅人姓名："+this.username);
        for(int i = 0; i < books.size(); i++){
            System.out.println("第"+(i+1)+"本书: ");
            System.out.println("书籍名称："+books.get(i).getBookName());
            System.out.println("书籍页数："+books.get(i).getBookPage());
            System.out.println("书籍价格："+books.get(i).getBookPrice());
            System.out.println("书籍备注："+books.get(i).getRemark());
            System.out.println("书籍分类："+books.get(i).getLabel());
        }
        System.out.println("当前借阅书本数为: "+books.size()+" 剩余容量为: "+(MAX_NUMBER-books.size()));
        System.out.println("------------------------------------------------------------------------");
    }

}
