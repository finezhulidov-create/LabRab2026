package timus.coderun;

import java.io.*;

public class task3 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){

            String[] input = reader.readLine().split(" ");
            long count = 0;

            if (input.length<3){
                writer.write(String.valueOf(count));
                return;
            }

            for(int i=1;i<input.length-1;i++){
                if(Long.parseLong(input[i])>Long.parseLong(input[i-1])
                        && Long.parseLong(input[i])>Long.parseLong(input[i+1])) {
                    count++;
                }
            }
            writer.write(String.valueOf(count));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */


    }
}
