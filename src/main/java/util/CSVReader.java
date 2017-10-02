package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {
    private Map<String, String> bookDetail;

    public CSVReader() {
        this.bookDetail = new HashMap<>();
    }

    public Map<String, String> findBookDetailByBookName(String bookName) {
        PathReader pathReader = new PathReader();
        String booksListFilePath = pathReader.getResourcePath();
        BufferedReader bufferReader;
        String singleBookDetailLine;
        String csvSplitBy = ",";
        try {
            bufferReader = new BufferedReader(new FileReader(booksListFilePath));
            while ((singleBookDetailLine = bufferReader.readLine()) != null) {
                String[] singleBookDetailArray = singleBookDetailLine.split(csvSplitBy);
                if (singleBookDetailArray[0].equalsIgnoreCase(bookName)) {
                    bookDetail.put("bookName", singleBookDetailArray[0]);
                    bookDetail.put("author", singleBookDetailArray[1]);
                    bookDetail.put("publishYear", singleBookDetailArray[2]);
                    bookDetail.put("totalQuantity", singleBookDetailArray[3]);
                    bookDetail.put("remainQuantity", singleBookDetailArray[4]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookDetail;
    }

}