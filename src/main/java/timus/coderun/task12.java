package timus.coderun;

import java.io.*;
import java.util.Arrays;

public class task12 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        int [] arr = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(reader.readLine());
        int result = arr[0];
        int mindiff = Math.abs(x - arr[0]);

        for(int i = 0; i < N; i++){
            int currDiff = Math.abs(x - arr[i]);
            if(currDiff < mindiff){
                mindiff = currDiff;
                result = arr[i];
            }
        }
        System.out.println(result);
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}
