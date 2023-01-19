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
            if (i < 10) {
                thread.setPriority(i + 1);
            }else {
                thread.setPriority(10);
            }
            thread.start();
        }
    }

    public int checkActiveThreads() {
        return threads.activeCount();
    }
}
