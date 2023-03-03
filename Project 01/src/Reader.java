import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Reader {
    public static final int CARD_NUMBER_ = 0;
    public static final int NAME_ = 1;
    public static final int PHONE_ = 2;
    public static final int BOOK_COUNT_ = 3;
    public static final int BOOK_START_ = 4;
    private int cardNumber;
    private String name;
    private String phone;
    private List<Book> books;
    private Book book;

    Reader(int cardNumber,String name,String phone){
        this.cardNumber = cardNumber;
        this.name = name;
        this.phone = phone;
        books = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public Code addBook(Book book){
        this.book = book;
        if(!hasBook(book)) {
            books.add(book);
            return Code.SUCCESS;
        }else {
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        }

    }
    public Code removeBook(Book book){
        this.book = book;
        if(!hasBook(book)){
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        }else if(hasBook(book)){
            books.remove(book);
            return Code.SUCCESS;
        }else{
            return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
        }

    }

    public Boolean hasBook(Book book){
        this.book = book;
        if (!books.contains(book)) {
            return false;
        } else {
            return true;
        }
    }
    public int getBookCount(){
        int bookCount = books.size();
        return bookCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return CARD_NUMBER_ == reader.CARD_NUMBER_ && NAME_ == reader.NAME_ && PHONE_ == reader.PHONE_ && BOOK_COUNT_ == reader.BOOK_COUNT_ && BOOK_START_ == reader.BOOK_START_ && cardNumber == reader.cardNumber && name.equals(reader.name) && phone.equals(reader.phone) && books.equals(reader.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CARD_NUMBER_, NAME_, PHONE_, BOOK_COUNT_, BOOK_START_, cardNumber, name, phone, books);
    }

    @Override
    public String toString(){
        String readerString = name+"(" + cardNumber +")"+ " has checked out " + books;
        return readerString;
    }


    public static List<Book> readBooksFromCSV() {
        List<Book> bookList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/vera/IdeaProjects/Project 01/src/Library00.csv"))) {
            String line = br.readLine();
            while (line != null) {
                String[] bookData = line.split(",");
                Book book = createBook(bookData);
                bookList.add(book);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }
    private static Book createBook(String[] bookData) {
        String isbn = bookData[0];
        String title = bookData[1];
        String subject = bookData[2];
        int pageCount = Integer.parseInt(bookData[3]);
        String author = bookData[4];
        LocalDate dueDate = LocalDate.parse(bookData[5]);
        return new Book( isbn,title,subject, pageCount,author, dueDate);
    }
}
