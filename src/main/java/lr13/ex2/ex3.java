package lr13.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        try {
            System.out.println("Enter arr length");
            int n = sc.nextInt();
            sc.nextLine();
            if (n <= 0) {
                throw new IllegalArgumentException("Длина массива не может быть равна или меньше нуля");
            }
            arr = new int[n];
            System.out.println("Enter arr");
            String str = sc.nextLine();
            String[] parts = str.split("\\s+");
            for (int i = 0; i < n; i++) {
                try {
                    arr[i] = Integer.parseInt(parts[i]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Не хватает чисел для заполнения, либо превышен лимит длины массива: " + n);
                } catch (NumberFormatException e) {
                    System.out.println("Введено не корректное число, ожидаются только целые числа");
                }
            }
            double result = avg(arr);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка ввода длины массива: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Ошибка вычисления: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
            System.out.println("Работа программы завершена.");
        }
    }

    public static double avg(int[] arr) throws  ArithmeticException{
        List<Integer> arrPositive = new ArrayList<>();
        int sum = 0;
        for (int j : arr) {
            if (j > 0) {
                arrPositive.add(j);
                sum += j;
            }
        }
        int count = arrPositive.size();
        if (count == 0){
            throw new ArithmeticException("Все числа отрицательные");
        }
        return (double) sum / count;
    }
}
