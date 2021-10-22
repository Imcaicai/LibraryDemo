package model;

public class ComicBook extends Book{
    protected String author;
    protected String publisher;
    public ComicBook() {
        super();
    }


    public String getPublisher(){
        return ComicBook.this.publisher;
    }
    public void setPublisher(String publisher){
        ComicBook.this.publisher = publisher;
    }
}
