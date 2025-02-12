package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsSingleThreadRunnable {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = null;

        try {

             executorService = Executors.newSingleThreadExecutor();
             // uma coisa boa do executor é que podemos pedir para uma thread executar
            //tarefas varias vezes
            executorService.execute(new Tarefa());
            executorService.execute(new Tarefa());
            executorService.execute(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            //outra forma pedir algo ao executor
            //Future<?> future = executorService.submit(new Tarefa());
            //System.out.println(future.isDone());
            executorService.shutdown();
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Todas as threads terminaram");
            } else {
                System.out.println("As thread nao terminaram");
            }
            //System.out.println(future.isDone());
        } catch (Exception e) {
            throw e;
        }finally {

            //precisa de um método para fechar o executor
//            executorService.shutdown();
            if (executorService != null) {
                //fechar de forma abrupta
                executorService.shutdownNow();

            }
        }

    }


    public static class Tarefa implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": Inscreva-se no canal");
        }
    }
}

