package counter;

import java.util.concurrent.locks.ReentrantLock;

public class   Main {
    public static void main(String[] args) throws InterruptedException {
        int n_times = 1000000;
        Counter counter1 = new Counter();

        Thread asyncThreadIncrement = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < n_times; i++) counter1.asyncIncrement();
            }
        });
        Thread asyncThreadDecrement = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < n_times; i++) counter1.asyncDecrement();
            }
        });
        long time = System.currentTimeMillis();
        asyncThreadIncrement.start();
        asyncThreadDecrement.start();
        asyncThreadIncrement.join();
        asyncThreadDecrement.join();
        System.out.println("Асинхронний доступ до лічильника, на лічильнику: " + counter1.getCounter());
        System.out.println("Час в мілісекундах: " + (System.currentTimeMillis() - time));

        Counter counter2 = new Counter();

        Thread syncThreadIncrement = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < n_times; i++) counter2.syncIncrement();
            }
        });
        Thread syncThreadDecrement = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < n_times; i++) counter2.syncDecrement();
            }
        });
        time = System.currentTimeMillis();
        syncThreadIncrement.start();
        syncThreadDecrement.start();
        syncThreadIncrement.join();
        syncThreadDecrement.join();
        System.out.println("Синхронний доступ до лічильника за допомогою синхронізованого методу, на лічильнику: " + counter2.getCounter());
        Counter counter3 = new Counter();
        System.out.println("Час в мілісекундах: " + (System.currentTimeMillis() - time));


        Thread syncBlockThreadIncrement = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < n_times; i++) counter3.syncBlockIncrement();
            }
        });
        Thread syncBlockThreadDecrement = new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < n_times; i++) counter3.syncBlockDecrement();
            }
        });
        time = System.currentTimeMillis();
        syncBlockThreadIncrement.start();
        syncBlockThreadDecrement.start();
        syncBlockThreadIncrement.join();
        syncBlockThreadDecrement.join();
        System.out.println("Синхронний доступ до лічильника за допомогою синхронізованого блоку, на лічильнику: " + counter3.getCounter());
        Counter counter4 = new Counter();
        System.out.println("Час в мілісекундах: " + (System.currentTimeMillis() - time));


        ReentrantLock locker = new ReentrantLock();
        Thread syncMethodThreadIncrement = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < n_times; i++) {
                    locker.lock();
                    counter4.asyncIncrement();
                    locker.unlock();
                }
            }
        });
        Thread syncMethodThreadDecrement = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < n_times; i++)
                {
                    locker.lock();
                    counter4.asyncDecrement();
                    locker.unlock();
                }
            }
        });
        time = System.currentTimeMillis();
        syncMethodThreadIncrement.start();
        syncMethodThreadDecrement.start();
        syncMethodThreadIncrement.join();
        syncMethodThreadDecrement.join();
        System.out.println("Синхронний доступ до лічильника за допомогою блокування, на лічильнику: " + counter4.getCounter());
        System.out.println("Час в мілісекундах: " + (System.currentTimeMillis() - time));




    }
}
