package controller;

import constant.libraryClasses.Customer;
import constant.libraryClasses.SiteEnum;
import services.BookListService;
import services.HomeService;

import java.util.HashMap;
import java.util.Map;

public class ControlRouter {
    public Customer customer;
    HomeService homeService = new HomeService();

    BookListService bookListService = new BookListService();

    private Map<String, SiteEnum> siteMap = new HashMap<>();

    public ControlRouter() {
        siteMap.put("login", SiteEnum.HOME);
        siteMap.put("view", SiteEnum.VIEW_LIST);
        siteMap.put("rent", SiteEnum.RENT);
        siteMap.put("return", SiteEnum.RETURN);
        siteMap.put("quit", SiteEnum.QUIT);
        siteMap.put("logout", SiteEnum.LOGOUT);
    }

    public SiteEnum switchSite(String action, SiteEnum site) {
        SiteEnum nextSite = site;
        switch (site) {
            case HOME:
                nextSite = homeService.action(action);
                break;
            case VIEW_LIST:
                nextSite = bookListService.action(action);
                System.out.println("view list");
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
