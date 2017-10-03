package util;

import constant.libraryClasses.SiteEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                getViewListFirstMessage();
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

    private void getViewListFirstMessage() {
        CSVReader csvReader = new CSVReader();
        List<Map<String, String>> allBooksDetail = csvReader.findAllBooks();
        for (Map<String, String> book : allBooksDetail) {
            if(Integer.parseInt(book.get("remainQuantity")) > 0) {
                System.out.println(book.get("bookName") + "\n");
            }
        }
    }

    private void printFirstMessageOfViewListPage(List<String> bookList) {
        System.out.println("\nBOOK LIST IS FOLLOWED:\n");
        for (String book : bookList) {
            System.out.println("《"+ book +"》");
        }
    }

    public void printBookDetail(Map<String, String> specifyBookDetail) {
        String printString = "Follow is the selected book detail";
        printString += "\nbookName: " + specifyBookDetail.get("bookName");
        printString += "\nauthor: " + specifyBookDetail.get("author");
        printString += "\npublishYear: " + specifyBookDetail.get("publishYear");
        System.out.println(printString);
    }
}
