package executors;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorScheduled {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        //ScheduledFuture<String> schedule = scheduledExecutorService.schedule(new Tarefa(), 2, TimeUnit.SECONDS);


        Task task = new Task();
        scheduledExecutorService.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);

//        System.out.println(schedule.get());
//        scheduledExecutorService.shutdown();
    }


    public static class Tarefa implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println();
            Thread.sleep(2000);


            String name = Thread.currentThread().getName();
            return name + ": Inscreva-se no canal " + new Random().nextInt(1000);

        }
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String name = Thread.currentThread().getName();
            System.out.println(name + ": Inscreva-se no canal");
            System.out.println(LocalDateTime.now() + " Fim");
        }
    }
}
