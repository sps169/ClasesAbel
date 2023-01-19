public class SortAndSend {
    private String args;
    private ThreadGroup threads;

    public SortAndSend(String args) {
        this.args = args;
        this.threads = new ThreadGroup("Writers");
    }

    public void startWriting() {
        String[] args = this.args.split(" ");
        for (int i = 0; i < args.length; i++) {
            Writer writer = new Writer(args[i]);
            Thread thread = new Thread(this.threads, writer, "Writer "+ i);
//            thread.setPriority((int)(((double)args.length / 10.0) + 1.0 + (double)i/10.0));
            thread.start();
        }
    }

    public int checkActiveThreads() {
        return threads.activeCount();
    }
}
