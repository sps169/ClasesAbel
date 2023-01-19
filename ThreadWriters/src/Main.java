public class Main {
    public static void main(String[] args) {
        SortAndSend sorter = new SortAndSend("Hola mundo, exploramos el hiperespacio juntos?");
        sorter.startWriting();
        while (sorter.checkActiveThreads() > 0) {
            try {
                Thread.sleep(10);
            }catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("\nLos hilos han finalizado su ejecución");
    }
}
