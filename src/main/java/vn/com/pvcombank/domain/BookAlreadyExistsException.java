package vn.com.pvcombank.domain;

public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException(String isbn) {
        super("The book with " + isbn + " already exists");
    }
}
