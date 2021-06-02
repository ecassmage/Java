public class Book {
    private String Name;
    private String Author;
    private int YearOfPublication;
    private int NumberOfPages;
    private double NumberOfPagess;
    public static void main(String[] args){

    }

    public Book(String name){
        this.Name = name;
    }
    public Book(String name, String author){
        this.Name = name;
        this.Author = author;
        System.out.println(NumberOfPagess);
    }

    public void setName(String newName){
        Name = newName;
    }
    public void setAuthor(String newAuthor){
        Author = newAuthor;
    }
    public void setYearOfPublication(int year){
        YearOfPublication = year;
    }
    public void setNumberOfPages(int pages){
        NumberOfPages = pages;
    }

    public String getName(){
        return Name;
    }
    public String getAuthor(){
        return Author;
    }
    public int getYearOfPublication(){
        return YearOfPublication;
    }
    public int getNumberOfPages(){
        return NumberOfPages;
    }
}
