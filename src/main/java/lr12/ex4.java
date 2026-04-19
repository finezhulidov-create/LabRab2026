package lr12;
//Напишите программу, которая создает 10 потоков и каждый поток выводит на экран свой номер.
public class ex4 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int trNumber = i;
            Thread tr = new Thread(() -> {
                System.out.println(Thread.currentThread().threadId() + " " + trNumber);
            });
            tr.start();
        }

    }
}
