package syncronized;

import thread.MeuRunnable;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ColecoesParaConcorrencia {

//    private static List<String> lista = new CopyOnWriteArrayList<>();

//    private static Map<Integer, String> map = new ConcurrentHashMap<>();

    private static BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MeuRunnable();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(500);
        System.out.println(queue);
    }

    public static class MeuRunnable implements Runnable {


        @Override
        public void run() {
//            lista.add("Inscreva-se no canal");
//            map.put(new Random().nextInt(),"Inscreva-se no canal");
            queue.add("Inscreva-se no canal");
            String name = Thread.currentThread().getName();
            System.out.println(name + " inseriu na lista!");
        }
    }

}
