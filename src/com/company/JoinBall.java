package com.company;

public class JoinBall extends Thread {

    private Ball b;
    private Thread thread = null;

    public JoinBall(Ball ball, Thread thread){
        this.b = ball;
        this.thread = thread;
    }

    @Override
    public void run(){
        try{
            if(thread != null){
                thread.join();
            }
            while(!b.getInterruption()){
                b.move();
                if (Pocket.IsBallInPocket(b) && BounceFrame.isPocketActive){
                    currentThread().interrupt();
                }
                Thread.sleep(5);
            }
        } catch(InterruptedException ex){
            System.out.println("Thread interrupted = " + Thread.currentThread().getName());
            b.setInterruption();
        }
    }
}
