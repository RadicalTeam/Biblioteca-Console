package util;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

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
        assertEquals(csvReader.findBookDetailByBookName("java start"), exceptBookDetail);
    }

    @Test
    public void should_return_empty_map_when_given_a_invalid_book_name() {
        Map<String, String> exceptBookDetail = new HashMap<>();
        assertEquals(csvReader.findBookDetailByBookName("PHP Start"), exceptBookDetail);
    }

}