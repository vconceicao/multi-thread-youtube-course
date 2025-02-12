package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {

    private static int i = -1;
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) {


        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r = () ->{
            lock.lock();
            lock.lock();
            String name = Thread.currentThread().getName();
            i++;
            System.out.println(name + " lendo e incrementando " + i);

            //flexibilidade
            AuxiliarLock.unlock(lock, name);
            lock.unlock();
        };

        for (int j = 0; j < 6; j++) {

            executor.execute(r);
        }

        executor.shutdown();

    }
}
