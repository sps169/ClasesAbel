import java.util.LinkedList;
import java.util.List;

public class Supermercado {

    private int nCajas;
    private int nClientes;
    private int velocidad;

    public Supermercado(int nCajas, int nClientes) {
        this.nCajas = nCajas;
        this.nClientes = nClientes;
        this.velocidad = 1;
    }

    public Supermercado(int nCajas, int nClientes, int velocidad) {
        this.nCajas = nCajas;
        this.nClientes = nClientes;
        if (velocidad > 0)
            this.velocidad = velocidad;
        else
            this.velocidad = 1;
    }

    public Supermercado() {
        this.nCajas = 3;
        this.nClientes = 0;
        this.velocidad = 1;
    }

    public void run() {
        Cola clientes = new Cola();
        ProductorClientes productorClientes = new ProductorClientes('A', nClientes, velocidad, clientes);
        ProductorClientes productorClientes2 = new ProductorClientes('B', nClientes, velocidad, clientes);
        productorClientes2.start();
        productorClientes.start();
        for (int i = 0; i < nCajas; i++) {
            Caja caja = new Caja("Caja " + (i + 1), clientes);
            caja.start();
        }
    }
}
