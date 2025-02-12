package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExercise2 {

    private static final CyclicBarrier largada = new CyclicBarrier(5, () ->
            System.out.println("Iniciando corrida"));


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable r =  () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " preparando para largada");
            sleep();

            try {
                largada.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            System.out.println(name + " começou a correr.");


        };

        for (int i = 0; i < 5; i++) {

            executor.execute(r);
        }


        executor.shutdown();

    }

    private static void sleep() {
        try {
            Thread.sleep((long)5 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
