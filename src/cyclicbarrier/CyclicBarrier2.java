package cyclicbarrier;

import java.util.concurrent.*;

public class CyclicBarrier2 {

    private static BlockingQueue<Double> resultados =
            new LinkedBlockingQueue<>();

    //(432*3) + (3 ^ 14) + (45*127/12) = ?
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable finalizacao = () -> {
            double resultadoFinal = 0;
            System.out.println("SOmando tudo");
            resultadoFinal+=resultados.poll();
            resultadoFinal+=resultados.poll();
            resultadoFinal+=resultados.poll();
            System.out.println("Processamento finalizado " +
                    "Resultado final = " + resultadoFinal
                + " Chupa meu pau!");
        };


        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, finalizacao);


        Runnable r1 = () -> {
            resultados.add(432d*3d);
            await(cyclicBarrier);
            System.out.println("Terminando o processamento");
        };

        Runnable r2 = () -> {
            resultados.add(Math.pow(3, 14));
            await(cyclicBarrier);
            System.out.println("Terminando o processamento");
        };

        Runnable r3 = () -> {
            resultados.add( 45d*127d/12d);
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
