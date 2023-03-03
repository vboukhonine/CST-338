import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
public class LibraryTest {
    Library csumb;
    LocalDate date1 = LocalDate.parse("1990-05-01");
    Book book = new Book("1287247719", "Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch", "Fantasy", 491, "Terry Pratchett, Neil Gaiman", date1);
    Book bestServedCold = new Book("12345","Best Served Cold","GrimDark",235,"Joe Abercrombie",LocalDate.now());
    @Before
    public void setup(){
        csumb = new Library("CSUMB");
        csumb.init("/Users/vera/IdeaProjects/Project 01/src/Library00.csv");
        System.out.println("-------------------------------------------------------");
    }
    @Test
    public void initTest(){
        assertEquals(Code.SUCCESS, csumb.init("/Users/vera/IdeaProjects/Project 01/src/Library00.csv"));
    }
    @Test
    public void addBookTest(){
        csumb.addShelf("Fantasy");
        csumb.listShelves(true);
        csumb.addBook(book);
        assertEquals(Code.SUCCESS,csumb.addBook(book));
        csumb.listBooks();
    }
    @Test
    public void returnBookTest1(){
        Reader drew = csumb.getReaderByCard(1);
        csumb.listShelves(true);
        System.out.println("-------------------------------------------------------");
        assertEquals(Code.SUCCESS,csumb.returnBook(drew,csumb.getBookByISBN("42-w-87")));
        System.out.println("-------------------------------------------------------");
        csumb.listShelves(true);
    }
    @Test
    public void returnBookTest2(){
        assertEquals(Code.SUCCESS,csumb.returnBook(csumb.getBookByISBN("42-w-87")));
    }
    @Test
    public void listBooksTest(){
        assertEquals(9, csumb.listBooks());
        csumb.addBook(book);
        assertNotEquals(9,csumb.listBooks());
    }
    @Test
    public void checkOutBookTest(){
        Reader drew = csumb.getReaderByCard(1);
        csumb.addShelf("GrimDark");
        csumb.addBook(bestServedCold);
        System.out.println(drew);
        assertEquals(Code.SUCCESS,csumb.checkOutBook(drew,bestServedCold));
        System.out.println(drew);
    }
    @Test
    public void getBookByISBNTest(){
        csumb.addShelf("Fantasy");
        csumb.listShelves(true);
        csumb.addBook(book);
        assertEquals(book,csumb.getBookByISBN("1287247719"));
    }
    @Test
    public void listShelvesTest(){
        assertEquals(Code.SUCCESS,csumb.listShelves(true));
    }
    @Test
    public void addShelfTest1(){
        csumb.listShelves(true);
        assertEquals(Code.SUCCESS,csumb.addShelf("Fantasy"));
        csumb.addBook(book);
        csumb.listShelves(true);
    }
    @Test
    public void addShelfTest2(){
        Shelf shelf = new Shelf(1,"Fantasy");
        csumb.listShelves(true);
        assertEquals(Code.SUCCESS,csumb.addShelf(shelf));
        csumb.addBook(book);
        csumb.listShelves(true);
    }
    @Test
    public void getShelfTest1(){
        assertEquals(csumb.getShelf("sci-fi"),csumb.getShelf(1));
    }
    @Test
    public void getShelfTest2(){
        assertEquals(csumb.getShelf(1),csumb.getShelf("sci-fi"));
    }
    @Test
    public void listReaderTest(){
        assertEquals(csumb.listReaders(),csumb.listReaders(true));
    }
    @Test
    public void getReaderByCardTest(){
        Reader drew = csumb.getReaderByCard(1);
        assertEquals(drew,csumb.getReaderByCard(1));
    }
    @Test
    public void addReaderTest(){
        Reader vera = new Reader(5,"Vera","173-564-1424");
        csumb.listReaders(true);
        System.out.println("-------------------------------------------------------");
        assertEquals(Code.SUCCESS,csumb.addReader(vera));
        System.out.println("-------------------------------------------------------");
        csumb.listReaders(true);
    }
    @Test
    public void removeReaderTest(){
        Reader vera = new Reader(csumb.getLibraryCardNumber(),"Vera","173-564-1424");
        csumb.addReader(vera);
        Shelf shelf = new Shelf(1,"Fantasy");
        csumb.addShelf(shelf);
        csumb.addBook(book);
        csumb.checkOutBook(vera,book);
        csumb.listReaders(true);
        assertNotEquals(Code.SUCCESS,csumb.removeReader(vera));
        csumb.returnBook(vera,book);
        assertEquals(Code.SUCCESS,csumb.removeReader(vera));
    }
    @Test
    public void convertIntTest(){
        String test = "5";
        assertEquals(5,csumb.convertInt(test,Code.SUCCESS));
    }
    @Test
    public void convertDateTest(){
        String test = "1929-10-28";
        LocalDate dateTest = LocalDate.parse(test);
        csumb.convertDate(test,Code.SUCCESS);
        assertEquals(dateTest,csumb.convertDate(test,Code.SUCCESS));
    }
    @Test
    public void getLibraryCardNumberTest(){
        csumb.getLibraryCardNumber();
        assertEquals(5,csumb.getLibraryCardNumber());
    }
    @After
    public void tearDown(){
        csumb = null;
    }
}
