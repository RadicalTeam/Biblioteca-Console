package services;

import constant.libraryClasses.SiteEnum;
import util.Printer;

import java.util.Objects;

public class HomeService {
    public String login() {
        return "Welcome Our Library!";
    }
    private Printer printer = new Printer();

    public SiteEnum action(String action) {
        return switchSite(action);
    }

    private SiteEnum switchSite(String action) {
        if(action.equalsIgnoreCase("view")) {
            printer.printGuideWord("we are jumping to view list");
            return SiteEnum.VIEW_LIST;
        } else if(action.equalsIgnoreCase("return")) {
            printer.printGuideWord("we are jumping to return page");
            return SiteEnum.RETURN;
        }
        System.out.println("you have input a in legal command! you");
        return SiteEnum.HOME;
    }
}
