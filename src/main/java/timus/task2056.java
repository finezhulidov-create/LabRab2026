package timus;



import java.util.Scanner;

public class task2056 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean hasThrees = false;
        boolean hasFours = false;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int mark = scanner.nextInt();
            if (mark == 3) {
                hasThrees = true;
            }
            if (mark == 4) {
                hasFours = true;
            }
            sum += mark;
        }

        // Если есть тройки — стипендии нет
        if (hasThrees) {
            System.out.println("None");
            return;
        }

        // Если все оценки — пятёрки → именная стипендия
        if (!hasFours && !hasThrees) { // значит, все — пятёрки
            System.out.println("Named");
            return;
        }

        // Считаем средний балл
        double average = (double) sum / n;

        // Если средний балл >= 4.5 → повышенная
        if (average >= 4.5) {
            System.out.println("High");
        } else {
            // Иначе — обычная (так как троек нет, раз дошли сюда)
            System.out.println("Common");
        }
    }
}
