package controller;

import constant.libraryClasses.Customer;
import constant.libraryClasses.SiteEnum;
import services.BookListService;
import services.HomeService;

public class ControlRouter {
    public Customer customer;
    HomeService homeService = new HomeService();

    BookListService bookListService = new BookListService();

    public SiteEnum switchSite(String action, SiteEnum site) {
        SiteEnum nextSite = site;
        switch (site) {
            case HOME:
                nextSite = homeService.action(action);
                break;
            case VIEW_LIST:
                nextSite = bookListService.action(action);
                break;
            case RENT:
                System.out.println("checkout book");
                break;
            case LOGOUT:
                System.out.println("logout");
                break;
            case ERROR:
                System.out.println("wrong command");
                break;
            default:
                System.out.println("Welcome");
        }
        return nextSite;
    }
}
