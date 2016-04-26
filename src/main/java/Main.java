import com.thoughtworks.tw101.biblioteca.Application;

public class Main {
    public static void main(String[] args) {
        Application applicationX = new Application(System.out);
        applicationX.addBook("Pride and Prejudice");
        applicationX.addBook("Head Start Java");
        applicationX.start();
    }
}
