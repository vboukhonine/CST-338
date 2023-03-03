
import java.time.LocalDate;


public class Util {
    public static void main(String[] args) {
        Library csumb = new Library("CSUMB");
        csumb.init("/Users/vera/IdeaProjects/Project 01/src/Library00.csv");

        System.out.println("\n--------------------------------------------------------");
        csumb.listBooks();
        System.out.println("\n");
        csumb.getBookByISBN("42-w-87");
        int numb = csumb.listBooks();
        System.out.println("total books: " + numb);
        System.out.println("");
        numb = csumb.listReaders();
        String userInput = "f";

        System.out.println("total readers: " + numb );
        csumb.listShelves(true);

        Book bestServedCold = new Book("12345","Best Served Cold","GrimDark",235,"Joe Abercrombie",LocalDate.now());
        Shelf scifi = csumb.getShelf(" sci-fi");
        Shelf adventure = csumb.getShelf(" Adventure");
        Shelf romance = csumb.getShelf(4);
        romance = csumb.getShelf("Romance");
        System.out.println(romance);
        csumb.addShelf("Romance");
        romance = csumb.getShelf("Romance");
        System.out.println(romance);
        scifi.addBook(bestServedCold);
        adventure.addBook(bestServedCold);
        csumb.addBook(bestServedCold);
        csumb.addShelf("GrimDark");
        System.out.println("Done");
        csumb.listReaders(true);
        csumb.listShelves(true);
        Reader drew = csumb.getReaderByCard(1);

        csumb.checkOutBook(drew,bestServedCold);
        csumb.listReaders(true);
        csumb.returnBook(drew,csumb.getBookByISBN("42-w-87"));
        csumb.returnBook(drew,csumb.getBookByISBN("42-w-87"));

        Reader vera = new Reader(5,"Vera","173-564-1424");
        csumb.listReaders();
//        System.out.println();
//        csumb.listBooks();
//        int count = drew.getBookCount();
//        for(int i=0;i<count-1;i++){
//            drew.removeBook(drew.getBooks().get(i));
//        }
//        drew.removeBook(drew.getBooks().get(0));
//        csumb.removeReader(drew);
//        System.out.println();
//        csumb.listReaders();

//        System.out.println(drew);
    }
}
