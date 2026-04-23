package timus;



import java.util.Scanner;


public class task1263 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // число кандидатов
        int M = scanner.nextInt(); // число избирателей

        int[] votes = new int[N + 1]; // индекс от 1 до N

        // Подсчитываем голоса
        for (int i = 0; i < M; i++) {
            int candidate = scanner.nextInt();
            if (candidate >= 1 && candidate <= N) {
                votes[candidate]++;
            }
        }

        // Выводим проценты для каждого кандидата
        for (int i = 1; i <= N; i++) {
            double percentage = (double) votes[i] / M * 100;
            System.out.printf("%.2f%%\n", percentage);
        }

        scanner.close();
    }
}