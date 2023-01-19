public class Contador {
    private int c;
    public final int NUMVECES = 1000;
    public Contador(int c) {
        this.c = c;
    }

    public void incrementa() {
        this.c++;
    }

    public void decrementa() {
        this.c--;
    }

    public int getValue() {
        return this.c;
    }


}
