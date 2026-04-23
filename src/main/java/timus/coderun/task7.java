package timus.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        var result = reader.lines()
                .flatMap(line -> Arrays.stream(line.trim().split("\\s+")))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toSet())
                .size();


        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        System.out.println(result);
    }
}
