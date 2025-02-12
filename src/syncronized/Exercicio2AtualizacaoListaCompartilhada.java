package syncronized;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercicio2AtualizacaoListaCompartilhada {

    private static final List<String> lista = new CopyOnWriteArrayList<>();
    private static final AtomicInteger produtoresAtivos = new AtomicInteger(5); // Número de threads produtoras


    public static void main(String[] args) throws InterruptedException {

        MeuRunnable meuRunnable = new MeuRunnable();





        Thread thread1 = new Thread(meuRunnable);
        Thread thread2 = new Thread(meuRunnable);
        Thread thread3 = new Thread(meuRunnable);
        Thread thread4 = new Thread(meuRunnable);
        Thread thread5 = new Thread(meuRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

       var leitor =  new Thread(() -> {

           while (produtoresAtivos.get() > 0) { // Verifica se ainda há produtores ativos
                System.out.println("Estado atual da lista: "+ lista);
                System.out.println("Tamanho atual da lista: "+ lista.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

       leitor.start();


        // Aguarda o término das threads produtoras
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        // Aguarda a thread leitora finalizar
        leitor.join();

        System.out.println("Lista final: " + lista);
        System.out.println("Execução finalizada! " + lista.size());

    }


    public static class MeuRunnable implements Runnable{


        @Override
        public void run() {
            try{
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                lista.add(i+"-"+name);
            }
            }finally {
                produtoresAtivos.decrementAndGet();

            }
        }
    }

}
