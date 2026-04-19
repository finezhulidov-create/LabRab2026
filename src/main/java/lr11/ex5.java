package lr11;

import java.util.Arrays;
import java.util.List;

//5.	Напишите функцию, которая принимает на вход список строк
// и возвращает новый список, содержащий только те строки, которые
// содержат заданную подстроку.
public class ex5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java");
        String word = "ja";
        ex5 ex = new ex5();
        System.out.println(ex.func(words, word));
    }

    private List<String> func(List<String> words, String pred) {
        return words.stream()
                .filter(s -> s.contains(pred))
                .toList();
    }


}
