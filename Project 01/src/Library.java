import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;

/*
Title: Library.java
Abstract: In this class we created all the functionality necessary for a library, we build our library
by creating books and storing them in a hashmap. Then we create shelves and store them in another hashmap
after which we create our list of readers. We can check out books, look up books and shelves. List out what is contained
on the shelves and what books our readers have.
Author: Vera Boukhonine
Date: 03/27/2022
*
*
Sample output:
Headfirst Java added to the stacks.
No shelf for education books
No shelf for education books
Hitchhikers Guide To the Galaxy added to the stacks.
No shelf for sci-fi books
No shelf for sci-fi books
2 copies of Hitchhikers Guide To the Galaxy in the stacks
2 copies of Headfirst Java in the stacks
3 copies of Hitchhikers Guide To the Galaxy in the stacks
Count of Monte Cristo added to the stacks.
No shelf for Adventure books
No shelf for Adventure books
4 copies of Hitchhikers Guide To the Galaxy in the stacks
3 copies of Headfirst Java in the stacks
Dune added to the stacks.
No shelf for sci-fi books
No shelf for sci-fi books
added to shelf Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
added to shelf Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
added to shelf Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
added to shelf Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
added to shelf Dune by Frank Herbert ISBN: 34-w-34
added to shelf Headfirst Java by Grady Booch ISBN: 1337
added to shelf Headfirst Java by Grady Booch ISBN: 1337
added to shelf Headfirst Java by Grady Booch ISBN: 1337
added to shelf Count of Monte Cristo by Alexandre Dumas ISBN: 5297
Drew Clinkenbeard added to the library!
Headfirst Java by Grady Booch ISBN: 1337
Headfirst Java successfully removed from shelf education
Headfirst Java by Grady Booch ISBN: 1337 checked out successfully
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
Hitchhikers Guide To the Galaxy successfully removed from shelf sci-fi
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87 checked out successfully
Jennifer Clinkenbeard added to the library!
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
Hitchhikers Guide To the Galaxy successfully removed from shelf sci-fi
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87 checked out successfully
Monte Ray added to the library!
Headfirst Java by Grady Booch ISBN: 1337
Headfirst Java successfully removed from shelf education
Headfirst Java by Grady Booch ISBN: 1337 checked out successfully
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
Hitchhikers Guide To the Galaxy successfully removed from shelf sci-fi
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87 checked out successfully
Laurence Fishburn added to the library!
Headfirst Java by Grady Booch ISBN: 1337
Headfirst Java successfully removed from shelf education
Headfirst Java by Grady Booch ISBN: 1337 checked out successfully
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
Hitchhikers Guide To the Galaxy successfully removed from shelf sci-fi
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87 checked out successfully
3 copies of Headfirst Java by Grady Booch ISBN: 1337
1 copy of Count of Monte Cristo by Alexandre Dumas ISBN: 5297
4 copies of Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
1 copy of Dune by Frank Herbert ISBN: 34-w-34

--------------------------------------------------------
3 copies of Headfirst Java by Grady Booch ISBN: 1337
1 copy of Count of Monte Cristo by Alexandre Dumas ISBN: 5297
4 copies of Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
1 copy of Dune by Frank Herbert ISBN: 34-w-34


Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
3 copies of Headfirst Java by Grady Booch ISBN: 1337
1 copy of Count of Monte Cristo by Alexandre Dumas ISBN: 5297
4 copies of Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
1 copy of Dune by Frank Herbert ISBN: 34-w-34
total books: 9

Drew Clinkenbeard(1) has checked out [Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Jennifer Clinkenbeard(2) has checked out [Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Monte Ray(3) has checked out [Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Laurence Fishburn(4) has checked out [Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
total readers: 4
1 book on shelf 1: sci-fi
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87 Number of Books: 0
Dune by Frank Herbert ISBN: 34-w-34 Number of Books: 1

0 books on shelf 2: education
Headfirst Java by Grady Booch ISBN: 1337 Number of Books: 0

1 book on shelf 3: Adventure
Count of Monte Cristo by Alexandre Dumas ISBN: 5297 Number of Books: 1

No shelf number 4 found
No shelf for Romance books
null
4: Romance
Best Served Cold added to the stacks.
No shelf for GrimDark books
No shelf for GrimDark books
added to shelf Best Served Cold by Joe Abercrombie ISBN: 12345
Done
Drew Clinkenbeard(#1) has the following books:
[Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Jennifer Clinkenbeard(#2) has the following books:
[Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Monte Ray(#3) has the following books:
[Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Laurence Fishburn(#4) has the following books:
[Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
1 book on shelf 1: sci-fi
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87 Number of Books: 0
Dune by Frank Herbert ISBN: 34-w-34 Number of Books: 1

0 books on shelf 2: education
Headfirst Java by Grady Booch ISBN: 1337 Number of Books: 0

1 book on shelf 3: Adventure
Count of Monte Cristo by Alexandre Dumas ISBN: 5297 Number of Books: 1

0 books on shelf 4: Romance

1 book on shelf 5: GrimDark
Best Served Cold by Joe Abercrombie ISBN: 12345 Number of Books: 1

Best Served Cold successfully removed from shelf GrimDark
Best Served Cold by Joe Abercrombie ISBN: 12345 checked out successfully
Drew Clinkenbeard(#1) has the following books:
[Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87, Best Served Cold by Joe Abercrombie ISBN: 12345]
Jennifer Clinkenbeard(#2) has the following books:
[Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Monte Ray(#3) has the following books:
[Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Laurence Fishburn(#4) has the following books:
[Headfirst Java by Grady Booch ISBN: 1337, Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87]
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
Drew Clinkenbeard  is returning Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
added to shelf Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
Hitchhikers Guide To the Galaxy by Douglas Adams ISBN: 42-w-87
Drew Clinkenbeard doesn't have Hitchhikers Guide To the Galaxy checked out
* */
public class Library {
    public static int LENDING_LIMIT = 5;
    private String name;
    private static int libraryCard = 0;
    private HashMap<Book, Integer> books = new HashMap<>();
    private LinkedHashMap<String, Shelf> shelves = new LinkedHashMap<>();
    // I changed my map, so it will preserve the order in which shelves are added
    private List<Reader> readers = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public Code init(String filename) {
        String temp;
        Code code;
        int count;
        int num;
        try {
            Scanner scan = new Scanner(new FileReader(filename));
            //-------------------------------------------
            temp = scan.next();//9 number of books
            num = Integer.parseInt(temp);
            if (num <= 0) {
                code = Code.BOOK_COUNT_ERROR;
            } else {
                code = Code.SUCCESS;
            }
            count = convertInt(temp, code);
            initBooks(count, scan);
            //-------------------------------------------
            temp = scan.next();//3 number of shelves
            num = Integer.parseInt(temp);
            if (num <= 0) {
                code = Code.SHELF_COUNT_ERROR;
            } else {
                code = Code.SUCCESS;
            }
            count = convertInt(temp, code);
            initShelves(count, scan);
            //-------------------------------------------
            temp = scan.next();//4 number of readers
            num = Integer.parseInt(temp);
            if (num <= 0) {
                code = Code.READER_COUNT_ERROR;
            } else {
                code = Code.SUCCESS;
            }
            count = convertInt(temp, code);
            initReader(count, scan);
            scan.close();
            listBooks();
            return Code.SUCCESS;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Code.FILE_NOT_FOUND_ERROR;
        }
    }

    private Code initBooks(int bookCount, Scanner scan) {
        Code code;
        String line;
        Book book;
        if (bookCount < 1) {
            return Code.LIBRARY_ERROR;
        }
        int count = bookCount;
        while (count != -1) {
            line = scan.nextLine();
            if (!line.isEmpty()) {
                String[] bookData = line.split(",");
                String isbn = bookData[Book.ISBN_];
                String title = bookData[Book.TITLE_];
                String subject = bookData[Book.SUBJECT_];
                int pages = Integer.parseInt(bookData[Book.PAGE_COUNT_]);
                if (pages <= 0) {
                    code = Code.PAGE_COUNT_ERROR;
//                    return code;
                } else {
                    code = Code.SUCCESS;
                }
                int pageCount = convertInt(bookData[Book.PAGE_COUNT_], code);
                String author = bookData[Book.AUTHOR_];
                String myDate = bookData[Book.DUE_DATE];
                if (myDate.equals(null)) {
                    code = Code.DATE_CONVERSION_ERROR;
//                    return code;
                } else {
                    code = Code.SUCCESS;
                }
                LocalDate dueDate = convertDate(bookData[Book.DUE_DATE], code);
                book = new Book(isbn, title, subject, pageCount, author, dueDate);
                addBook(book);
            }
            count--;
        }
        return Code.SUCCESS;
    }

    private Code initShelves(int shelfCount, Scanner scan) {//ok
        String line;
        Shelf shelf;
        Code code;
        if (shelfCount < 1) {
            return Code.SHELF_COUNT_ERROR;
        }
        int count = shelfCount;
        while (count != -1) {
            line = scan.nextLine();
            if (!line.isEmpty()) {
                String[] shelfData = line.split(",");
                int shelfNum = Integer.parseInt(shelfData[Shelf.SHELF_NUMBER]);
                if (shelfNum <= 0) {
                    code = Code.SHELF_NUMBER_PARSE_ERROR;
                } else {
                    code = Code.SUCCESS;
                }
                int shelfNumber = convertInt(shelfData[Shelf.SHELF_NUMBER], code);
                String subject = shelfData[Shelf.SUBJECT_];
                shelf = new Shelf(shelfNumber, subject);
                addShelf(shelf);
            }
            count--;
        }

        return Code.SUCCESS;
    }

    private Code initReader(int readerCount, Scanner scan) {
        HashMap<String, LocalDate> bookMap = new HashMap<>();
        List<Book> readerBooks = new ArrayList<>();
        if (readerCount <= 0) {
            return Code.READER_COUNT_ERROR;
        }
        String line;
        Reader reader;
        int count = readerCount;
        while (count != -1) {
            readerBooks.clear();
            bookMap.clear();
            line = scan.nextLine();
            if (!line.isEmpty()) {
                String[] readerData = line.split(",");
                int cardNumber = Integer.parseInt(readerData[Reader.CARD_NUMBER_]);
                String name = readerData[Reader.NAME_];
                String phone = readerData[Reader.PHONE_];
                int bookCount = Integer.parseInt(readerData[Reader.BOOK_COUNT_]);
                int i = Reader.BOOK_START_;
                Book newBook;
                while (bookCount != 0) {
                    bookMap.put(readerData[i], convertDate(readerData[i + 1], Code.SUCCESS));
                    newBook = new Book(getBookByISBN(readerData[i]).getIsbn(), getBookByISBN(readerData[i]).getTitle(), getBookByISBN(readerData[i]).getSubject(), getBookByISBN(readerData[i]).getPageCount(), getBookByISBN(readerData[i]).getAuthor(), bookMap.get(readerData[i]));
                    readerBooks.add(newBook);
                    i += 2;
                    bookCount--;
                }

                reader = new Reader(cardNumber, name, phone);
                addReader(reader);
                for (String book : bookMap.keySet()) {
                    checkOutBook(reader, getBookByISBN(book));//my reader checks out their books
                }
                reader.setBooks(readerBooks);// I set the readers book with the new due dates
            }
            count--;
        }

        return Code.SUCCESS;
    }

    public Code addBook(Book newBook) {//TODO fix this
        int count = 0;
        if (books.containsKey(newBook)) {
            books.put(newBook, books.get(newBook) + 1);
            System.out.println(books.get(newBook) + " copies of " + newBook.getTitle() + " in the stacks");
            return Code.SUCCESS;
        } else if (!books.containsKey(newBook)) {
            count = 1;
            books.put(newBook, count);
            System.out.println(newBook.getTitle() + " added to the stacks.");
        }
        for (Shelf shelf : shelves.values()) {
            if (shelf.getSubject().equals(newBook.getSubject())) {
                System.out.println("Book added to shelf " + newBook.getSubject());
                shelf.addBook(newBook);
                return Code.SUCCESS;
            }
        }
        if (!shelves.containsValue(getShelf(newBook.getSubject()))) {
            System.out.println("No shelf for " + newBook.getSubject() + " books");
            return Code.SHELF_EXISTS_ERROR;
        }
        return Code.SUCCESS;
    }

    public Code returnBook(Reader reader, Book book) {
        List<Book> temp = new ArrayList<>();
        for (Book a : reader.getBooks()) {
            if(a.getIsbn().equals(book.getIsbn())){
                temp.add(getBookByISBN(a.getIsbn()));
            }
            if(!a.getIsbn().equals(book.getIsbn())){
                temp.add(a);
            }
        }
        reader.setBooks(temp);

        if (!reader.hasBook(book)) {
            System.out.println(reader.getName() + " doesn't have " + book.getTitle() + " checked out");
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        }
        if (!books.containsKey(book)) {
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }
        if (reader.hasBook(book)) {
            System.out.println(reader.getName() + "  is returning " + book);
            Code code = reader.removeBook(book);
            if (code.equals(Code.SUCCESS)) {
                returnBook(book);
            } else {
                System.out.println("Could not return " + book);
            }
            return code;
        }
        return Code.UNKNOWN_ERROR;
    }

    public Code returnBook(Book book) {
        if (!shelves.get(book.getSubject()).getSubject().equals(book.getSubject())) {
            System.out.println("No shelf for " + book.getSubject());
            return Code.SHELF_EXISTS_ERROR;
        }
        if (shelves.get(book.getSubject()).getSubject().equals(book.getSubject())) {
            shelves.get(book.getSubject()).addBook(book);
            return Code.SUCCESS;
        }
        return Code.UNKNOWN_ERROR;
    }

    private Code addBookToShelf(Book book, Shelf shelf) {
        Code code = returnBook(book);
        if (code.equals(Code.SUCCESS)) {
            return code;
        }
        String myShelf = shelf.getSubject();
        String myBook = book.getSubject();
        if (!myShelf.equals(myBook)) {
            shelf.addBook(book);
            return Code.SHELF_SUBJECT_MISMATCH_ERROR;
        }
        Code code1 = shelf.addBook(book);
        if (code1.equals(Code.SUCCESS)) {
            System.out.println(book + " added to shelf");
            return code1;
        } else {
            System.out.println("Could not add " + book + "to shelf");
        }
        return Code.UNKNOWN_ERROR;
    }

    public int listBooks() {//ok
        int bookCount = 0;
        for (Book book : books.keySet()) {
            if (books.get(book) > 1) {
                System.out.println(books.get(book) + " copies of " + book);
            }
            if (books.get(book) == 1) {
                System.out.println(books.get(book) + " copy of " + book);
            }

            bookCount += books.get(book);
        }
        return bookCount;
    }

    public Code checkOutBook(Reader reader, Book book) {
        if (!readers.contains(reader)) {
            return Code.READER_NOT_IN_LIBRARY_ERROR;
        }
        if (reader.getBookCount() >= LENDING_LIMIT) {
            return Code.BOOK_LIMIT_REACHED_ERROR;
        }
        if (!books.containsKey(book)) {
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }
        if (!shelves.containsValue(getShelf(book.getSubject()))) {
            return Code.SHELF_EXISTS_ERROR;
        }
        if (getShelf(book.getSubject()).getBookCount(book) < 1) {
            System.out.println("ERROR: no copies of" + book + "remain");
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }
        Code code = reader.addBook(book);
        if (code != Code.SUCCESS) {
            System.out.println("Couldn't checkout " + book);
            return code;
        }
        Code code1 = getShelf(book.getSubject()).removeBook(book);
        if (code1.equals(Code.SUCCESS)) {
            System.out.println(book + " checked out successfully");
//            LENDING_LIMIT -= 1; // fix
            return code1;
        }
        return Code.UNKNOWN_ERROR;
    }

    public Book getBookByISBN(String isbn) {//ok
        for (Book book : books.keySet()) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println(book);
                return book;
            }
        }
        System.out.println("ERROR: Could not find a book with isbn: " + isbn);
        return null;
    }

    public Code listShelves(boolean showBooks) {

        if (showBooks) {
            for (Shelf shelf : shelves.values()) {
                System.out.println(shelf.listBooks());
            }
            return Code.SUCCESS;
        }
        return Code.UNKNOWN_ERROR;
    }

    public Code addShelf(Shelf shelf) {//ok

        if (shelves.containsValue(shelf)) {
            System.out.println("ERROR: Shelf already exists " + shelf);
            return Code.SHELF_EXISTS_ERROR;
        } else if (!shelves.containsValue(shelf)) {
            for (Shelf value : shelves.values()) {
                if (shelf.getShelfNumber() == value.getShelfNumber()) {
                    shelf.setShelfNumber(shelves.size() + 1);
                }
            }

            shelves.put(shelf.getSubject(), shelf);
            //add all books with matching subjects
            int count;

            for (Book book : books.keySet()) {
                count = books.get(book);
                for (int i = 0; i < count; i++) {
                    if (book.getSubject().equals(shelf.getSubject())) {
                        addBookToShelf(book, shelf);
                    }
                }
            }
            return Code.SUCCESS;
        }
        return Code.UNKNOWN_ERROR;
    }

    public Code addShelf(String shelfSubject) {//ok
        Shelf shelf = new Shelf(shelves.size() + 1, shelfSubject);
        addShelf(shelf);
        return Code.SUCCESS;
    }

    public Shelf getShelf(Integer shelfNumber) {//ok
        for (Shelf value : shelves.values())
            if (value.getShelfNumber() == shelfNumber) {
                System.out.println(value);
                return value;
            }
        System.out.println("No shelf number " + shelfNumber + " found");
        return null;
    }

    public Shelf getShelf(String subject) {//ok
        subject = subject.trim();
        for (Shelf value : shelves.values()) {
            if (value.getSubject().equals(subject)) {
                return value;
            }
        }
        System.out.println("No shelf for " + subject + " books");
        return null;
    }

    public int listReaders() {//ok
//        System.out.println(readers);
        for (Reader reader : readers) {
            System.out.println(reader);
        }
        return readers.size();
    }

    public int listReaders(boolean showBooks) {//ok
        if (showBooks) {
            for (Reader reader : readers) {
                System.out.println(reader.getName() + "(#" + reader.getCardNumber() + ") has the following books: \n" +
                        reader.getBooks());
            }
        }
        if (!showBooks) {
            for (Reader reader : readers) {
                System.out.println(reader);
            }
        }
        return readers.size();
    }

    public Reader getReaderByCard(int cardNumber) {
        for (Reader reader : readers) {
            if (reader.getCardNumber() == cardNumber) {
                return reader;
            }
        }
        System.out.println("Could not find a reader with card #" + cardNumber);
        return null;
    }

    public Code addReader(Reader reader) {//all fixed I think
        if (readers.contains(reader)) {
            System.out.println(reader.getName() + " already has an account!");
            return Code.READER_ALREADY_EXISTS_ERROR;
        }
        for (Reader person : readers) {
            if (person.getCardNumber() == reader.getCardNumber()) {
                System.out.println(person.getName() + " and " + reader.getName() + " have the same card number!");
                return Code.READER_CARD_NUMBER_ERROR;
            }
        }
        if (!readers.contains(reader)) {
            System.out.println(reader.getName() + " added to the library!");
            readers.add(reader);

            if (reader.getCardNumber() > libraryCard) {
                libraryCard = reader.getCardNumber();
            }
            return Code.SUCCESS;
        }


        return Code.UNKNOWN_ERROR;
    }

    public Code removeReader(Reader reader) {

        if (reader.getBookCount() > 0) {
            System.out.println(reader.getName() + " must return all books!");
            return Code.READER_STILL_HAS_BOOKS_ERROR;
        }
        if (!readers.contains(reader)) {
            System.out.println(reader + " is not part of this Library");
            return Code.READER_NOT_IN_LIBRARY_ERROR;
        }
        if (readers.contains(reader) && reader.getBookCount() == 0) {
            readers.remove(reader);
            return Code.SUCCESS;
        }
        return Code.UNKNOWN_ERROR;
    }

    public int convertInt(String recordCountString, Code code) {
        try {
            return Integer.parseInt(recordCountString);
        } catch (NumberFormatException e) {
            System.out.println("Value which caused the error: " + recordCountString);
            System.out.println("Error message: " + code.getMessage());
            if (code.equals(Code.BOOK_COUNT_ERROR)) {
                System.out.println("Error: Could not read number of books");
            } else if (code.equals(Code.PAGE_COUNT_ERROR)) {
                System.out.println("Error: could not parse page count");
            } else if (code.equals(Code.DATE_CONVERSION_ERROR)) {
                System.out.println("Error: Could not parse date component");
            } else {
                System.out.println("Error: Unknown conversion error");
            }
            e.printStackTrace();
            return code.getCode();
        }
    }

    public LocalDate convertDate(String date, Code errorCode) {
        LocalDate newDate;
        LocalDate defaultDate = LocalDate.parse("1970-01-01");
        if (errorCode != Code.SUCCESS) {
            System.out.println(errorCode);
        }
        if (date.equals("0000")) {
            return defaultDate;
        }
        String[] dateData = date.split("-");
        if (dateData.length != 3) {
            System.out.println("ERROR: date conversion error, could not parse " + date);
            System.out.println("Using default date (01-jan-1970)");
            return defaultDate;
        }
        int year = Integer.parseInt(dateData[0]);
        int month = Integer.parseInt(dateData[1]);
        int day = Integer.parseInt(dateData[2]);
        if (year < 0 || month < 0 || day < 0) {
            System.out.println("Error converting date: Year " + year);
            System.out.println("Error converting date: Month " + month);
            System.out.println("Error converting date: Day " + day);
            System.out.println("Using default date (01-jan-1970)");
            return defaultDate;
        }
        newDate = LocalDate.of(year, month, day);
        return newDate;
    }

    public int getLibraryCardNumber() {
        return libraryCard + 1;
    }


    private Code errorCode(int codeNumber) { // double check, still dunno really
        for (Code error : Code.values()) {
            if (codeNumber == error.getCode()) {
                System.out.println(error);
                return error;
            }
        }
        return Code.UNKNOWN_ERROR;
    }
}