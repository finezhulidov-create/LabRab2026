package timus.coderun;

import java.io.*;

public class task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=  Integer.parseInt(reader.readLine());
        long[] arr = new long[35];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < n; i++ ){
            arr[i] = arr[i-1]+arr[i-2];
        }
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        writer.write(String.valueOf(sum));
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}
