package services;

import constant.libraryClasses.SiteEnum;
import util.CSVReader;
import util.Printer;

import java.io.IOException;
import java.util.Map;

public class ReturnService {
    private Printer printer = new Printer();

    private CSVReader csvReader;

    public SiteEnum action(String action) throws IOException {
        returnBook(action);
        return SiteEnum.RETURN;
    }

    private void returnBook(String bookName) throws IOException {
        csvReader = new CSVReader();
        Map<String, String> bookDetailOfReturn = csvReader.findBookDetailByBookName(bookName);
        if (bookDetailOfReturn.isEmpty()) {
            printer.printGuideWord("That is not a valid book to return.");
        } else {
            csvReader.returnBook(bookName);
            printer.printGuideWord("Thank you for returning the book");
        }
    }

}
