package thread;

import thread.MeuRunnable;

public class Threads_1 {
    public static void main(String[] args) {
        //thread atual
        String name = Thread.currentThread().getName();
        System.out.println(name);

        Thread newThread = new Thread(new MeuRunnable());
//        newThread.run(); //utiliza a thread atual

        //e assim temos duas linhas de execução separadas

        Thread thread3 = new Thread(()
        -> System.out.println(Thread.currentThread().getName()));
        //thread3.start(); // nao pode iniciar duas vezes a mesma thread, devido ao seu controle interno
        Thread thread4 = new Thread(()
                -> System.out.println(Thread.currentThread().getName()));


        //a ordem de execucao de threads nao é garantida
        //o processador que escolhe a ordem
        newThread.start();
        thread3.start();
        thread4.start();



    }
}
