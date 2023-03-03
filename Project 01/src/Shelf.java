import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
/*


Title: Shelf.java
Abstract: Creates Shelfs to store books on a shelf is identified by its number and subject
Shelf allows you to add book to your shelf and remove books from your shelf. Books are contained in hashmap which keeps
track of the book info and how many of a single type of book is stored on a shelf.
Author: Vera Boukhonine
Date: 03/06/2022

added to shelf {Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch by Terry Pratchett, Neil Gaiman ISBN: 1287247719=1}
added to shelf {Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch by Terry Pratchett, Neil Gaiman ISBN: 1287247719=1, Ship of Magic by Robin Hobb ISBN: 9780006498858=1}
added to shelf {Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch by Terry Pratchett, Neil Gaiman ISBN: 1287247719=1, Ship of Magic by Robin Hobb ISBN: 9780006498858=2}
added to shelf {Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch by Terry Pratchett, Neil Gaiman ISBN: 1287247719=2, Ship of Magic by Robin Hobb ISBN: 9780006498858=2}
added to shelf {Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch by Terry Pratchett, Neil Gaiman ISBN: 1287247719=3, Ship of Magic by Robin Hobb ISBN: 9780006498858=2}
2
Ship of Magic successfully removed from shelf Fantasy
Ship of Magic successfully removed from shelf Fantasy
3 books on shelf 1: Fantasy
Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch by Terry Pratchett, Neil Gaiman ISBN: 1287247719 Number of Books: 3
Ship of Magic by Robin Hobb ISBN: 9780006498858 Number of Books: 0


* */
public class Shelf {
    public static final int SHELF_NUMBER = 0;
    public static final int SUBJECT_ = 1;
    private int shelfNumber;
    private String subject;
    private HashMap<Book, Integer> books;

    Shelf(int shelfNumber, String subject) {
        this.shelfNumber = shelfNumber;
        this.subject = subject;
        this.books = new HashMap<>();
    }

    Code addBook(Book book) {

        int count = 0;
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
            System.out.println("added to shelf " + book);
            return Code.SUCCESS;
        }
        if (!books.containsKey(book) && book.getSubject().equals(subject)) {
            count = 1;
            books.put(book, count);
            System.out.println("added to shelf " + book);
            return Code.SUCCESS;
        }
        if (!books.containsKey(book) && book.getSubject() != subject) {
            return Code.SHELF_SUBJECT_MISMATCH_ERROR;
        }
        return Code.UNKNOWN_ERROR;
    }

    Code removeBook(Book book) {
        if (!books.containsKey(book)) {
            System.out.println(book + " is not on shelf " + book.getSubject());
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else if (books.containsKey(book) && getBookCount(book) == 0) {
            System.out.println("No copies of " + book.getTitle() + " remain on shelf " + getSubject());
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else if (books.containsKey(book) && getBookCount(book) > 0) {
            System.out.println(book.getTitle() + " successfully removed from shelf " + getSubject());
            books.put(book, books.get(book) - 1);
            return Code.SUCCESS;
        }
        return Code.UNKNOWN_ERROR;
    }

    String listBooks() {
//        System.out.println( books.size()+ " books on shelf "+getShelfNumber() +": "+ getSubject());
        String myString = "";
        String temp = "";
        int count = 0;
        for (Book key : books.keySet()) {
            count += books.get(key);
            myString += String.valueOf(key) + " Number of Books: " + books.get(key) + "\n";
        }
        if(count>1 ||count == 0){
            temp = " books on shelf ";
        }
        if(count == 1){
            temp  = " book on shelf ";
        }
        return count + temp + getShelfNumber() + ": " + getSubject() + "\n" + myString;
    }

    int getBookCount(Book book) {
        if (books.containsKey(book))
            return books.get(book);
        return -1;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return SHELF_NUMBER == shelf.SHELF_NUMBER && SUBJECT_ == shelf.SUBJECT_ && shelfNumber == shelf.shelfNumber && Objects.equals(subject, shelf.subject) && Objects.equals(books, shelf.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SHELF_NUMBER, SUBJECT_, shelfNumber, subject, books);
    }

    @Override
    public String toString() {
        return getShelfNumber() + ": " + getSubject();
    }
}
