package services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryServiceTest {
    private LibraryService libraryService = new LibraryService();

    @Test
    public void should_return_welcome_words() throws Exception {
        assertEquals(libraryService.login(), "Welcome Our Library!");
    }

}