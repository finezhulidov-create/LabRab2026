package timus.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        String line = reader.readLine();
        Set<Integer> list = line.chars()
                .map(i -> Character.getNumericValue((char)i))
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        list.remove(a);
        list.remove(b);
        list.remove(c);

        System.out.println(list.size());



        reader.close();

    }
}
