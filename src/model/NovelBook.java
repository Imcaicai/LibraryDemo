package model;


public class NovelBook extends Book{
    protected String leadingMan;
    protected String leadingWoman;

    public NovelBook() {
        super();
    }

    public String getLeadingMan() {
        return leadingMan;
    }
    public void setLeadingMan(String leadingMan) {
        this.leadingMan = leadingMan;
    }

    public String getLeadingWoman() {
        return leadingWoman;
    }
    public void setLeadingWoman(String leadingWoman) {
        this.leadingWoman = leadingWoman;
    }
}