public class Book {
    int    Id;
    String Title, Author, Genre;

    public static void main(String[] args){
        Book book = new Book(123, "Moves", "Evan", "Strategy");
        System.out.println(book.Id());
    }
    public Book(int id, String title, String author, String genre){
        this.Id = id;
        this.Title = title;
        this.Author = author;
        this.Genre = genre;
    }
    public int Id(){
        return this.Id;
    }
    public String Title(){
        return this.Title;
    }
    public String Author(){
        return this.Author;
    }
    public String Genre(){
        return this.Genre;
    }
    public void changeId(int newId){
        this.Id = newId;
    }
    public void changeTitle(String newTitle){
        this.Title = newTitle;
    }
    public void changeAuthor(String newAuthor){
        this.Author = newAuthor;
    }
    public void changeGenre(String newGenre){
        this.Genre = newGenre;
    }
}
