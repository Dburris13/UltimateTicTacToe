/* 
 * CS321 - Java Programming
 * Final Project - Team 8 - Ultimate Tic-Tac-Toe
 * 
 * Members:
 * Daniel, Ben, Irene, Zach
 */
package Group8;
import java.awt.*;

/**
 * This class tracks on User Information.
 * This includes things such as user settings (color, window resolution),
 * as well as username which is used for rank table.
 * 
 * @author Daniel
 * @author Ben
 */
public class UserInfo {
    
    /**
     * Color of tiles, some are used for setting it (Color),
     * the other is used for saving it into file (String)
     * Default is Cyan/Gray
     */
    private Color btn1Color = Color.GRAY;
    private Color btn2Color = Color.CYAN;
    private String colorScheme = "Cyan/Gray";
    
    /**
     * Determines whether player1 is versus AI or player
     * 1 = AI
     * 2 = player (default)
     */
    private int gamemode = 2;
    
    /**
     * Screen resolution, one is used for settings it (Dimension),
     * the other is used for saving it into file (string)
     * Default is 1280x720
     */
    private Dimension resolution = new Dimension(1280,720);
    private String windowSize = "1280x720";
    private String username = "Guest";
    
    /**
     * Used for rank table
     */
    private int score;

    /**
     * Constructor for when we have a temp / no UserProfile loaded
     */
    public UserInfo()
    {
    
    }
    
    /**
     * Constructor for when we have a userProfile loaded.
     * @param username Passes in the name of the user
     */
    public UserInfo(String username) {
        this.username = username;
    }

    /**
     * 
     * @return color of even tiles (0,2,4,6,8)
     */
    public Color getColor1 () {
        return btn1Color;
    }

    /**
     * 
     * @param color1 color of even tiles (0,2,4,6,8)
     */
    public void setColor1 (Color color1) {
        this.btn1Color = color1;
    }
    
    /**
     * 
     * @return color of odd tiles (1,3,5,7)
     */
    public Color getColor2 () {
        return btn2Color;
    }
    
    /**
     * 
     * @param color2 color of odd tiles (1,3,5,7)
     */
    public void setColor2 (Color color2) {
        this.btn2Color = color2;
    }
    
    /**
     * 
     * @return color of both tiles in string format (used for loading settings)
     */
    public String getColorScheme () {
        return colorScheme;
    }
    
    /**
     * 
     * @param colorCombo color of both tiles in string format (used for saving settings)
     */
    public void setColorScheme (String colorCombo) {
        this.colorScheme = colorCombo;
    }

    /**
     * 
     * @return username of user profiles
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * 
     * @param username  username of user profiles
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * 
     * @return integer indicating whether gamemode is vs AI or player
     */
    public int getGamemode() {
        return this.gamemode;
    }
    
    /**
     * 
     * @param game integer indicating whether gamemode is vs AI or player
     */
    public void setGamemode(int game) {
        this.gamemode = game;
    }
    
    /**
     * 
     * @return game screen resolution
     */
    public Dimension getResolution() {
        return this.resolution;
    }
    
    /**
     * 
     * @param playerRes game screen resolution
     */
    public void setResolution(Dimension playerRes) {
        this.resolution = playerRes;
    }
    
    /**
     * 
     * @return game screen resolution (used for loading settings)
     */
    public String getWindowSize () {
        return windowSize;
    }    
    
    /**
     * 
     * @param windowRes game screen resolution (used for saving settings)
     */
    public void setWindowSize (String windowRes) {
        this.windowSize = windowRes;
    }
    
    /**
     * 
     * @return score used for rank table
     */
    public int getScore() {
        return this.score;
    }
    
    /**
     * 
     * @param score score used for rank table
     */
    public void setScore(int score) {
        this.score = score;
    }
}

