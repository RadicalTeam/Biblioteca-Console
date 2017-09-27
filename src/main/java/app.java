import constant.libraryClasses.Customer;
import constant.libraryClasses.SiteEnum;
import controller.ControlRouter;

import java.util.Scanner;

public class app {
    public static  void main(String[] arg) {
        System.out.println("app begin!");
        boolean canBreakOutLoop = false;
        SiteEnum action = SiteEnum.HOME;

        Scanner in = new Scanner(System.in);
        System.out.println("enter your name first!");
        Customer customer = new Customer(in.next());

        ControlRouter controlRouter = new ControlRouter(customer);
        do {
            System.out.println("input you command: ");
            action = controlRouter.switchSite(in.next(), action);
            switch (action) {
                case HOME:
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
        } while (!canBreakOutLoop);
    }
}
