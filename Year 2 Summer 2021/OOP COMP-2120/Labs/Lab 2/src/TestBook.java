public class TestBook {
    // Testoritoes is a better name

    public static void main(String[] args){
        Book Book1 = new Book("Book of Lies", "Evan Morrison");
        Book Book2 = new Book("Book inside BlackHoles");
        setBook(Book1);
        System.out.println();
        setBook(Book2);
    }
    public static void setBook(Book book){
        getAllInfo(book);
        book.setNumberOfPages(500);
        getAllInfo(book);
        book.setYearOfPublication(2001);
        getAllInfo(book);
        book.setYearOfPublication(2002);
        getAllInfo(book);
        book.setName("New Book Title");
        getAllInfo(book);
        book.setAuthor("Evan Morrison");
        getAllInfo(book);
        book.setAuthor("Evan The Not Morrison");
        getAllInfo(book);
    }
    public static void getAllInfo(Book book){
        System.out.println("Name: " + book.getName() + ", Author: " + book.getAuthor() + ", Year of Publication: " + book.getYearOfPublication() + ", Number of Pages: " + book.getNumberOfPages());
    }
}
