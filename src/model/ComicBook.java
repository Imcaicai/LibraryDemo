package model;

public class ComicBook extends Book{
    protected String author;
    protected String publisher;
    public ComicBook(String bookName, int bookPage, float bookPrice, String remark, String label,boolean isBorrow,String author,String publisher) {
        super(bookName, bookPage, bookPrice, remark, label,isBorrow);
        ComicBook.this.author = author;
        ComicBook.this.publisher = publisher;
    }

    public String getAuthor(){
        return ComicBook.this.author;
    }
    public void setAuthor(String author){
        ComicBook.this.author = author;
    }

    public String getPublisher(){
        return ComicBook.this.publisher;
    }
    public void setPublisher(String publisher){
        ComicBook.this.publisher = publisher;
    }
}
