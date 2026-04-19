package lr11;

import java.util.Arrays;
import java.util.List;

//9.	Напишите функцию, которая принимает на вход список строк и возвращает
// новый список, содержащий только те строки, которые
// содержат только буквы (без цифр и символов)
public class ex9 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java1");
        ex9 ex = new ex9();
        System.out.println(ex.func(words));
    }

    private List<String> func(List<String> words) {
        return words.stream()
                .filter(str -> str.chars().allMatch(Character::isLetter))
                .toList();
    }
}
