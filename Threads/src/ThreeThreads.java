public class ThreeThreads {

    //Podemos observar que la ejecución varía si no descomentamos los sleeps.
    //Esto se debe a que el procesador es el que decide a que hilo darle prioridad
    //en vez de controlarlo nosotros. Esto resulta en un comportamiento no deterministico.
    //
    //Para controlar el comportamiento, descomentamos los sleep de las tres clases Thread.
    //Una vez implementados los tiempos de espera, el orden es siempre two three, evens, odds
    //Esto se debe a los tiempo de espera implementados: al ser suficientemente grandes, la
    //aleatoriedad del procesador queda sufragada. Sin embargo, esta forma de sincronizar hilos
    //deja muchos espacios de espera en el procesador y para ejecuciones de hilos mas grandes puede
    //ser insuficiente, siendo un claro candidato para la aparición de bugs. Para evitar esta situación,
    //debe buscarse un sistema de sincronización de hilos mas efectivo.
    public static void main(String[] args) {
        ThreadOdds odds = new ThreadOdds("odds thread");
        ThreadEvens evens = new ThreadEvens("evens thread");
        ThreadTwoThree twoThree = new ThreadTwoThree("two three thread");

        odds.start();
        evens.start();
        twoThree.start();
        try {
            odds.join();
            evens.join();
            twoThree.join();
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Hilo main: " + Thread.currentThread().getName() + " finalizado");
    }
}
