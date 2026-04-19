package lr12;

import java.time.LocalDateTime;

//Напишите программу, которая запускает два потока и выводит на экран их
// имена и текущее время в течение 10 секунд.
public class ex1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
