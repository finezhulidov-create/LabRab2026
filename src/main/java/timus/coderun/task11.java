package timus.coderun;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class task11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Map<String, String> map = new HashMap<>();

        for (int i=0; i < n ; i++){
            String[] parts = reader.readLine().split(" ");
            String a = parts[0];
            String b = parts[1];
            map.put(a, b);
            map.put(b, a);
        }
        String word = reader.readLine();
        writer.write(map.get(word));


        reader.close();
        writer.close();
    }
}
