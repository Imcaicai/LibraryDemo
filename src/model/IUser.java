package model;

public interface IUser {
    public abstract void borrowBook(String bookName,int bookPage,float bookPrice,String remark,String label);
    public abstract void returnBook(String bookName,int bookPage,float bookPrice,String remark,String label);
}
