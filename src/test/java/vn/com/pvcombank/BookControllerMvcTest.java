package vn.com.pvcombank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import vn.com.pvcombank.domain.BookNotFoundException;
import vn.com.pvcombank.domain.BookService;
import vn.com.pvcombank.web.BookController;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
class BookControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void whenGetBookNoExistingThenShouldReturn404() throws Exception{

        String isbn = "1111111111111111";
        given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);

        mockMvc.perform(get("/books/" + isbn)).andExpect(status().isNotFound());
    }
}
