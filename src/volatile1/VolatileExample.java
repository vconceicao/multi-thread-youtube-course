package volatile1;

public class VolatileExample {

    private static  boolean running =true;

    public static void main(String[] args) {

        Runnable runnable = () -> {
            while (running) {
                System.out.println("Rodando 1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread finalizada.");

        };

        Thread worker = new Thread(runnable);
        Thread worker2 = new Thread(runnable);

        worker.start();
        worker2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Parando a thread...");
        running=false;

    }



}
