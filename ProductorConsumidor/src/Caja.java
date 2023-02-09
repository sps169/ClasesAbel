public class Caja extends Thread{

    private String nombre;
    private Cola cola;
    public Caja(String nombre, Cola cola) {
        this.nombre = nombre;
        this.cola = cola;
    }
    public void run() {
        int milisecsWaiting = 0;
        while (milisecsWaiting < 1000)
        {
            while (cola.size() == 0 && milisecsWaiting < 1000) {
                milisecsWaiting++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
            Cliente cliente = cola.siguienteCliente();
            if (cliente != null) {
                System.out.println("Cliente " + cliente.getNombre() + " entra a caja " + this.nombre);
                cliente.procesar();
                System.out.println("Cliente " + cliente.getNombre() + " sale de la caja " + this.nombre);
            }
        }
        System.out.println(this.nombre + " ha cerrado por estar esperando mucho tiempo");
    }
}
