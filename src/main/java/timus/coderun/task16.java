package timus.coderun;

import java.io.*;

public class task16 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        try(reader; writer){
            long two = Long.parseLong(reader.readLine());
            long three = Long.parseLong(reader.readLine());
            long four = Long.parseLong(reader.readLine());
            writer.write(String.valueOf(calcFive(two, three, four)));
        }
    }

    private static long calcFive(long two, long three, long four) {
        long left = 0;
        long count = two + three + four;
        long right = count;
        long sum = 2 * two + 3 * three + 4 * four;


        while (left < right){
            long mid = left + (right - left) / 2;
            if (2* (sum + 5 * mid) >= 7* (count + mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
