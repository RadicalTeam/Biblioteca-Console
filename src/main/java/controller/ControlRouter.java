package controller;

import constant.libraryClasses.SiteEnum;

import java.util.HashMap;
import java.util.Map;

public class ControlRouter {
    private Map<String, SiteEnum> actionMap = new HashMap<>();

    public ControlRouter() {
        actionMap.put("login", SiteEnum.LOGIN);
        actionMap.put("view", SiteEnum.VIEW_LIST);
        actionMap.put("rent", SiteEnum.RENT);
        actionMap.put("return", SiteEnum.RETURN);
        actionMap.put("quit", SiteEnum.QUIT);
        actionMap.put("logout", SiteEnum.LOGOUT);
    }

    public SiteEnum switchSite(String routeSite) {
        return actionMap.getOrDefault(routeSite, SiteEnum.ERROR);
    }

    private SiteEnum quitSite() {
        return SiteEnum.QUIT;
    }
}
