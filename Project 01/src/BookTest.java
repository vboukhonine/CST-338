/*
 * Author: Vera Boukhonine
 * Date: Feb 13th, 2022
 * Description: This is an assignment to test and
 *  create a Book class which is used to create book objects.
 * The BookTest class tests the contructors, getters, and setters of this class.
 * */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.AfterEach; // caused the bug kept giving me nullptr's
//import org.junit.jupiter.api.BeforeEach;  // caused the bug kept giving me nullptr's
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    String isbnTest = "9780765311788";
    String titleTest = "Mistborn: The Final Empire";
    String subjectTest = "Fantasy";
    int pageCountTest = 541;
    String authorTest = "Brandon Sanderson";
    LocalDate date1 = LocalDate.parse("2006-07-17");
    Book bookTester;


    @Before
    public void setup() {
        System.out.println("Processing Setup");
        bookTester = new Book(isbnTest, titleTest, subjectTest, pageCountTest, authorTest, date1);

    }

    // Constructor test
    @Test
    public void constructorTest() {
        Book constructorTest = null;
        assertNull(constructorTest);
        constructorTest = new Book(isbnTest, titleTest, subjectTest, pageCountTest, authorTest, date1);
        assertNotNull(constructorTest);
    }

    // Getter tests
    @Test
    public void getISBNTest() {
        assertEquals(isbnTest, bookTester.getIsbn());
//        System.out.println(bookTester.getIsbn());
    }

    @Test
    public void getTitleTest() {
        assertEquals(titleTest, bookTester.getTitle());
    }

    @Test
    public void getSubjectTest() {
        assertEquals(subjectTest, bookTester.getSubject());
    }

    @Test
    public void getPageCountTest() {
        assertEquals(pageCountTest, bookTester.getPageCount());
    }

    @Test
    public void getAuthorTest() {
        assertEquals(authorTest, bookTester.getAuthor());
    }

    @Test
    public void getDueDateTest() {
        assertEquals(date1, bookTester.getDueDate());
    }

    // Setter tests
    @Test
    public void setISBNTest() {
        assertEquals(isbnTest, bookTester.getIsbn());
        bookTester.setIsbn("9780044403371");
        assertNotEquals(isbnTest, bookTester.getIsbn());
    }

    @Test
    public void setTitleTest() {
        assertEquals(titleTest, bookTester.getTitle());
        bookTester.setTitle("The Hobbit");
        assertNotEquals(titleTest, bookTester.getTitle());
    }

    @Test
    public void setSubjectTest() {
        assertEquals(subjectTest, bookTester.getSubject());
        bookTester.setSubject("Adventure");
        assertNotEquals(subjectTest, bookTester.getSubject());
    }

    @Test
    public void setPageCountTest() {
        assertEquals(pageCountTest, bookTester.getPageCount());
        bookTester.setPageCount(310);
        assertNotEquals(pageCountTest, bookTester.getPageCount());
    }

    @Test
    public void setAuthorTest() {
        assertEquals(authorTest, bookTester.getAuthor());
        bookTester.setAuthor("J.R.R.Tolkien");
        assertNotEquals(authorTest, bookTester.getAuthor());
    }

    @Test
    public void setDueDateTest() {
        assertEquals(date1, bookTester.getDueDate());
    }

    @Test
    public void checkEquals() {
        bookTester.equals(bookTester);
    }

    @Test
    public void testHashcode() {
        bookTester.hashCode();
    }

    @After
    public void tearDown() {
        bookTester = null;
    }
}
