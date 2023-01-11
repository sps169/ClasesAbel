public class ThreadEvens extends Thread{
    public ThreadEvens(String name) {
        super(name);
    }
    @Override
    public void run() {
//        Uncomment below in order to answer part 2
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        int result = 0;
        for (int i = 1; i <= 1000; i++)
        {
            if (i % 2 == 0)
                result += i;
        }
        System.out.println(this.getName() + ": The result of the sum of the even numbers from 1 to 1000 is: " + result);
    }
}
