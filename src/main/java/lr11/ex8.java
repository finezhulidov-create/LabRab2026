package lr11;

import java.util.Arrays;
import java.util.List;

//8.	Напишите функцию, которая принимает на вход список целых
// чисел и возвращает новый список, содержащий только те числа,
// которые больше заданного значения
public class ex8 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 6, 77, 8859, 11, 21);
        int n = 41;
        ex8 ex = new ex8();
        System.out.println(ex.func(nums, n));
    }

    private List<Integer> func(List<Integer> nums, int n) {
        return nums.stream()
                .filter(i -> i > n)
                .toList();
    }
}
