package executors;

import java.util.Random;
import java.util.concurrent.*;

public class ExecutorsSingleThreadCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = null;

        try {

             executorService = Executors.newSingleThreadExecutor();

            //outra forma pedir algo ao executor
            Future<String> future = executorService.submit(new Tarefa());
            System.out.println(future.isDone());
            //e sempre bom colocar um timeout em producao
            System.out.println(future.get(1, TimeUnit.SECONDS)); //termina a tarefa automaticamente, nao precisa de shutdown
//            executorService.shutdown();
//            executorService.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println(future.isDone());
        } catch (Exception e) {
            throw e;
        }finally {

            //precisa de um método para fechar o executor
//            executorService.shutdown();
//            if (executorService != null) {
//                //fechar de forma abrupta
//                executorService.shutdownNow();
//                executorService.close();
//
//            }
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
}

