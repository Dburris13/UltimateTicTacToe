/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */

package GUIStuff;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * A class that creates an animated X character.
 * @author Irene
 */
public class XChar extends BackgroundChars{
    private static final int INCREMENT = 8;

    /**
     * Constructs the XChar object using it's superclass constructor.
     * @param randXLoc x position of the character
     * @param randYLoc y position of the character
     * @param randomDelayedStart an integer used to delay the drawing of the 
     * character
     * @param color color of the character
     */
    public XChar(int randXLoc, int randYLoc, int randomDelayedStart, Color color) {
        super(randXLoc, randYLoc, randomDelayedStart, color);
    }

    /**
     * Implementation of BackgroundChars drawShape() function that draws "X".
     * The string is given a color, and a style.
     * @param g 
     */
    @Override
    void drawShape(Graphics g) {
        if (draw) {
            g.setColor(color);
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            g.drawString("X", randXLoc, randYLoc);     //vertical
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementation of BackgroundChars move() function that moves the character 
     * vertically.
     */
    @Override
    void move() {
        if (draw) {
            if (randYLoc <= 20) down = true;
            else if (randYLoc>=(D_HEIGHT-20)) down = false;

            if (down) {
                randYLoc += INCREMENT;
            } else {
                randYLoc -= INCREMENT;
            }
        }
    }
    
}