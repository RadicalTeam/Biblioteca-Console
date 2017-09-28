package services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeServiceTest {
    private HomeService homeService = new HomeService();

    @Test
    public void should_return_welcome_words() throws Exception {
        assertEquals(homeService.login(), "Welcome Our Library!");
    }

}