package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrier1 {


    //(432*3) + (3 ^ 14) + (45*127/12) = ?
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);


        Runnable r1 = () -> {
            System.out.println((432d*3d) );
            await(cyclicBarrier);
            System.out.println("Ola");

            System.out.println("Terminando o processamento");
        };

        Runnable r2 = () -> {
            System.out.println(Math.pow(3, 14) );
            await(cyclicBarrier);
            System.out.println("Terminando o processamento");
        };

        Runnable r3 = () -> {
            System.out.println( 45d*127d/12d);

            await(cyclicBarrier);
            System.out.println("Terminando o processamento");

        };

        executorService.execute(r1);
        executorService.execute(r2);
        executorService.execute(r3);

        executorService.shutdown();



    }

    private static void await(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
