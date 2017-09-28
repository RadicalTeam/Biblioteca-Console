package constant.libraryClasses;


import java.util.List;

public class Customer {
    private String name;

    private SiteEnum action;

    private List<String> chockoutedBooks;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void checkoutBook() {
        System.out.println("checkout book!");
    }

    public void returnBook() {
        System.out.println("return book");
    }

}
