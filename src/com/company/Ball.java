package com.company;
import java.math.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

class Ball {
    private final Component canvas;
    private Color color;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;

    private boolean isInterrupted = false;


    public Ball(Component c){
        this.canvas = c;


        if(Math.random()<0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }
    public Ball(Component c, Color color){
        this.canvas = c;
        this.color = color;

        if(Math.random()<0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }
    public Ball(Component c, int default_x, int default_y, Color color)
    {
        this.canvas = c;
        this.color = color;
        x = default_x;
        y = default_y;
    }

    public int getX()
    {
        return this.x + XSIZE / 2;
    }
    public int getY()
    {
        return this.y + YSIZE / 2;
    }

    public static void f(){
        int a = 0;
    }

    public void draw (Graphics2D g2){

        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));

    }


    public void move(){
        x+=dx;
        y+=dy;
        if(x<0){
            x = 0;
            dx = -dx;
        }
        if(x+XSIZE>=this.canvas.getWidth()){
            x = this.canvas.getWidth()-XSIZE;
            dx = -dx;
        }
        if(y<0){
            y=0;
            dy = -dy;
        }
        if(y+YSIZE>=this.canvas.getHeight()){
            y = this.canvas.getHeight()-YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

    public boolean getInterruption(){
        return isInterrupted;
    }
    public void setInterruption()
    {
        isInterrupted = true;
    }
}
