package services;

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
        if (action.equalsIgnoreCase("view")) {
            printer.printGuideWord("we are jumping to view list");
            return SiteEnum.VIEW_LIST;
        } else if (action.equalsIgnoreCase("return")) {
            printer.printGuideWord("we are jumping to return page");
            return SiteEnum.RETURN;
        } else if (action.equalsIgnoreCase("quit")) {
            printer.printGuideWord("quit now! ");
            return SiteEnum.QUIT;
        }
        System.out.println("you have input a in legal command! you");
        return SiteEnum.HOME;
    }
}
