/*
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package PlayerInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Abstract class defining abstract methods for all File I/O.
 * Only has two abstract methods read and write file because its all we
 * need for this project. We have an abstract class define so that future
 * work on this project can use other file I/O classes.
 *  
 * @author Daniel
 */
public abstract class FileManager {
    
    String filename;
    String filePathString;
    File f;
    
    /**
     * Constructor method.
     * 
     * @param filename 
     */
    public FileManager(String filename) {
        this.filename = filename;
    }
    
    /**
     * Reading a file.
     * 
     * @return String array of all the file data.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    abstract String[] readFile() throws FileNotFoundException, IOException; 
    
    /**
     * Writing a file. 
     * 
     * @param name name of file
     * @return boolean representing if write was a success
     * @throws FileNotFoundException
     * @throws IOException 
     */
    abstract boolean writeFile(String name) throws FileNotFoundException, IOException;
}
