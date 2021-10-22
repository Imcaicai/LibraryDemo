package model;

public class Book {
    public String bookName;
    public String author;
    public int bookPage;
    public float bookPrice;
    public String remark;
    public String label;
    public boolean isBorrow = false;

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public int getBookPage() {
        return bookPage;
    }
    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }

    public float getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public boolean getIsBorrow() {
        return isBorrow;
    }
    public void setIsBorrow(boolean borrow) {
        isBorrow = borrow;
    }


}
