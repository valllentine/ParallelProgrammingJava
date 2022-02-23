package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pocket {

    public static final int PocketX = 200;
    public static final int PocketY = 200;
    public static final int PocketRadius = 50;

    public static boolean IsBallInPocket(Ball b)
    {
        int ballX = b.getX();
        int ballY = b.getY();
        int centerX = PocketX + PocketRadius / 2;
        int centerY = PocketY + PocketRadius / 2;
        return Math.pow((ballX - centerX), 2) + Math.pow((ballY - centerY), 2) <  10*PocketRadius;
    }

    public static void draw (Graphics2D g2)
    {
        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(new Ellipse2D.Double(PocketX,PocketY,PocketRadius,PocketRadius));
        g2.setColor(Color.BLUE);
    }

}
