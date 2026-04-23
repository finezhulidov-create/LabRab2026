package timus.coderun;

import java.io.*;

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] arr = new long[3];
        for(int i=0;i<3;i++){
            arr[i] = Long.parseLong(reader.readLine());
        }

        writer.write(arr[0]+arr[1]>arr[2] && arr[1]+arr[2]>arr[0] && arr[0]+arr[2]>arr[1] ? "YES" : "NO");
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}
