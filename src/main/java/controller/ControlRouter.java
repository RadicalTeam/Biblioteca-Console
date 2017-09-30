package controller;

import constant.libraryClasses.Customer;
import constant.libraryClasses.SiteEnum;
import services.BookListService;
import services.HomeService;
import services.ReturnService;

public class ControlRouter {
    public Customer customer;
    private HomeService homeService = new HomeService();

    private BookListService bookListService = new BookListService();

    private ReturnService returnService = new ReturnService();

    public SiteEnum switchSite(String action, SiteEnum site) {
        SiteEnum nextSite = site;
        switch (site) {
            case HOME:
                nextSite = homeService.action(action);
                break;
            case VIEW_LIST:
                nextSite = bookListService.action(action);
                break;
            case RETURN:
                nextSite = returnService.action(action);
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
