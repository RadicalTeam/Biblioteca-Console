package services;

import constant.libraryClasses.SiteEnum;
import util.Printer;

public class BookListService {
    private Printer printer = new Printer();
    public SiteEnum action(String action) {
        if (action.equalsIgnoreCase("quit")) {
            return SiteEnum.QUIT;
        }
        listSpecifyBookDetail(action);
        return SiteEnum.VIEW_LIST;
    }

    private void listSpecifyBookDetail(String bookName) {
        printer.printGuideWord("My University  author: GaoErJi  publish year: 2010");
    }
}
