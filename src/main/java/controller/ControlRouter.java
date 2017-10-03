package controller;

import constant.libraryClasses.Customer;
import constant.libraryClasses.SiteEnum;
import services.BookListService;
import services.HomeService;
import services.ReturnService;
import util.EnumTool;

import java.io.IOException;

public class ControlRouter {
    public Customer customer;
    private HomeService homeService = new HomeService();
    private EnumTool enumTool = new EnumTool();

    private BookListService bookListService = new BookListService();

    private ReturnService returnService = new ReturnService();

    public SiteEnum switchSite(String action, SiteEnum site) throws IOException {
        if(enumTool.isActionASiteName(SiteEnum.class, action)) {
            return enumTool.getSiteEnumByName(action);
        }
        SiteEnum nextSite = site;
        switch (site) {
            case HOME:
                nextSite = homeService.action(action);
                break;
            case LIST_BOOKS:
                nextSite = bookListService.action(action);
                break;
            case RETURN:
                nextSite = returnService.action(action);
                break;
            default:
                System.out.println("Welcome");
        }
        return nextSite;
    }
}
