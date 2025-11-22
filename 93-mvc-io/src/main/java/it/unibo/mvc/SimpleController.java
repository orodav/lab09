package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Controller interface.
 */
public final class SimpleController implements Controller {

    private String currentString;
    private final List<String> history = new ArrayList<>();

    /**
     * @param newString set the string to print.
     */
    @Override
    public void setPrintableString(final String newString) {
        if (newString == null) {
            throw new IllegalArgumentException();
        }
        this.currentString = newString;
    }

    /**
     * @return the next String to print.
     */
    @Override
    public String getNextString() {
        return currentString;
    }

    /**
     * @return list of already printed string.
     */
    @Override
    public List<String> getPrintHistory() {
        return new ArrayList<>(history);
    }

    /**
     * @return the setted string.
     * @throws IllegalStateException requested by execrise.
     */
    @Override
    public String printCurrentString() {
        if (currentString == null) {
            throw new IllegalStateException();
        }
        System.out.println(currentString);  // NOPMD: requested by exercise
        history.add(currentString);
        return currentString;
    }

}
