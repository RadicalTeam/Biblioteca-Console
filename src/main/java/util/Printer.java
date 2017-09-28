package util;

import constant.libraryClasses.SiteEnum;

public class Printer {
    public void printWelcomeWord(String customerName) {
        System.out.println("Dear  " + customerName + "!\n\rWelcome Our Library! ");
    }

    public void printGuideWord(String guideWord) {
        System.out.println(guideWord);
    }

    public void announceLocationPage(SiteEnum site) {
        switch (site) {
            case HOME:
                System.out.println("We are locate in Home page");
                break;
            case VIEW_LIST:
                System.out.println("We are locate in view list");
                break;
            case RENT:
                System.out.println("We are locate in checkout book");
                break;
            case LOGOUT:
                System.out.println("We are locate in logout");
                break;
            case QUIT:
                System.out.println("We are locate in quit now! ");
                break;
            case ERROR:
                System.out.println("wrong command");
                break;
            default:
                System.out.println("Welcome");
        }
    }
}
