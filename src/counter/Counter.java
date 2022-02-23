package counter;

public class Counter {
    private int counter = 0;

    public void asyncIncrement()
    {
        counter++;
    }
    public void asyncDecrement()
    {
        counter--;
    }


    public synchronized void syncIncrement()
    {
        counter++;
    }
    public synchronized void syncDecrement()
    {
        counter--;
    }

    public void syncBlockIncrement()
    {
        synchronized (this) {
            counter++;
        }
    }
    public  void syncBlockDecrement()
    {
        synchronized (this) {
            counter--;
        }
    }

    public int getCounter()
    {
        return counter;
    }
}
