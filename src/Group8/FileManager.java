/*
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package Group8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Daniel
 */
public abstract class FileManager {
    
    String filename;
    String filePathString;
    File f;
    
    public FileManager(String filename) {
        this.filename = filename;
    }
    
    /**
     * An abstract method of what will be read.
     */
    abstract String[] readFile(); 
    
    abstract boolean writeFile(String input) throws FileNotFoundException, IOException;
}
