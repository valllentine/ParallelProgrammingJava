package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BounceFrame extends JFrame {

    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    public static int BallCounter = 0;
    public static JLabel textField = new JLabel();
    public static boolean isPocketActive = false;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");

        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        ///
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        JButton buttonPriorityTest = new JButton("Priority");
        JButton buttonJoin = new JButton("Join");
        buttonPriorityTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball red = new Ball(canvas, 0,0, Color.RED);
                canvas.add(red);
                BallThread threadRed = new BallThread(red);
                threadRed.setPriority(Thread.MAX_PRIORITY);
                threadRed.start();
                System.out.println("Thread name = " + threadRed.getName());
                for(int i = 0; i < 100; i++) {
                    Ball blue = new Ball(canvas, 250,250, Color.BLUE);
                    canvas.add(blue);
                    BallThread thread = new BallThread(blue);
                    thread.setPriority(Thread.MIN_PRIORITY);
                    thread.start();
                    System.out.println("Thread name = " + thread.getName());

                }

            }
        });

        buttonJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                canvas.add(new Ball(canvas, Color.RED));
                canvas.add(new Ball(canvas, Color.BLUE));
                canvas.add(new Ball(canvas, Color.BLACK));
                JoinBall lastThread = null;

                for(int i = 0; i < BallCanvas.balls.size(); i++){
                    JoinBall thread = new JoinBall(BallCanvas.balls.get(i), lastThread);
                    lastThread = thread;
                    thread.start();
                }
            }
        });

        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                for(int i = 0; i < 1000; i++) {
                    Ball blue = new Ball(canvas);
                    canvas.add(blue);
                    BallThread thread = new BallThread(blue);
                    thread.start();
                    System.out.println("Thread name = " + thread.getName());

                }
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });

        buttonPanel.add(textField);
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        buttonPanel.add(buttonPriorityTest);
        buttonPanel.add(buttonJoin);
        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}

