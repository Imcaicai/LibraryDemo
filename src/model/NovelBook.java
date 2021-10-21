package model;


public class NovelBook extends Book{
    protected String author;
    protected String leadingMan;
    protected String leadingWoman;
    public NovelBook(String bookName, int bookPage, float bookPrice, String remark, String label,boolean isBorrow,String author,String leadingMan,String leadingWoman) {
        super(bookName, bookPage, bookPrice, remark, label,isBorrow);
        NovelBook.this.author = author;
        NovelBook.this.leadingMan = leadingMan;
        NovelBook.this.leadingWoman = leadingWoman;
    }

    public String getAuthor(){
        return NovelBook.this.author;
    }

    public String getLeadingMan(){
        return NovelBook.this.leadingMan;
    }

    public String getLeadingWoman(){
        return NovelBook.this.leadingWoman;
    }
}