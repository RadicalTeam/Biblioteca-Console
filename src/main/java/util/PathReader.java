package util;

import java.io.File;

public class PathReader {
    public String getResourcePath() {
        File locateFile = new File(this.getClass().getResource("/").getPath());
        return locateFile.getParentFile().getPath() +
                File.separator +
                "resources" +
                File.separator +
                "books-list.scv";
    }

    public File getResourceFile() {
        return new File(getResourcePath());
    }
}
