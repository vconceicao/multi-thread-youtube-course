package volatile1;

public class Volatile2 {

    private static volatile int numero = 0;
    private static volatile boolean preparado = false;

    private static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            while (!preparado) {
                Thread.yield();
            }

            if (numero != 42) {
                System.out.println(numero);
                //throw new IllegalArgumentException("Increva-se no canal");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {

            Thread thread0 = new Thread(new MeuRunnable());
            thread0.start();
            Thread thread1 = new Thread(new MeuRunnable());
            thread1.start();
            Thread thread2 = new Thread(new MeuRunnable());
            thread2.start();


            numero=42;
            preparado=true;

            while (thread0.getState() != Thread.State.TERMINATED || thread1.getState() != Thread.State.TERMINATED || thread2.getState() != Thread.State.TERMINATED) {


            }
            numero=0;
            preparado=false;
        }


    }


}
