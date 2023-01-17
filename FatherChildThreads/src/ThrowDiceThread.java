public class ThrowDiceThread extends Thread{
    private int result;
    public ThrowDiceThread(String name) {
        super(name);
        this.result = -1;
    }

    public void run() {
        this.result = (int)(Math.random()*6) + 1;
    }

    public int getResult() {
        return this.result;
    }

}
