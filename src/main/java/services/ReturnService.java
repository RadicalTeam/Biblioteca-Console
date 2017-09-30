package services;

import constant.libraryClasses.SiteEnum;
import util.Printer;

public class ReturnService {
    private Printer printer = new Printer();

    public SiteEnum action(String action) {
        if (action.equalsIgnoreCase("quit")) {
            return SiteEnum.QUIT;
        } else {
            returnBook(action);
        }
        return SiteEnum.RETURN;
    }

    private void returnBook(String bookName) {
        if (bookName.equalsIgnoreCase("error book")) {
           printer.printGuideWord("That is not a valid book to return.");
        } else {
            printer.printGuideWord("Thank you for returning the book");
        }
    }

}
