import constant.libraryClasses.Customer;
import constant.libraryClasses.SiteEnum;
import controller.ControlRouter;
import util.CSVReader;
import util.Printer;

import java.util.Scanner;

public class app {
    public static void main(String[] arg) {
        Printer printer = new Printer();
        printer.printGuideWord("app begin!");
        boolean canBreakOutLoop;
        SiteEnum site = SiteEnum.HOME;
        SiteEnum previousSite = null;

        Scanner in = new Scanner(System.in);
        printer.printGuideWord("enter your name first!");
        Customer customer = new Customer(in.next());
        printer.printWelcomeWord(customer.getName());
        ControlRouter controlRouter = new ControlRouter();
        do {
            if (site != previousSite) {
                printer.firstMessageWhenLocateNewPage(site);
            }
            previousSite = site;
            site = controlRouter.switchSite(in.nextLine(), site);
            canBreakOutLoop = site == SiteEnum.QUIT;
        } while (!canBreakOutLoop);
        printer.printGuideWord("quit now! \n Thanks using our library");
        CSVReader csvReader = new CSVReader();
        System.out.println(csvReader.findBookDetailByBookName("java start"));
    }
}
