public class ThreadOdds extends Thread{
    public ThreadOdds(String name) {
        super(name);
    }
    @Override
    public void run() {
        int result = 0;
        for (int i = 1; i <= 1000; i++)
        {
            if (i % 2 != 0)
                result += i;
//        Uncomment below in order to answer part 2
            if (i % 400 == 0) {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        System.out.println(this.getName() + ": The result of the sum of the odd numbers from 1 to 1000 is: " + result);
    }
}
