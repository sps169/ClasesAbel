public class ThrowDiceRunnable implements Runnable{
    private int result;
    public ThrowDiceRunnable() {
        this.result = -1;
    }

    public void run() {
        this.result = (int)(Math.random()*6) + 1;
    }

    public int getResult() {
        return this.result;
    }
}
