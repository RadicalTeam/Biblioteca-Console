package util;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    private String booksListFilePath;

    public CSVReader() {
        this.booksListFilePath = getResourcePath();
    }

    @NotNull
    private String getResourcePath() {
        File locateFile = new File(this.getClass().getResource("/").getPath());
        return locateFile.getParentFile().getPath() +
                File.separator +
                "resources" +
                File.separator +
                "books-list.scv";
    }

    public Map<String, String> buildBookDetailMap(String[] singleBookDetailArray) {
        Map<String, String> bookDetail = new HashMap<>();
        bookDetail.put("bookName", singleBookDetailArray[0]);
        bookDetail.put("author", singleBookDetailArray[1]);
        bookDetail.put("publishYear", singleBookDetailArray[2]);
        bookDetail.put("totalQuantity", singleBookDetailArray[3]);
        bookDetail.put("remainQuantity", singleBookDetailArray[4]);
        return bookDetail;
    }

    public Map<String, String> findBookDetailByBookName(String bookName) {
        BufferedReader bufferReader;
        String singleBookDetailLine;
        String csvSplitBy = ",";
        Map<String, String> selectBookDetail = new HashMap<>();
        try {
            bufferReader = new BufferedReader(new FileReader(booksListFilePath));
            while ((singleBookDetailLine = bufferReader.readLine()) != null) {
                String[] singleBookDetailArray = singleBookDetailLine.split(csvSplitBy);
                if (singleBookDetailArray[0].equalsIgnoreCase(bookName)) {
                    selectBookDetail = buildBookDetailMap(singleBookDetailArray);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return selectBookDetail;
    }

    public List<Map<String, String>> findAllBooks() {
        List<Map<String, String>> bookList = new ArrayList<>();
        BufferedReader bufferReader;
        String singleBookDetailLine;
        String csvSplitBy = ",";
        try {
            bufferReader = new BufferedReader(new FileReader(booksListFilePath));
            while ((singleBookDetailLine = bufferReader.readLine()) != null) {
                String[] singleBookDetailArray = singleBookDetailLine.split(csvSplitBy);
                bookList.add(buildBookDetailMap(singleBookDetailArray));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void checkoutBook(String bookName) throws IOException {
        List<Map<String, String>> bookList = findAllBooks();
        for (Map<String, String> book : bookList) {
            if (book.get("bookName").equalsIgnoreCase(bookName)) {
                Integer remainQuantity = Integer.parseInt(book.get("remainQuantity")) - 1;
                book.replace("remainQuantity", remainQuantity.toString());
            }
        }
        writeNewCsvFile(bookList);
    }

    public void returnBook(String bookName) throws IOException {
        List<Map<String, String>> bookList = findAllBooks();
        for (Map<String, String> book : bookList) {
            if (book.get("bookName").equalsIgnoreCase(bookName)) {
                Integer remainQuantity = Integer.parseInt(book.get("remainQuantity")) + 1;
                book.replace("remainQuantity", remainQuantity.toString());
            }
        }
        writeNewCsvFile(bookList);
    }

    private void writeNewCsvFile(List<Map<String, String>> bookList) throws IOException {
        FileWriter writeIntoFile = new FileWriter(getResourcePath());
        BufferedWriter bufferedWriter = new BufferedWriter(writeIntoFile);
        for (Map<String, String> book : bookList) {
            String line = "";
            line += book.get("bookName") + ","
                    + book.get("author") + ","
                    + book.get("publishYear") + ","
                    + book.get("totalQuantity") + ","
                    + book.get("remainQuantity") + "\n";
            bufferedWriter.write(line);
        }
        bufferedWriter.close();
    }
}