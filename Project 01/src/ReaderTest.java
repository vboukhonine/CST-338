/*
 * Author: Vera Boukhonine
 * Date: Feb 13th, 2022
 * Description: This is an assignment to test and create a Reader
 * class which uses the Book class in part one of the assignment.
 *
 * */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import static org.junit.Assert.*;

public class ReaderTest {

    int cardNumberTest = 3624575;
    String nameTest = "Penelope Nemo";
    String phoneTest = "(408) 819-7693";

    //----------------------------------------------------------------------------

    Reader readerTest;
    String isbnTester = "9780062934918";
    String titleTester = "Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch";
    String subjectTester = "Fiction";
    int pageCountTester = 491;
    String authorTester = "Terry Pratchett, Neil Gaiman";
    LocalDate dateTest = LocalDate.parse("1990-05-01");

    Book nBook =  new Book(isbnTester,titleTester,subjectTester,pageCountTester,authorTester,dateTest);

    //----------------------------------------------------------------------------
    @Before
    public void setup(){
        System.out.println("Processing Setup");
        readerTest = new Reader(cardNumberTest,nameTest,phoneTest);

    }
    @After
    public void tearDown(){
        readerTest = null;
    }

    //----------------------------------------------------------------------------
    @Test
    public void addBook_Test(){
//        System.out.println(readerTest.toString());
        assertEquals(readerTest.addBook(nBook),Code.SUCCESS);
//        System.out.println(readerTest.toString());
        assertNotEquals(readerTest.addBook(nBook),Code.SUCCESS);
//        System.out.println(readerTest.toString());
        assertEquals(readerTest.addBook(nBook),Code.BOOK_ALREADY_CHECKED_OUT_ERROR);
    }

    @Test
    public void getBookCount_Test(){
        assertEquals(0,readerTest.getBookCount());
//        System.out.println(readerTest.getBookCount());
        readerTest.addBook(nBook);
        assertEquals(1,readerTest.getBookCount());
//        System.out.println(readerTest.getBookCount());
        readerTest.removeBook(nBook);
        assertEquals(0,readerTest.getBookCount());
//        System.out.println(readerTest.getBookCount());
    }

    @Test
    public void hasBook_Test(){
        assertFalse(readerTest.hasBook(nBook));
//        System.out.println(readerTest.hasBook(nBook));
        readerTest.addBook(nBook);
        assertTrue(readerTest.hasBook(nBook));
//        System.out.println(readerTest.hasBook(nBook));
    }

    @Test
    public void removeBook_Test(){
//        System.out.println(readerTest.removeBook(nBook));
        assertEquals(readerTest.removeBook(nBook),Code.READER_DOESNT_HAVE_BOOK_ERROR);
        readerTest.addBook(nBook);
        assertEquals(readerTest.removeBook(nBook),Code.SUCCESS);
    }


//    public static void main(String[] args) {
//        int cardNumberTest = 3624575;
//        String nameTest = "Penelope Nemo";
//        String phoneTest = "(408) 819-7693";
//
//        String isbnTester = "9780062934918";
//        String titleTester = "Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch";
//        String subjectTester = "Fiction";
//        int pageCountTester = 491;
//        String authorTester = "Terry Pratchett, Neil Gaiman";
//        LocalDate dateTest = LocalDate.parse("1990-05-01");
//
//        Book nBook =  new Book(isbnTester,titleTester,subjectTester,pageCountTester,authorTester,dateTest);
//
//
//
////        Reader readFile = null;
////        List<Book> books = readFile.readBooksFromCSV();
////        for (Book b : books) {
////            System.out.println(b);
////        }
//        Reader read = new Reader(cardNumberTest,nameTest,phoneTest);
//        read.addBook(nBook);
//        System.out.println(read.toString());
//
//        System.out.println(read.hasBook(nBook));
//        System.out.println(read.removeBook(nBook));
//        System.out.println(read.toString());
//    }
}
