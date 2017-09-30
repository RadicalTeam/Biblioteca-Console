package util;

import constant.libraryClasses.SiteEnum;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    public void printWelcomeWord(String customerName) {
        System.out.println("Dear  " + customerName + "!\n\rWelcome Our Library! ");
    }

    public void printGuideWord(String guideWord) {
        System.out.println(guideWord);
    }

    public void firstMessageWhenLocateNewPage(SiteEnum site) {
        switch (site) {
            case HOME:
                System.out.println("We are locate in Home page");
                break;
            case RETURN:
                System.out.println("We are locating in RETURN PAGE\nPlease input the book name you want return");
                break;
            case VIEW_LIST:
                System.out.println("We are locate in view list");
                printFirstMessageOfViewListPage(getViewListFirstMessage());
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

    private List<String> getViewListFirstMessage() {
        List<String> booksList = new ArrayList<>();
        booksList.add("Start Java");
        booksList.add("Start PHP");
        booksList.add("Start Javascript");
        return booksList;
    }

    private void printFirstMessageOfViewListPage(List<String> bookList) {
        System.out.println("\nBOOK LIST IS FOLLOWED:\n");
        for (String book : bookList) {
            System.out.println("《"+ book +"》");
        }
    }
}
