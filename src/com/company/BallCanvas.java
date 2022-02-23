package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class BallCanvas extends JPanel
{
    public static  ArrayList<Ball> balls = new ArrayList<>();

    public void add(Ball b)
    {
        this.balls.add(b);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Pocket.draw(g2);
        for(int i=0; i<balls.size();i++)
        {
            Ball b = balls.get(i);
            if(b.getInterruption())
            {
                balls.remove(b);
                continue;
            }
            b.draw(g2);
        }


    }
}
