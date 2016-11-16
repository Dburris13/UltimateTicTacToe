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
    private Color btn1Color = Color.GRAY;
    private Color btn2Color = Color.CYAN;
    private Color brdColor;
    private int gamemode;
    private Dimension resolution = new Dimension(1280,720);
    private String username;
    private int score;
    //private int score;

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

