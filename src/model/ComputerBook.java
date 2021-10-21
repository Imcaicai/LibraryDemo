package model;

public class ComputerBook extends Book{
    protected String author;
    protected String theme;
    public ComputerBook(String bookName, int bookPage, float bookPrice, String remark, String label, boolean isBorrow, String author, String theme) {
        super(bookName, bookPage, bookPrice, remark, label, isBorrow);
        ComputerBook.this.author = author;
        ComputerBook.this.theme = theme;
    }

    public String getAuthor(){
        return ComputerBook.this.author;
    }

    public String getTheme(){
        return ComputerBook.this.theme;
    }
}