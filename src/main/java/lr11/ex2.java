package lr11;

import java.util.Arrays;

//2.	Напишите функцию, которая принимает на вход два массива целых чисел
// и возвращает новый массив, содержащий только те элементы, которые есть в обоих массивах
public class ex2 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 8, 9};
        int[] numbers1 = {1, 4, 56, 81, 9};
        ex2 ex = new ex2();
        System.out.println(Arrays.toString(ex.func(numbers, numbers1)));
    }

    public int[] func(int[] arr1, int[] arr2){
        return Arrays.stream(arr1)
                .filter(x -> Arrays.stream(arr2)
                        .anyMatch(y -> y == x))
                .toArray();

    }
}
