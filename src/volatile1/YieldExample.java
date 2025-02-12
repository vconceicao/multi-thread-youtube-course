package volatile1;

public class YieldExample {

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Thread A executando");
                Thread.yield();

            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Thread B executando");

            }
        });

        threadA.start();
        threadB.start();
    }
}
