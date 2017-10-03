package services;

import constant.libraryClasses.SiteEnum;
import util.CSVReader;
import util.Printer;

import java.util.Map;
import java.util.Objects;

public class BookListService {
    private Printer printer = new Printer();
    private String bookName = null;
    private CSVReader csvReader = new CSVReader();

    public SiteEnum action(String action) {
        if (action.equalsIgnoreCase("quit")) {
            return SiteEnum.QUIT;
        } else if (action.equalsIgnoreCase("checkout")) {
            checkoutSelectBook(action);
        } else {
            listSpecifyBookDetail(action);
        }
        return SiteEnum.VIEW_LIST;
    }

    private void checkoutSelectBook(String checkoutCommand) {
        if (Objects.isNull(checkoutCommand)) {
            printer.printGuideWord("You haven't choose a book yet");
        } else {
            Map<String, String> bookDetail = csvReader.findBookDetailByBookName(bookName);
            if (isCheckoutBookAvailable(bookDetail)) {
                printer.printGuideWord("Checkout book 《" + bookName + "》 succeed\nThank you! Enjoy the book\n");
            } else {
                printer.printGuideWord("That book is not available");
            }

        }
    }

    private void listSpecifyBookDetail(String bookName) {
        this.bookName = bookName;
        CSVReader csvReader = new CSVReader();
        Map<String, String> bookDetailOfSearch = csvReader.findBookDetailByBookName(bookName);
        if (bookDetailOfSearch.isEmpty()) {
            printer.printGuideWord("Sorry! We have no such book!");
        } else {
            printer.printBookDetail(bookDetailOfSearch);
        }
    }

    private boolean isCheckoutBookAvailable(Map<String, String> bookDetail) {
        return !bookDetail.isEmpty() || Integer.parseInt(bookDetail.get("remainQuantity")) > 0;
    }
}
