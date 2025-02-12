package volatile1;



public class Volatile1 {

    private static int numero = 0;
    private static boolean preparado = false;

    private static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            while (!preparado) {
                Thread.yield();
            }

            System.out.println(numero);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MeuRunnable());
        thread.start();

        numero=42;
        preparado=true;
    }



}
