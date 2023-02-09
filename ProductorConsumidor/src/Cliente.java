public class Cliente {
    private String nombre;
    private int[] bolsa;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.bolsa = new int[(int)(Math.random() * 5) + 1];
        for (int i = 0; i < this.bolsa.length; i++) {
            this.bolsa[i] = (int)(Math.random() * 250) + 100;
        }
    }

    public void procesar() {
        for (Integer producto: bolsa) {
            try {
                Thread.sleep(producto);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String getNombre() {
        return this.nombre;
    }

}
