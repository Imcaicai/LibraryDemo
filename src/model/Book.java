package model;

public class Book {
    public String bookName;
    public int bookPage;
    public float bookPrice;
    public String remark;
    public String label;
    public boolean isBorrow;

    public Book(String bookName,int bookPage,float bookPrice,String remark,String label,boolean isBorrow){
        Book.this.bookName = bookName;
        Book.this.bookPage = bookPage;
        Book.this.bookPrice = bookPrice;
        Book.this.remark = remark;
        Book.this.label = label;
        Book.this.isBorrow = isBorrow;
    }

    public String getBookName(){
        return Book.this.bookName;
    }
    public void setBookName(String bookName){
        Book.this.bookName = bookName;
    }

    public int getBookPage(){
        return Book.this.bookPage;
    }
    public void setBookPage(int bookPage){
        Book.this.bookPage = bookPage;
    }

    public float getBookPrice(){
        return Book.this.bookPrice;
    }
    public void setBookPrice(float bookPrice){
        Book.this.bookPrice = bookPrice;
    }

    public String getRemark(){
        return Book.this.remark;
    }
    public void setRemark(String remark){
        Book.this.remark = remark;
    }

    public String getLabel(){
        return Book.this.label;
    }
    public void setLabel(String label){
        Book.this.label = label;
    }

    public boolean getIsBorrow(){
        return Book.this.isBorrow;
    }
    public void setIsBorrow(boolean isBorrow){
        Book.this.isBorrow = isBorrow;
    }
}
