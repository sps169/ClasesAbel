import java.util.Queue;

public class ProductorClientes extends Thread{

    private final int OVERFLOW = 100;
    private char id;
    private int limite;
    private int velocidad;
    private Cola clientes;

    public ProductorClientes (char id, int limite, int velocidad, Cola cola) {
        this.id = id;
        this.limite = limite;
        this.velocidad = velocidad;
        this.clientes = cola;
    }
    public void run() {
            int i = 0;

            while (i < limite || (limite == 0 && clientes.size() < OVERFLOW)) {
                clientes.nuevoCliente(new Cliente(id + "" + (i + 1)));
                i++;
                try {
                    Thread.sleep(500 / velocidad);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
            if (limite == 0)
                System.out.println("No se pueden producir mas clientes, la cola ha superado el limite.");
            else
                System.out.println("Numero deseado de clientes alcanzado.");
    }
}
