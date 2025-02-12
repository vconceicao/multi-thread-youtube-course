package semaphore;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Semaphore1 {

    private static final Semaphore SEMAPHORE = new Semaphore(100);
    private static final AtomicInteger QTD = new AtomicInteger(0);
    public static void main(String[] args) {
        //ExecutorService executors = Executors.newCachedThreadPool();
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(501);

        Janela janela = new Janela();
        janela.criaJanela();

        Runnable r1 = () -> {
            String name = Thread.currentThread().getName();
            int usuario = new Random().nextInt(10000);

            boolean conseguiu = false;
            QTD.incrementAndGet();
            while (!conseguiu) {
                conseguiu= tryAcquire();
            }
            QTD.decrementAndGet();


            Runnable r2 = () -> {
                janela.adicionarTexto(QTD.get()+"");
            };

            executors.scheduleWithFixedDelay(r2, 0, 100, TimeUnit.SECONDS);

            System.out.println("Usuário " + usuario +
                " se inscreveu no canal usando a thread " + name + "\n");
            sleep();
            SEMAPHORE.release();
        };


        for (int i = 0; i < 500; i++) {
            executors.execute(r1);
        }


    }

    private static void acquire() {
        try {
            SEMAPHORE.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean tryAcquire() {
        try {
            return  SEMAPHORE.tryAcquire(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return false;
        }
    }

    private static void sleep() {
        try {

            int tempoEspera = new Random().nextInt(5);
            tempoEspera++;
            Thread.sleep(1000 * tempoEspera);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
