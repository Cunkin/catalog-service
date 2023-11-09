package vn.com.pvcombank.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book) {

        if (bookRepository.existsByIsbn(book.isbn()))
            throw new BookAlreadyExistsException(book.isbn());

        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBookDetails(String isbn, Book book) {
        return bookRepository.findByIsbn(isbn)
                .map(existsBook -> {
                    Book bookUpdated = new Book(existsBook.id(), existsBook.isbn(), book.title(), book.author(), book.price(), book.publisher(), existsBook.createdDate(), existsBook.lastModifiedDate(), existsBook.version());
                    return bookRepository.save(bookUpdated);
                })
                .orElseGet(() -> addBookToCatalog(book));
    }
}
