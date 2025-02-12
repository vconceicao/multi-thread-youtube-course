package executors;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorsMultiThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = null;
        try {

//             executor = Executors.newFixedThreadPool(1);
//             executor = Executors.newFixedThreadPool(1);
             executor = Executors.newCachedThreadPool();

            Tarefa task = new Tarefa();
            Tarefa task2 = new Tarefa();
            Tarefa task3 = new Tarefa();
            Tarefa task4 = new Tarefa();

            List<Future<String>> futures = executor.invokeAll(List.of(task, task2, task3, task4));

            for (Future<String> future : futures) {
                System.out.println(future.get());
            }


//            Future<String> f1 = executor.submit(new Tarefa());
//            System.out.println(f1.get());
//            Future<String> f2 = executor.submit(new Tarefa());
//            Future<String> f3 = executor.submit(new Tarefa());
//            System.out.println(f2.get());
//            System.out.println(f3.get());

            executor.shutdown();
        } catch (Exception e) {
            throw  e;
        }finally {

            if (executor != null) {

                executor.shutdownNow();
            }
        }

    }



    public static class Tarefa implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            String name = Thread.currentThread().getName();
            return name + ": Inscreva-se no canal " + new Random().nextInt(1000);

        }
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": Inscreva-se no canal");
        }
    }
}
