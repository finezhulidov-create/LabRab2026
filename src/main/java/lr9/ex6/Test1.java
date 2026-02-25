package lr9.ex6;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/*. Заполнить HashMap 10 объектами <Integer, String>.
Найти строки у которых ключ> 5. Если ключ = 0, вывести строки через запятую.
Перемножить все ключи, где длина строки>5.*/
public class Test1 {
    public static void main(String[] args) {

            Map<Integer, String> map = new HashMap<>();
            map.put(0, "hh");
            map.put(1, "hhelo");
            map.put(2, "hheello");
            map.put(3, "hehlo77868");
            map.put(4, "heeeh4444");
            map.put(5, "httth44444");
            map.put(6, "hhuu444");
            map.put(7, "hhe444de");
            map.put(8, "hw4444h");
            map.put(9, "htйвеееееh");

            map.entrySet()
                    .stream()
                    .filter(entry -> entry.getKey() > 5)
                    .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        String stringKeyzero = map.entrySet()
                    .stream()
                    .filter(entry -> entry.getKey() == 0)
                    .map(Map.Entry::getValue)
                    .collect(Collectors.joining(", "));

        System.out.println(stringKeyzero);

        long prodOfKeys = map.entrySet().stream()
                .filter(entry -> entry.getValue().length() > 5)
                .mapToLong(Map.Entry::getKey)
                .reduce(1,(a,b) -> a * b);
        System.out.println(prodOfKeys);
    }
}
