package timus.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task8 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");

        int a = Integer.parseInt(line[0]);

        for (int i = 1; i < line.length; i++) {
            int b = Integer.parseInt(line[i]);
            if (b <= a) {
                System.out.println("NO");
                return;
            }
            a=b;

        }
        System.out.println("YES");


        reader.close();

    }
}
