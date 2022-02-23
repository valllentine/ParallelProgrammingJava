package com.company;

public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball){
        b = ball;
    }
    @Override
    public void run(){
        try{
            for(int i=1; i<10000; i++){
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                if (Pocket.IsBallInPocket(b) && BounceFrame.isPocketActive)
                {

                    BounceFrame.BallCounter++;
                    BounceFrame.textField.setText(Integer.toString(BounceFrame.BallCounter));
                    break;
                }
                Thread.sleep(5);


            }
        } catch(InterruptedException ex){
            System.out.println("Thread interrupted = "
                    + Thread.currentThread().getName());
            b.setInterruption();
        }
    }
}
