package Symbols;

public class ThreadAsync implements Runnable{
    public Character symbol = ' ';
    public final int print_count = 50;

    public ThreadAsync(Character symbol){
        this.symbol = symbol;
    }

    @Override
    public void run()
    {
        for(int i = 0; i < print_count; i++)
        {
            System.out.print(symbol);
        }
    }
}
