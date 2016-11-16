/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

import java.awt.*;
/**
 *
 * @author Daniel
 */
public class UserInfo {
    
    // Default Settings
    private Color btn1Color = Color.GRAY;
    private Color btn2Color = Color.CYAN;
    private String colorScheme = "Blue/Red";
    private String icons = "Item 2";
    private int gamemode = 2; // 1,2
    private Dimension resolution = new Dimension(1280,720);
    private String windowSize = "1280x720";
    private String username = "Guest";
    
    private int score;

    public UserInfo()
    {
    
    }
    
    public UserInfo(String username) {
        this.username = username;
    }

    public Color getColor1 () {
        return btn1Color;
    }

    public void setColor1 (Color color1) {
        this.btn1Color = color1;
    }
    
    public Color getColor2 () {
        return btn2Color;
    }
    
    public String getColorScheme () {
        return colorScheme;
    }
    public void setColorScheme (String colorCombo) {
        this.colorScheme = colorCombo;
    }
    
    public String getIcons () {
        return icons;
    }
    public String getWindowSize () {
        return windowSize;
    }    
    public void setWindowSize (String windowRes) {
        this.windowSize = windowRes;
    }


    public void setColor2 (Color color2) {
        this.btn2Color = color2;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getGamemode() {
        return this.gamemode;
    }
    
    public void setGamemode(int game) {
        this.gamemode = game;
    }
    
    public Dimension getResolution() {
        return this.resolution;
    }
    
    public void setResolution(Dimension playerRes) {
        this.resolution = playerRes;
    }
    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
}

