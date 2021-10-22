package model;

public class ComputerBook extends Book{
    public String theme;

    public ComputerBook() {
        super();
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

}