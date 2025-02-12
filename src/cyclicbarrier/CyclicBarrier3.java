package cyclicbarrier;

import java.util.concurrent.*;

public class CyclicBarrier3 {

    private static BlockingQueue<Double> resultados =
            new LinkedBlockingQueue<>();
    private static ExecutorService executorService;
    private static Runnable r1;
    private static Runnable r2;
    private static Runnable r3;
    private static double resultadoFinal = 0;

    //(432*3) + (3 ^ 14) + (45*127/12) = ?
    public static void main(String[] args) {


        executorService = Executors.newFixedThreadPool(3);

        Runnable finalizacao = () -> {
            System.out.println("Somando tudo");
            resultadoFinal +=resultados.poll();
            resultadoFinal +=resultados.poll();
            resultadoFinal +=resultados.poll();
            System.out.println("Processamento finalizado " +
                    "Resultado final = " + resultadoFinal
                + " Chupa meu pau!");
            System.out.println("---------------------");
            restart();
        };


        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, finalizacao);


        r1 = () -> {
            while (true) {
                resultados.add(432d*3d);
                await(cyclicBarrier);
                sleep();
                //System.out.println("Terminando o processamento");

            }
        };

        r2 = () -> {
            while (true) {

                resultados.add(Math.pow(3, 14));
                await(cyclicBarrier);
            }
            //System.out.println("Terminando o processamento");
        };

        r3 = () -> {
            while (true) {

                resultados.add( 45d*127d/12d);
                await(cyclicBarrier);
            }
            //System.out.println("Terminando o processamento");

        };





    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void restart() {
        executorService.execute(r1);
        executorService.execute(r2);
        executorService.execute(r3);

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
