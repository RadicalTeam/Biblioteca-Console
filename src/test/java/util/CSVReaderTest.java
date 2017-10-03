package util;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CSVReaderTest {
    private CSVReader csvReader = new CSVReader();

    @Test
    public void should_return_book_detail_when_given_a_valid_book_name() throws Exception {
        Map<String, String> exceptBookDetail = new HashMap<>();
        exceptBookDetail.put("bookName", "Java Start");
        exceptBookDetail.put("author", "Jackson");
        exceptBookDetail.put("publishYear", "2007");
        exceptBookDetail.put("totalQuantity", "20");
        exceptBookDetail.put("remainQuantity", "2");
        assertEquals(exceptBookDetail, csvReader.findBookDetailByBookName("java start"));
    }

    @Test
    public void should_return_empty_map_when_given_a_invalid_book_name() {
        Map<String, String> exceptBookDetail = new HashMap<>();
        assertEquals(exceptBookDetail, csvReader.findBookDetailByBookName("C# Start"));
    }

    @Test
    public void should_distance_the_remain_quantity_by_one_when_checkout_book() throws IOException {
        int beforeQuantity = Integer.parseInt(csvReader.findBookDetailByBookName("java start").get("remainQuantity"));
        csvReader.checkoutBook("java start");
        int afterQuantity = Integer.parseInt(csvReader.findBookDetailByBookName("java start").get("remainQuantity"));
        assertTrue(beforeQuantity - 1 == afterQuantity);
    }

    @Test
    public void should_find_all_books_in_csv_file() {
        assertEquals(csvReader.findAllBooks().size(), 5);
    }

}