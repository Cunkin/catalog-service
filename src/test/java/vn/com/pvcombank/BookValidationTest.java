package vn.com.pvcombank;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import vn.com.pvcombank.domain.Book;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BookValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSuccess() {

        Book book = new Book("1234567890", "title", "author", 10.0);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assert(violations.isEmpty());
    }

    @Test
    void whenIsbnDefinedButIncorrectThenValidationFailure() {

        Book book = new Book("abcd", "title", "author", 10.0);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("The ISBN format must be valid.");
    }
}
