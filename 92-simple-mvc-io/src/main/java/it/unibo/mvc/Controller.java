package it.unibo.mvc;

import java.io.File;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File fileName;

    public void setFile(File fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException();
        }
        this.fileName = fileName;
    }

    public File getFile() {
        return this.fileName;
    }

    public String getPath() {
        if (fileName == null) {
            throw new IllegalStateException();
        }
        return fileName.getPath();
    }

    public File saveString(String str) {
        return fileName;
    }
}

