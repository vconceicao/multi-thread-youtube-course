package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExercise {

    private static final CyclicBarrier barrier = new CyclicBarrier(3,
            () -> System.out.println("Todas as threads alcançaram a barreira, prosseguindo para fase 2"));
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();

            System.out.println(name + " trabalhando fase 1");
            sleep();
            await();
            System.out.println(name + " trabalhando na fase 2");

        };

        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        executor.shutdown();
    }

    private static void await() {

        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sleep() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
