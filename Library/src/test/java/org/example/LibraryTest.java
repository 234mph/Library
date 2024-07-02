package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
        library.addBook(new Book("Book1", "Author1", 2000, "ISBN1"));
        library.addBook(new Book("Book2", "Author2", 2010, "ISBN2"));
        library.addBook(new Book("Book3", "Author3", 2020, "ISBN3"));
    }

    @Test
    void testAddBook() {
        int initialSize = library.getBooks().size();
        library.addBook(new Book("Book4", "Author4", 2024, "ISBN4"));
        assertEquals(initialSize + 1, library.getBooks().size());
    }

    @Test
    void testRemoveBook() {
        int initialSize = library.getBooks().size();
        Book bookToRemove = library.searchBooksByTitle("Book1").get(0);
        library.removeBook(bookToRemove);
        assertEquals(initialSize - 1, library.getBooks().size());
    }

    @Test
    void testSearchBooksByTitle() {
        assertEquals(1, library.searchBooksByTitle("Book1").size());
        assertEquals(0, library.searchBooksByTitle("Book5").size());
    }

    @Test
    void testSearchBooksByAuthor() {
        assertEquals(1, library.searchBooksByAuthor("Author2").size());
        assertEquals(0, library.searchBooksByAuthor("Author5").size());
    }

    @Test
    void testSearchBooksByYear() {
        assertEquals(1, library.searchBooksByYear(2020).size());
        assertEquals(0, library.searchBooksByYear(2025).size());
    }
}
