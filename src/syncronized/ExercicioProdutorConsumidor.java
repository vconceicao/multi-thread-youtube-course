package syncronized;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ExercicioProdutorConsumidor {

    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    public static void main(String[] args) throws InterruptedException {




        Thread produtor1 = new Thread(new Producer());
        Thread produtor2 = new Thread(new Producer());

        produtor1.start();
        produtor2.start();


        Thread.sleep(1000);

        Consumer consumer = new Consumer();
        Thread consumer1 = new Thread(consumer);
        Thread consumer2 = new Thread(consumer);
        Thread consumer3 = new Thread(consumer);

        consumer1.start();
        consumer2.start();
        consumer3.start();






    }

    public static class Producer implements Runnable {
        private static final Random random = new Random();
        private static final int NUM_CONSUMERS = 3;
        private static final int NUM_MESSAGES = 50;

        @Override
        public void run() {
            try {
                for (int i = 0; i < NUM_MESSAGES / 2; i++) {
                    int numero = random.nextInt(100);
                    queue.put(numero);
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " produziu: " + numero);
                }

                // Insere valores especiais para finalizar consumidores
                    queue.put(-1);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    int numero = queue.take();
                    if (numero == -1) {
                        // Sinalizador de término, consumidor finaliza
                        queue.put(-1);
                        break;
                    }
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " consumiu: " + numero);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}

