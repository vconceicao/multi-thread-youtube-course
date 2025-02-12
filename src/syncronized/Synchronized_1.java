package syncronized;

public class Synchronized_1 {


    static int i = -1; //recurso que será acessado pelas threads
    public static void main(String[] args) {
        MeuRunnable runnable = new MeuRunnable();
        for (int j = 0; j < 10; j++) {
            new Thread(runnable).start();
        }
        System.out.println(i);
    }


    public static void imprime() {
        synchronized (Synchronized_1.class) {
            i++;
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + i);
        }
    }
    public static class MeuRunnable implements Runnable{

        static final Object lock1 =  new Object();
        static final Object lock2 =  new Object();
        @Override
//        public synchronized void run() {
        public  void run() {
           // imprime();
//            synchronized (lock1) {
//                //não é possivel garantir a ordem numa execução com threads
//                i++;
//
//            }
//            synchronized (lock2) {
//                //não é possivel garantir a ordem numa execução com threads
//                i++;
//
//            }


        }


    }


}
