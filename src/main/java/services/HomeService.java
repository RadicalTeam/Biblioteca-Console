package services;

import constant.libraryClasses.ActionEnum;
import constant.libraryClasses.SiteEnum;
import util.Printer;


public class HomeService {
    private Printer printer = new Printer();

    public String login() {
        return "Welcome Our Library!";
    }

    public SiteEnum action(String action) {
        return switchSite(action);
    }

    private SiteEnum switchSite(String action) {
        if (action.equalsIgnoreCase(ActionEnum.LIST_BOOKS.name())) {
            return SiteEnum.VIEW_LIST;
        } else if (action.equalsIgnoreCase(ActionEnum.RETURN.name())) {
            return SiteEnum.RETURN;
        } else if (action.equalsIgnoreCase(ActionEnum.QUIT.name())) {
            printer.printGuideWord("quit now! ");
            return SiteEnum.QUIT;
        }
        System.out.println("Please select a valid option!");
        return SiteEnum.HOME;
    }

}
