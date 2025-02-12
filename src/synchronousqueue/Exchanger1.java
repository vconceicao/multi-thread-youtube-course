package synchronousqueue;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exchanger1 {

    private static final Exchanger<String> EXCHANGER = new Exchanger<>();
    public static void main(String[] args) {


        ExecutorService executors = Executors.newCachedThreadPool();


        Runnable r1 = () -> {
            String name = Thread.currentThread().getName();
            String msg = "Toma LÁ!";
            System.out.println(name + " trocando mensagem " + msg);
            String retorno = exchange(msg);
            System.out.println(name + "recebeu mensagem " + retorno);
        };

        Runnable r2 = () -> {

            String name = Thread.currentThread().getName();

            String msg = "Da CÁ!";
            System.out.println(name + " trocando mensagem " + msg);
            String retorno = exchange(msg);
            System.out.println(name + "recebeu mensagem " + retorno);
        };

        executors.execute(r1);
        executors.execute(r2);

    }

    private static String exchange(String msg) {

        try {
            return EXCHANGER.exchange(msg);
        } catch (InterruptedException e) {
           e.printStackTrace();
            return "EXCECAO";
        }
    }
}
