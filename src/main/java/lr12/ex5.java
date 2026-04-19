package lr12;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Напишите функцию, которая находит максимальный элемент в массиве целых чисел
// при помощи многопоточности. Количество потоков должно быть равно количеству
// ядер процессора.
public class ex5 {
    private final int numThreads = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int [] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() *1000);
        }
        ex5 ex = new ex5();
        int max = ex.findMax(arr);
        System.out.println(max);

    }

    public int findMax(int[] arr) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Future<Integer>[] futures = new Future[numThreads];

        int length = arr.length;
        int size = (length + numThreads - 1) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * size;
            int end = Math.min(start + size, length);

            if (start >= length) break;
            final int taskStart = start;
            final int taskEnd = end;

            futures[i] = executor.submit(()-> {
                int localMax = Integer.MIN_VALUE;
                for (int j = taskStart; j < taskEnd ; j++) {
                    if (arr[j] > localMax){
                        localMax = arr[j];
                    }
                }
                return localMax;
            });
        }
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < numThreads; i++) {
            if (futures[i] != null){
                int candidate = futures[i].get();
                if (candidate > globalMax){
                    globalMax = candidate;
                }
            }
        }
        executor.shutdown();
        return globalMax;
    }

}
