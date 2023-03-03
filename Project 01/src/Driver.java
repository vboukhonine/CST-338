import java.time.LocalDate;

public class Driver {
    public static void main(String[] args) {
        Shelf shelf = new Shelf(1, "Fantasy");
        LocalDate date1 = LocalDate.parse("2006-07-17");
        Book book = new Book("1287247719", "Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch", "Fantasy", 120, "Terry Pratchett, Neil Gaiman", date1);
        Book book2 = new Book("9780006498858", "Ship of Magic", "Fantasy", 880, "Robin Hobb", date1);
        shelf.addBook(book);
        shelf.addBook(book);
//        shelf.addBook(book2);
//        shelf.addBook(book2);
//        shelf.addBook(book);
//        shelf.addBook(book);
//        System.out.println(shelf.getBookCount(book2));
//        int count = shelf.getBookCount(book2);
//        for (int i = 0; i < count; i++) {
//            shelf.removeBook(book2);
//        }
        shelf.listBooks();
        System.out.println(shelf.listBooks());
    }
}
