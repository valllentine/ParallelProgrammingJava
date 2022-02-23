package Symbols;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        for(int i =0; i < 100; i ++) {

            Thread asyncThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("");
                    asyncPrint();
                }
            });
            asyncThread.start();
            asyncThread.join();
            Thread.sleep(10);
        }

        for(int i =0; i < 100; i ++) {
            Thread syncThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("");
                    syncPrint();
                }
            });
            syncThread.start();
            syncThread.join();
            Thread.sleep(10);
        }

    }

    public static void asyncPrint() {
            ThreadAsync printMinus = new ThreadAsync('-');
            ThreadAsync printWall = new ThreadAsync('|');
            Thread threadMinus = new Thread(printMinus);
            Thread threadWall = new Thread(printWall);
            threadMinus.start();
            threadWall.start();
    }

    public static void syncPrint() {
        Flag flag = new Flag();
        ThreadSync printMinus = new ThreadSync('-', flag);
        ThreadSync printWall = new ThreadSync('|',flag);
        Thread threadMinus = new Thread(printMinus);
        Thread threadWall = new Thread(printWall);
        threadMinus.start();
        threadWall.start();
    }



}
