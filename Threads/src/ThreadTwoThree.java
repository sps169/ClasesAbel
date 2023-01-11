public class ThreadTwoThree extends Thread{

    public ThreadTwoThree(String name) {
        super(name);
    }
    @Override
    public void run() {
        int result = 0;
        for (int i = 1; i <= 1000; i++)
        {
            if (i % 10 == 2 || i % 10 == 3)
                result += i;
        }
        System.out.println(this.getName() + ": The result of the sum of the numbers finished in 2 or 3 from 1 to 1000 is: " + result);
        //Uncomment below in order to answer part 2
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
