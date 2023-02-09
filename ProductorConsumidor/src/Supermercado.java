import java.util.LinkedList;
import java.util.List;

public class Supermercado {

    private int nCajas;
    private int nClientes;
    private int velocidad;

    private int nProductores;

    public Supermercado(int nProductores, int nCajas, int nClientes) {
        this.nProductores = nProductores;
        this.nCajas = nCajas;
        this.nClientes = nClientes;
        this.velocidad = 1;
    }

    public Supermercado(int nProductores, int nCajas, int nClientes, int velocidad) {
        this.nProductores = nProductores;
        this.nCajas = nCajas;
        this.nClientes = nClientes;
        if (velocidad > 0)
            this.velocidad = velocidad;
        else
            this.velocidad = 1;
    }

    public Supermercado() {
        this.nProductores = 2;
        this.nCajas = 3;
        this.nClientes = 0;
        this.velocidad = 1;
    }

    public void run() {
        Cola clientes = new Cola();
        for (char c = 'A'; (c - 'A') < nProductores; c++) {
            new ProductorClientes(c, nClientes, velocidad, clientes).start();
        }
        for (int i = 0; i < nCajas; i++) {
            Caja caja = new Caja("Caja " + (i + 1), clientes);
            caja.start();
        }
    }
}
