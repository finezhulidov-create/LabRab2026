package lr12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Напишите функцию, которая суммирует элементы в массиве целых чисел при
// помощи многопоточности. Количество потоков должно быть равно количеству
// ядер процессора
public class ex6 {
    private final int numThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }
        ex6 ex = new ex6();
        try {
            Integer sum = ex.arrSum(arr);
            System.out.println(sum);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Integer arrSum(int[] arr) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Future<Integer>[] futures = new Future[numThreads];

        int arrLength = arr.length;
        int size = (arrLength + numThreads - 1)/ numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * size;
            int end = Math.min(start + size, arrLength);

            if (start >= arrLength) break;

            final int taskStart = start;
            final int taskEnd = end;

            futures[i] = executor.submit(()->{
                int localSum = 0;
                for (int j = taskStart; j < taskEnd; j++) {
                    localSum += arr[j];
                }
                return localSum;
            });
        }
        int globalSum = 0;
        for (int i = 0; i < numThreads; i++) {
            if (futures[i] != null){
                globalSum += futures[i].get();
            }
        }
        executor.shutdown();
        return globalSum;
    }

}
