package lr11;

import java.util.Arrays;
import java.util.List;

//6.	Напишите функцию, которая принимает на вход список целых чисел
// и возвращает новый список, содержащий только те числа, которые делятся
// на заданное число без остатка
public class ex6 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 3458, 88,90, 55, 24);
        Integer n = 4;
        ex6 ex = new ex6();
        System.out.println(ex.func(nums, n));
    }

    private List<Integer> func(List<Integer> nums, Integer n) {
        return nums.stream()
                .filter(x -> x % n == 0)
                .toList();
    }


}
