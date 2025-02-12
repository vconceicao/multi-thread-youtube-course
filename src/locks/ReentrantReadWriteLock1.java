package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReentrantReadWriteLock1 {

    private static int i = -1;
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public static void main(String[] args) {


        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r = () ->{

            Lock lock = readWriteLock.writeLock();

            lock.lock();
            String name = Thread.currentThread().getName();
            i++;
            System.out.println(name + " lendo e incrementando " + i);

            //flexibilidade
            lock.unlock();
        };

        Runnable r2 = () -> {

            Lock readLock = readWriteLock.readLock();
            readLock.lock();
            String name = Thread.currentThread().getName();
            System.out.println(name + "Lendo valor  de i "+ i);
            System.out.println(name + " valor  de i  lido");
            readLock.unlock();
        };

        for (int j = 0; j < 6; j++) {

            executor.execute(r);
            executor.execute(r2);
        }

        executor.shutdown();

    }
}
