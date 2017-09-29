package services;

import constant.libraryClasses.SiteEnum;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import util.Printer;

import java.util.Objects;

public class BookListService {
    private Printer printer = new Printer();
    private String bookName = null;
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
            if(bookName.equalsIgnoreCase("error book")) {
                printer.printGuideWord("That book is not available");
            }
            printer.printGuideWord("Checkout book 《"+ bookName +"》 succeed\nThank you! Enjoy the book\n");
        }
    }

    private void listSpecifyBookDetail(String bookName) {
        this.bookName = bookName;
        printer.printGuideWord("\nBOOK DETAIL:\nMy University  author: GaoErJi  publish year: 2010");
    }
}
