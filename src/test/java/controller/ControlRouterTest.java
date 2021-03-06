package controller;

import constant.libraryClasses.SiteEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ControlRouterTest {
    private ControlRouter controlRouter;
    private String input;
    private SiteEnum locateSite;
    private SiteEnum exceptEnum;

    @Before
    public void beforeTest() {
        controlRouter = new ControlRouter();
    }

    public ControlRouterTest(String input, SiteEnum locateSite, SiteEnum exceptEnum) {
        this.input = input;
        this.locateSite = locateSite;
        this.exceptEnum = exceptEnum;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"list_books", SiteEnum.HOME, SiteEnum.LIST_BOOKS},
                {"return", SiteEnum.HOME, SiteEnum.RETURN},
                {"quit", SiteEnum.HOME, SiteEnum.QUIT},
                {"quit", SiteEnum.LIST_BOOKS, SiteEnum.QUIT},
                {"XXXX", SiteEnum.LIST_BOOKS, SiteEnum.LIST_BOOKS}
        });
    }

    @Test
    public void testControlRouter() throws Exception {
        assertEquals(exceptEnum, controlRouter.switchSite(input, locateSite));
    }

}