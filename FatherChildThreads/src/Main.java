import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        threadVersion();
        runnableVersion();
    }

    public static void threadVersion() {
        ThrowDiceThread dice1Thread = new ThrowDiceThread("Dice1");
        ThrowDiceThread dice2Thread = new ThrowDiceThread("Dice2");
        dice1Thread.start();
        dice2Thread.start();
        try {
            dice1Thread.join();
            dice2Thread.join();
        }catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        if (dice1Thread.getResult() > dice2Thread.getResult()) {
            System.out.println("The thread " + dice1Thread.getName() + " obtained the biggest result: "
                    + dice1Thread.getResult());
        }else if (dice1Thread.getResult() < dice2Thread.getResult()) {
            System.out.println("The thread " + dice2Thread.getName() + " obtained the biggest result: "
                    + dice2Thread.getResult());
        }else {
            System.out.println("Both threads " + dice1Thread.getName() + " and " + dice2Thread.getName()
                    + " obtained the result: " + dice1Thread.getResult());
        }
    }

    public static void runnableVersion() {
        ThrowDiceRunnable dice1Runnable = new ThrowDiceRunnable();
        ThrowDiceRunnable dice2Runnable = new ThrowDiceRunnable();
        Thread dice1Thread = new Thread(dice1Runnable,"Dice1");
        Thread dice2Thread = new Thread(dice2Runnable, "Dice2");
        dice1Thread.start();
        dice2Thread.start();
        try {
            dice1Thread.join();
            dice2Thread.join();
        }catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        if (dice1Runnable.getResult() > dice2Runnable.getResult()) {
            System.out.println("The thread " + dice1Thread.getName() + " obtained the biggest result: "
                    + dice1Runnable.getResult());
        }else if (dice1Runnable.getResult() < dice2Runnable.getResult()) {
            System.out.println("The thread " + dice2Thread.getName() + " obtained the biggest result: "
                    + dice1Runnable.getResult());
        }else {
            System.out.println("Both threads " + dice1Thread.getName() + " and " + dice2Thread.getName()
                    + " obtained the result: " + dice1Runnable.getResult());
        }
    }
}
