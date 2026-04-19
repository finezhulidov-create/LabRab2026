package lr11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//4.	Напишите функцию, которая принимает на вход список чисел и
// возвращает новый список, содержащий квадраты этих чисел.
public class ex4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,5,65,78,44);
        ex4 ex = new ex4();
        System.out.println(ex.func(list));
    }

    public List<Integer> func(List<Integer> nums){
        return nums.stream()
                .map(x -> x*x)
                .collect(Collectors.toList());
    }
}
