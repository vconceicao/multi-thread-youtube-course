package locks;

import java.util.concurrent.locks.Lock;

public class AuxiliarLock {


    public static void unlock(Lock lock, String name) {
        System.out.println("Destravando " + name  );
        lock.unlock();
    }
}
