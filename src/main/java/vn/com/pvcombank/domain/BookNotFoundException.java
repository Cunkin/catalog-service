package vn.com.pvcombank.domain;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String isbn) {
        super("The book with " + isbn + " was not found");
    }
}
