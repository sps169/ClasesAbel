public class Writer implements Runnable{

    private String text;
    private int position;

    public Writer(String text) {
        this.text = text;
        this.position = 0;
    }

    public void printLetter() {
        if (position < this.text.length())
        {
            System.out.print(this.text.charAt(position));
            try {
                Thread.sleep((int)(Math.random()*100) + 50);
            }catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        while (this.position < this.text.length()) {
            printLetter();
            this.position++;
        }
    }
}
