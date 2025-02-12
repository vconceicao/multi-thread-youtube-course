package synchronousqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueue1 {

    private static final SynchronousQueue<String> FILA =
            new SynchronousQueue<>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {

            try {
                System.out.println("adicionando mensagem na fila");
                FILA.put("Inscreva-se no anal");
                FILA.put("Inscreva-se no anal");
            } catch (InterruptedException e) {
                System.out.println("Problema ao adicionar na fila");
                Thread.currentThread().interrupt();
            }
        };

        Runnable r2 = () -> {

            try {
                System.out.println("recuperando  mensagem na fila");
                String mensagem = FILA.take();
                String mensagem1 = FILA.take();
                System.out.println("Mensagem recuperada: " + mensagem);
            } catch (InterruptedException e) {
                System.out.println("Problema ao adicionar na fila");
                Thread.currentThread().interrupt();
            }
        };

        executor.execute(r1);
        executor.execute(r2);

        executor.shutdown();
    }
}
