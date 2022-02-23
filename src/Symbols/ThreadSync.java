package Symbols;

public class ThreadSync implements Runnable{

    private Character symbol = ' ';
    private final Flag flag;
    private final int print_count = 50;

    public ThreadSync(Character symbol, Flag flag) {
        this.symbol = symbol;
        this.flag = flag;
    }

    @Override
    public void run()
    {
        synchronized (flag)
        {
            for (int i = 0; i < print_count; i++)
            {
                while (flag.flag && this.symbol == '-')
                {
                    try {
                        flag.wait();
                    } catch(InterruptedException e) {}
                }
                while (!flag.flag && this.symbol == '|')
                {
                    try {
                        flag.wait();
                    } catch(InterruptedException e) {}
                }

                System.out.print(this.symbol);
                flag.flag = !flag.flag;
                flag.notify();
            }
        }
    }
}

