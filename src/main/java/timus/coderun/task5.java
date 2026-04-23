package timus.coderun;

import java.io.*;

public class task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        double a = Integer.parseInt(line[0]);
        double b = Integer.parseInt(line[1]);
        double c = Integer.parseInt(line[2]);
        double D = b*b - 4*a*c;
        if(D < 0){
            writer.write("0");
        } else if (D == 0 ){
            double x1 = -b/(2*a);
            writer.write("1");
            writer.newLine();
            writer.write(String.format("%.6f", x1));
        } else {
            double x1 = (-b - Math.sqrt(D))/(2*a);
            double x2 = (-b+ Math.sqrt(D))/(2*a);
            writer.write("2");
            writer.newLine();
            writer.write(String.format("%.6f", x1 < x2 ? x1 : x2 ));
            writer.write(" ");
            writer.write(String.format("%.6f", x1 < x2 ? x2 : x1));
        }
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}
