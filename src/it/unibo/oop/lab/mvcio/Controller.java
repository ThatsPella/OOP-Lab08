package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 
 */
public class Controller {

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */
    private static final String DEFAULT_FILENAME = "output.txt";
    private static final String DEFAULT_PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + DEFAULT_FILENAME;
    private File currentFile;
    /**
     *  Default constructor.
     */
    public Controller() {
        currentFile = new File(DEFAULT_PATH);
    }
    /**
     *  Constructor with specified file path.
     *  @param filePath the path of the file
     *  @throws FileNotFoundException if file is not found
     */
    public Controller(final String filePath) throws FileNotFoundException {
        currentFile = new File(filePath);
    }
    /**
     * @param file file selected
     * @throws FileNotFoundException if file is not found
     */
    public void setCurrentFile(final File file) {
        currentFile = file;
    }
    /**
     * @return the file currently selected
     */
    public File getFile() {
        return currentFile;
    }
    /**
     * @return the path of the file currently selected
     */
    public String getPath() {
        return currentFile.getPath();
    }
    /**
     * Writes a string on the current file.
     * @param s the string to write
     * @throws IOException if something goes wrong on the writing
     */
    public void write(final String s) throws IOException {
        if (s != null) {
            try (PrintStream ps = new PrintStream(currentFile)) {
                ps.print(s);
            }
        }
    }
}
