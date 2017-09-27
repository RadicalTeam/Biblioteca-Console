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
    private SiteEnum exceptEnum;

    @Before
    public void beforeTest() {
        controlRouter = new ControlRouter();
    }

    public ControlRouterTest(String input, SiteEnum exceptEnum) {
        this.input = input;
        this.exceptEnum = exceptEnum;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"login", SiteEnum.LOGIN},
                {"view", SiteEnum.VIEW_LIST},
                {"rent", SiteEnum.RENT},
                {"return", SiteEnum.RETURN},
                {"quit", SiteEnum.QUIT},
                {"logout", SiteEnum.LOGOUT},
        });
    }

    @Test
    public void testControlRouter() throws Exception {
        assertEquals(exceptEnum, controlRouter.switchSite(input));
    }

}