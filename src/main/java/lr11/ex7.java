package lr11;

import java.util.Arrays;
import java.util.List;

//7.	Напишите функцию, которая принимает на вход список строк и
// возвращает новый список, содержащий только те строки, которые имеют
// длину больше заданного значения
public class ex7 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "ff");
        int n = 3;
        ex7 ex = new ex7();
        System.out.println(ex.func(words, n));
    }

    private List<String> func(List<String> words, int n) {
        return words.stream()
                .filter(str -> str.length() > n)
                .toList();
    }
}
