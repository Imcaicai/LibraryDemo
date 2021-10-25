package model;

import java.util.*;

public class Library {
    public static final Library library = new Library();
    public ArrayList<Book> libraryBook = new ArrayList<>();
    public ArrayList<String> label = new ArrayList<>();

    public Library(){
        label.add("漫画");
        label.add("小说");
        label.add("计算机");
    }

    //添加书籍
    public void addBook(){
        Book book;
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入书的分类：");
        String label = sc.next();

        if(label.equals("漫画书")){
            book = new ComicBook();
            System.out.printf("请输入书的出版社：");
            ((ComicBook)book).setPublisher(sc.next());
        }
        else if(label.equals("小说")){
            book = new NovelBook();
            System.out.printf("请输入书的男主人公：");
            ((NovelBook)book).setLeadingMan(sc.next());
            System.out.printf("请输入书的女主人公：");
            ((NovelBook)book).setLeadingWoman(sc.next());
        }
        else if(label.equals("计算机")){
            book = new ComputerBook();
            System.out.printf("请输入书的主题：");
            ((ComputerBook)book).setTheme(sc.next());
        }
        else {
            book = new Book();
        }

        book.setLabel(label);
        System.out.printf("请输入要添加的书名：");
        book.setBookName(sc.next());
        System.out.printf("请输入作者名称：");
        book.setAuthor(sc.next());
        System.out.printf("请输入书的页数：");
        book.setBookPage(sc.nextInt());
        System.out.printf("请输入书的价格：");
        book.setBookPrice(sc.nextFloat());
        System.out.printf("请输入书的备注：");
        book.setRemark(sc.next());
        libraryBook.add(book);
    }

    //删除书籍
    public void removeBook(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入您要删除的书籍名称：");
        String bookName = sc.next();
        System.out.println("请输入您要删除的书籍页数：");
        int bookPage = sc.nextInt();

        int index = -1;
        for(int i = 0; i < libraryBook.size(); i++){
            if(libraryBook.get(i).getBookName().equals(bookName) && libraryBook.get(i).getBookPage() == bookPage){
                index =  i;
                libraryBook.remove(i);
                System.out.println("删除成功！");
                break;
            }
        }
        if(index < 0){
            System.out.println("该图书不在书库中！");
            return;
        }
    }

    //查找书籍
    public void checkBook(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入您要查找的书籍名称：");
        String bookName = sc.next();
        System.out.println("请输入您要查找的书籍页数：");
        int bookPage = sc.nextInt();

        for(int i = 0; i < libraryBook.size(); i++){
            if(libraryBook.get(i).getBookName().equals(bookName) && libraryBook.get(i).getBookPage() == bookPage){
                if(libraryBook.get(i).isBorrow)
                    System.out.println("状态：书籍被借出");
                else
                    System.out.println("状态：书籍在库中");
                return;
            }
        }
        System.out.println("状态：书籍不在库中");
    }

    //更改书籍信息
    public void changeBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------修改书籍------------------");
        System.out.println("1.修改图书作者            2.修改图书价格");
        System.out.println("3.修改图书备注            4.修改图书分类");
        System.out.println("----------------------------------------------");
        System.out.printf("请输入您要修改的书籍名称：");
        String bookName = sc.next();
        System.out.printf("请输入您要修改的书籍页数：");
        int bookPage = sc.nextInt();
        int index = -1;
        for(int i = 0; i < libraryBook.size(); i++) {
            if(libraryBook.get(i).getBookName().equals(bookName) &&
                    libraryBook.get(i).getBookPage() == bookPage){
                index = i;
                break;
            }
        }
        System.out.printf("请输入要修改的内容：");
        int op = sc.nextInt();
        switch (op){
            case 1:
                System.out.printf("输入修改后的作者名：");
                libraryBook.get(index).setAuthor(sc.next());
                break;
            case 2:
                System.out.printf("输入修改后的价格：");
                libraryBook.get(index).setBookPrice(sc.nextFloat());
                break;
            case 3:
                System.out.printf("输入修改后的备注：");
                libraryBook.get(index).setRemark(sc.next());
                break;
            case 4:
                System.out.printf("输入修改后的分类：");
                libraryBook.get(index).setLabel(sc.next());
                break;
        }
        System.out.println("更改书籍完成");
    }

    //添加分类
    public void addLabel(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入要添加的分类名：");
        label.add(sc.next());
        System.out.println("添加成功！");
    }

    //删除分类
    public void removeLabel(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入要删除的分类名：");
        String la = sc.next();
        int index = 0;
        for(int i = 0; i < libraryBook.size(); i++){
            if(libraryBook.get(i).getLabel().equals(la)){
                libraryBook.get(i).setLabel("无");
                index = 1;
            }
        }
        if(index == 1){
            label.remove(la);
            System.out.println("删除成功！");
        }else{
            System.out.println("不存在此分类！");
        }
    }

    //修改分类
    public void changeLabel(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入要修改的分类名：");
        String la = sc.next();
        System.out.printf("请输入修改后的分类名：");
        String lb = sc.next();
        int index = 0;
        for(int i = 0; i < libraryBook.size(); i++){
            if(libraryBook.get(i).getLabel().equals(la)){
                libraryBook.get(i).setLabel(lb);
                index = 1;
            }
        }
        if(index == 1){
            label.remove(la);
            label.add(lb);
            System.out.println("修改成功！");
        }else{
            System.out.println("不存在此分类！");
        }
    }

    //查看当前图书馆书籍信息
    public void booksInfo(){
        System.out.println("-----------------------------图书馆书籍信息-----------------------------");
        for(int i = 0; i < libraryBook.size(); i++) {
            System.out.println("在库书籍 "+(i+1)+" : ");
            System.out.println("书籍作者："+libraryBook.get(i).getAuthor());
            System.out.println("书籍分类："+libraryBook.get(i).getLabel());
            System.out.println("书籍名称："+libraryBook.get(i).getBookName());
            System.out.println("书籍页数："+libraryBook.get(i).getBookPage());
            System.out.println("书籍价格："+libraryBook.get(i).getBookPrice());
            System.out.println("书籍备注："+libraryBook.get(i).getRemark());
            System.out.printf("\n");
        }
        System.out.println("在库书籍总数："+libraryBook.size());
        System.out.println("--------------------------------------------------------------------------");
    }

}
