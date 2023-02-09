import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private Queue<Cliente> clientes;

    public Cola() {
        this.clientes = new LinkedList<>();
    }

    public Cola(Collection<Cliente> clientes) {
        this.clientes = new LinkedList<>(clientes);
    }

    public synchronized Cliente siguienteCliente() {
        return this.clientes.poll();
    }

    public synchronized void nuevoCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public int size() {
        return this.clientes.size();
    }
}
