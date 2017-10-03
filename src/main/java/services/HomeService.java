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
            return SiteEnum.LIST_BOOKS;
        } else {
            System.out.println("Please select a valid option!");
        }
        return SiteEnum.HOME;
    }

}
