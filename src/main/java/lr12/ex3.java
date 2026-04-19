package lr12;

import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

//Напишите программу, которая создает два потока, которые выводят
// на экран числа от 1 до 10. Первый поток должен выводить только четные числа,
// а второй поток должен выводить только нечетные числа
public class ex3 {
    private static final Object lock = new Object();
    private static  int num = 1;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            synchronized (lock){
                while (num < 10){
                    if (num % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + " " + num);
                        num++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    lock.notifyAll();
                }

            }
        });

        Thread t2 = new Thread(()-> {
            synchronized (lock){
                while (num < 10){
                    if (num % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + " " + num);
                        num++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    lock.notifyAll();
                }

            }
        });
        t1.setName("FirstThread: ");
        t2.setName("Second Thread: ");

        t1.start();
        t2.start();

    }
}
