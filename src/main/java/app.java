import constant.libraryClasses.SiteEnum;
import controller.ControlRouter;

import java.util.Scanner;

public class app {
    public static void main(String[] arg) {
        System.out.println("app begin!");
        boolean canBreakOutLoop = false;
        Scanner in = new Scanner(System.in);
        SiteEnum action = SiteEnum.LOGIN;
        ControlRouter controlRouter = new ControlRouter();
        do {
            System.out.println("input you command: ");
            action = controlRouter.switchSite(in.next());
            switch (action) {
                case LOGIN:
                    System.out.println("login");
                    break;
                case VIEW_LIST:
                    System.out.println("view list");
                    break;
                case RENT:
                    System.out.println("checkout book");
                    break;
                case LOGOUT:
                    System.out.println("logout");
                    canBreakOutLoop = true;
                    break;
                case QUIT:
                    System.out.println("quit now! ");
                    canBreakOutLoop = true;
                    break;
                case ERROR:
                    System.out.println("wrong command");
                    break;
                default:
                    System.out.println("Welcome");
            }
        } while(!canBreakOutLoop);
    }
}
