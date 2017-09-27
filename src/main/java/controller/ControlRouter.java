package controller;

import constant.libraryClasses.Customer;
import constant.libraryClasses.SiteEnum;
import services.LibraryService;

import java.util.HashMap;
import java.util.Map;

public class ControlRouter {
    public Customer customer;
    LibraryService libraryService = new LibraryService();

    private Map<String, SiteEnum> siteMap = new HashMap<>();

    public ControlRouter(Customer customer) {
        this.customer = customer;
        siteMap.put("login", SiteEnum.HOME);
        siteMap.put("view", SiteEnum.VIEW_LIST);
        siteMap.put("rent", SiteEnum.RENT);
        siteMap.put("return", SiteEnum.RETURN);
        siteMap.put("quit", SiteEnum.QUIT);
        siteMap.put("logout", SiteEnum.LOGOUT);
    }

    public SiteEnum switchSite(String action, SiteEnum site) {
        return siteMap.getOrDefault(action, SiteEnum.ERROR);
    }

    private SiteEnum quitSite() {
        return SiteEnum.QUIT;
    }
}
