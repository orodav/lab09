package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {

    private static final String PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";
    private File fileName;

    /**
     * @PATH
     */
    public Controller() {
        this.fileName = new File(PATH);
    }

    /**
     * @param newFile is the file that is being set as current file
     */
    public void setFile(final File newFile) {
        if (fileName == null) {
            throw new IllegalArgumentException();
        }
        this.fileName = newFile;
    }

    /**
     * @return the file that was set by method setFile()
     */
    public File getFile() {
        return this.fileName;
    }

    /**
     * @return the path of the current file in form of String
     */
    public String getPath() {
        if (fileName == null) {
            throw new IllegalStateException();
        }
        return fileName.getPath();
    }

    /**
     * @param str is the string the method gets as input
     * @return the file where str content is saved
     * @throws IOException the exception that the method throws
     */
    public File saveString(final String str) throws IOException {
        if (fileName == null) {
            throw new IllegalStateException();
        }
        if (str == null) {
            throw new IllegalArgumentException();
        }
        try (FileWriter fileWriteVar = new FileWriter(fileName, StandardCharsets.UTF_8)) {
            fileWriteVar.write(str);
        } 
        return fileName;
    }
}

