public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador(0);
        Thread threadSumaDos = new Thread(() -> {
            for (int i = 0; i < contador.NUMVECES; i++){
                contador.incrementa();
                contador.incrementa();
                try {
                    Thread.sleep(1);
                }catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        });

        Thread threadRestaUno = new Thread() {
            public void run() {
                for (int i = 0; i < contador.NUMVECES; i++) {
                    contador.decrementa();
                    try {
                        Thread.sleep(1);
                    }catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        };
        threadSumaDos.start();
        threadRestaUno.start();
        try {
            threadSumaDos.join();
            threadRestaUno.join();
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("El valor final del contador es: " + contador.getValue());
    }
}
