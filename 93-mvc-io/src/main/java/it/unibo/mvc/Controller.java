package it.unibo.mvc;

import java.util.List;

/**
 * Interface for MVC.
 */
public interface Controller {

    /**
     * @param newString set the string to print.
     */
    void setPrintableString(String newString);

    /**
     * @return the next String to print.
     */
    String getNextString();

    /**
     * @return list of already printed string.
     */
    List<String> getPrintHistory();

    /**
     * @return the setted string.
     */
    String printCurrentString();
}
