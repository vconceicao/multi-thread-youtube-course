package cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExercise3 {

    private static final CyclicBarrier fimDeFase = new CyclicBarrier(4,
            () -> System.out.println("\n==> Todas as threads concluíram a fase 1. Iniciando fase 2...\n"));



    public static void main(String[] args) {

        ExecutorService executors = Executors.newFixedThreadPool(4);

        Runnable r1 = () -> {

            String name = Thread.currentThread().getName();
            System.out.println(name + " executando fase 1");
            sleep();
            try {
                System.out.println(name+ " fim da fase 1. Aguardando fase 2");
                fimDeFase.await();
                System.out.println(name + " iniciando fase 2...");

            } catch (InterruptedException | BrokenBarrierException e) {
                System.err.println(name + " foi interrompido ou a barreira quebrou.");
            }


        };

        for (int i = 0; i < 4; i++) {
            executors.execute(r1);
        }

        executors.shutdown();
    }

    private static void sleep() {

        try {
            Thread.sleep((new Random().nextInt(3)+1) * 1000);
        } catch (InterruptedException e) {
            System.out.println("Erro ao colocar a thread para dormir");
        }
    }
}
