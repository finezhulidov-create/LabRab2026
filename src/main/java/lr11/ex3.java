package lr11;

import java.util.Arrays;
import java.util.List;

//3.	Напишите функцию, которая принимает на вход список строк
// и возвращает новый список, содержащий только те строки,
// которые начинаются с большой буквы.
public class ex3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "world", "Java");
        ex3 ex = new ex3();
        System.out.println(ex.func(words));
    }
    public List<String> func(List<String> str){
        return str.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .toList();
    }
}
