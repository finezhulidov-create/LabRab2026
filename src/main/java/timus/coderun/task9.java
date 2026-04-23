package timus.coderun;

import java.io.*;

public class task9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[m][k];
        for(int i = 0; i < n; i++){
            String[] row = reader.readLine().split(" ");
            for(int j = 0; j < m; j++){
                matrixA[i][j] = Integer.parseInt(row[j]);
            }
        }

        for(int i = 0; i < m; i++){
            String[] row = reader.readLine().split(" ");
            for(int j = 0; j < k; j++){
                matrixB[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[][] matrixC = new int[n][k];

        for (int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                for(int x = 0; x < m; x++){
                    matrixC[i][j] += matrixA[i][x] * matrixB[x][j];
                }
            }
        }

        int[][] matrixCT = new int[k][n];

        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                matrixCT[i][j] = matrixC[j][i];
            }
        }

        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                writer.write(matrixCT[i][j] + " ");

            }
            if(i < k - 1){
                writer.newLine();
            }
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
