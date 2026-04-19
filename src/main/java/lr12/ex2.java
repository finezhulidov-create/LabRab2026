package lr12;
//Напишите программу, которая запускает поток и выводит на экран
// числа от 1 до 10 с задержкой в 1 секунду между выводами.
public class ex2 {
    public static void main(String[] args) {
        Thread tr = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tr.start();
    }
}
