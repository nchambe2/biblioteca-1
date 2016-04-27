import com.thoughtworks.tw101.biblioteca.Biblioteca;
import com.thoughtworks.tw101.biblioteca.Book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Ender", "Orson", "1990"));
        bookList.add(new Book("The Jungle Book", "Some Person", "1967"));
        Biblioteca biblioteca = new Biblioteca(System.out, bookList);
        biblioteca.start();
    }
}
