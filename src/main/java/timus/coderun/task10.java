package timus.coderun;

import java.io.*;

public class task10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int nod = nod(a,b);
        long nok;
        if(a == 0||b == 0){
            nok = 0;
        } else {
            nok = Math.abs(((long)a * (long)b) / (long)nod);
        }
        writer.write(nod + " " + nok);
        /*


Алгоритм:

    Делим большее число на меньшее.

    Если есть остаток, заменяем большее число на остаток.

    Повторяем процесс, пока остаток не станет 0.

    Последний ненулевой остаток — это НОД.
        */

        reader.close();
        writer.close();
    }
    private static int nod(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
