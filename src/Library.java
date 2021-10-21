import model.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Library {
    private static final Library library = new Library();
    private ArrayList<Book> libraryBook = new ArrayList<>();
    private ArrayList<String> label = new ArrayList<>();

    private Library(){
        label.add("漫画书");
        label.add("小说");
        label.add("计算机");
    }

    //添加书籍
    public void addBook(String bookName,int bookPage,float bookPrice,String remark,String label){
        libraryBook.add(new Book(bookName,bookPage,bookPrice,remark,label,false));
    }

    //删除书籍
    public void removeBook(String bookName,int bookPage,float bookPrice){
        int index = -1;
        for(int i = 0; i < libraryBook.size(); i++){
            if(libraryBook.get(i).getBookName().equals(bookName) && libraryBook.get(i).getBookPage() == bookPage && libraryBook.get(i).getBookPrice() == bookPrice){
                index =  i;
                libraryBook.remove(i);
                break;
            }
        }
        if(index < 0){
            System.out.println("该图书不在书库中");
            return;
        }
    }

    //查找书籍
    public void checkBook(String bookName,int bookPage,float bookPrice){
        for(int i = 0; i < libraryBook.size(); i++){
            if(libraryBook.get(i).getBookName().equals(bookName) && libraryBook.get(i).getBookPage() == bookPage && libraryBook.get(i).getBookPrice() == bookPrice){
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
    public void changeBook(String bookName,int bookPage,float bookPrice,int newBookPage,int newBookPrice,String newRemark,String newLabel){
        for(int i = 0; i < libraryBook.size(); i++) {
            if(libraryBook.get(i).getBookName().equals(bookName) && libraryBook.get(i).getBookPage() == bookPage &&
                    libraryBook.get(i).getBookPrice() == bookPrice) {
                libraryBook.get(i).setBookPage(newBookPage);
                libraryBook.get(i).setBookPrice(newBookPrice);
                libraryBook.get(i).setRemark(newRemark);
                libraryBook.get(i).setLabel(newLabel);
                break;
            }
        }
        System.out.println("更改书籍完成");
    }

    //查看当前图书馆书籍信息
    public void booksInfo(){
        //给书本按照分类排序
        libraryBook.sort(new Comparator<Book>() {
            int flag=0;
            int a;
            @Override
            public int compare(Book b1, Book b2) {
                if(b1.getLabel().compareTo(b2.getLabel()) > 0){
                    return -1;
                }
                else if(b1.getLabel().equals(b2.getLabel())){
                    if(b1.getBookName().compareTo(b2.getBookName()) > 0){
                        return -1;
                    }
                    else if(b1.getBookName().equals(b2.getBookName())){
                        if(b1.getBookPage() < b2.getBookPage()){
                            return -1;
                        }
                        else if(b1.getBookPage() == b2.getBookPage()){
                            if(b1.getBookPrice() < b2.getBookPrice()){
                                return -1;
                            }
                            else if(b1.getBookPrice() == b2.bookPrice){
                                if(b1.getRemark().compareTo(b2.getRemark()) > 0){
                                    return -1;
                                }
                            }
                        }
                    }
                }
                return 1;
            }
        });

        System.out.println("-----------------------------图书馆书籍信息-----------------------------");
        for(int i = 0; i < libraryBook.size(); i++) {
            if(i == 0)System.out.println(label.get(0));
            else if(!libraryBook.get(i).getLabel().equals(libraryBook.get(i-1).getLabel()))
            System.out.println("在库书籍 "+(i+1)+" : ");
            System.out.println("书籍名称："+libraryBook.get(i).getBookName());
            System.out.println("书籍页数："+libraryBook.get(i).getBookPage());
            System.out.println("书籍价格："+libraryBook.get(i).getBookPrice());
            System.out.println("书籍备注："+libraryBook.get(i).getRemark());
            System.out.println("\n");
        }
        System.out.println("在库书籍总数："+libraryBook.size());
        System.out.println("--------------------------------------------------------------------------");
    }

}
