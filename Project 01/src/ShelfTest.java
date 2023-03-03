import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;

import static org.junit.Assert.*;
/*
Title: ShelfTest.java
Abstract: This file contains all the Junit testing for Shelf.java
It tests all setters/getters and functions unique to Shelf.
Author: Vera Boukhonine
Date: 03/06/2022
* */
public class ShelfTest {
    Shelf shelfTester;
    int shelfNumberTest = 1;
    String subjectTest = "Fantasy";
    LocalDate date1 = LocalDate.parse("1990-05-01");
    LocalDate date2 = LocalDate.parse("2002-01-01");
    LocalDate date3 = LocalDate.parse("2006-07-17");
    Book book = new Book("1287247719", "Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch", "Fantasy", 491, "Terry Pratchett, Neil Gaiman", date1);
    Book book1 = new Book("9780609608449", "The Devil in the White City: Murder, Magic, and Madness at the Fair That Changed America", "History", 447, "Erik Larson", date2);
    Book book2 = new Book("9780006498858", "Ship of Magic", "Fantasy", 880, "Robin Hobb", date3);
    HashMap<Book, Integer> bookTest;
    @Before
    public void setup() {
        System.out.println("Processing Setup");
        shelfTester = new Shelf(shelfNumberTest, subjectTest);
        bookTest = new HashMap<>();
    }

    @Test
    public void constructorTest() {
        Shelf constructorTest = null;
        assertNull(constructorTest);
        constructorTest = new Shelf(2, "Thriller");
        assertNotNull(constructorTest);
    }

    @Test
    public void addBookTest() {
        assertEquals(Code.SUCCESS, shelfTester.addBook(book));
        System.out.println(shelfTester.getBookCount(book));
        shelfTester.getBookCount(book);
        assertEquals(Code.SUCCESS, shelfTester.addBook(book));
        System.out.println(shelfTester.getBookCount(book));
        shelfTester.getBookCount(book);
        assertEquals(Code.SHELF_SUBJECT_MISMATCH_ERROR, shelfTester.addBook(book1));
        shelfTester.getBookCount(book1);
        System.out.println(shelfTester.getBookCount(book1));
    }

    @Test
    public void removeBookTest() {
        assertEquals(Code.BOOK_NOT_IN_INVENTORY_ERROR, shelfTester.removeBook(book));
        shelfTester.addBook(book);
        shelfTester.addBook(book);
        shelfTester.addBook(book);
        assertEquals(Code.SUCCESS, shelfTester.addBook(book2));
        System.out.println(shelfTester.listBooks());
        System.out.println(shelfTester.getBookCount(book));
        shelfTester.getBookCount(book);
        int count = shelfTester.getBookCount(book);

        for (int i = 0; i < count; i++) {
            assertEquals(Code.SUCCESS, shelfTester.removeBook(book));
        }
        System.out.println(shelfTester.listBooks());
        shelfTester.getBookCount(book);
    }

    @Test
    public void getBookCountTest() {
//        HashMap<Book, Integer> bookTest = new HashMap<>();
        Random random = new Random();
        int upperBound = 100;
        int count = random.nextInt(upperBound);
        bookTest.put(book, count);
        shelfTester.setBooks(bookTest);
        System.out.println(shelfTester.getBookCount(book));
        shelfTester.getBookCount(book);
        System.out.println(shelfTester.listBooks());
        assertEquals(count, shelfTester.getBookCount(book));
        shelfTester.removeBook(book);
        assertNotEquals(count, shelfTester.getBookCount(book));
        count--;
        for(int i = 0; i<count;i++){
            shelfTester.removeBook(book);
        }
        shelfTester.getBookCount(book);
        shelfTester.getBookCount(book1);
        System.out.println(shelfTester.getBookCount(book));
        System.out.println(shelfTester.getBookCount(book1));
    }

    @Test
    public void listBooksTest() {
        shelfTester.addBook(book);
        String testString = "1 books on shelf 1: Fantasy\n" +
                "Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch by Terry Pratchett, Neil Gaiman ISBN: 1287247719 Number of Books: 1\n";
        assertEquals(testString,shelfTester.listBooks());
        System.out.println(shelfTester.listBooks());
    }

    @Test
    public void setBooksTest() {
        shelfTester.addBook(book);
        bookTest.put(book,1);
        assertEquals(bookTest,shelfTester.getBooks());
        bookTest.put(book1,1);
        bookTest.remove(book);
        shelfTester.setBooks(bookTest);
        assertEquals(bookTest,shelfTester.getBooks());
    }

    @Test
    public void getBooksTest() {
        shelfTester.addBook(book);
        bookTest.put(book,1);
        assertEquals(bookTest,shelfTester.getBooks());
    }

    @Test
    public void setSubjectTest() {
        assertEquals(subjectTest,shelfTester.getSubject());
        shelfTester.setSubject("Apocalypse");
        assertNotEquals(subjectTest, shelfTester.getSubject());
    }
    @Test
    public void getShelfNumberTest(){
        assertEquals(shelfNumberTest,shelfTester.getShelfNumber());
    }
    @Test
    public void setShelfNumberTest(){
        assertEquals(shelfNumberTest,shelfTester.getShelfNumber());
        shelfTester.setShelfNumber(2);
        assertNotEquals(shelfNumberTest,shelfTester.getShelfNumber());
    }
    @Test
    public void getSubjectTest() {
        assertEquals(subjectTest,shelfTester.getSubject());
    }

    @Test
    public void testHashcode() {
        shelfTester.hashCode();
        assertEquals(919152154,shelfTester.hashCode());
//        System.out.println(shelfTester.hashCode());
    }

    @Test
    public void testEquals() {
        shelfTester.equals(shelfTester);
        assertTrue(shelfTester.equals(shelfTester));
    }
    @Test
    public void toStringTest(){
        String temp = "1: Fantasy";
        assertEquals(temp, shelfTester.toString());
//        System.out.println(shelfTester);
    }

    @After
    public void tearDown() {
        shelfTester = null;
    }
}
