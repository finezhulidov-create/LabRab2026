package lr11;

import java.util.Arrays;

//1.	Напишите функцию, которая принимает на вход массив целых чисел и
// возвращает новый массив, содержащий только четные числа из исходного массива.
public class ex1 {
    public static void main(String[] args) {
        int[] nums = {1,2,5,4,6,8,17,18};
        ex1 ex = new ex1();
        ex.func(nums);
        System.out.println(Arrays.toString(ex.func(nums)));

    }

    public int[] func(int[] nums){
     return    Arrays.stream(nums)
                .filter(n-> n%2 == 0)
                .toArray();
    }
}
