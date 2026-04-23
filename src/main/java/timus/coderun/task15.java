package timus.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*15. Определить вид последовательности
Не решалась
Лёгкая

По последовательности чисел во входных данных определите ее вид:

    CONSTANT — последовательность состоит из одинаковых значений

    ASCENDING — последовательность является строго возрастающей

    WEAKLY ASCENDING — последовательность является нестрого возрастающей

    DESCENDING — последовательность является строго убывающей

    WEAKLY DESCENDING — последовательность является нестрого убывающей

    RANDOM — последовательность не принадлежит ни к одному из вышеупомянутых типов

Формат ввода

По одному на строке поступают числа последовательности a i , ∣ a i ∣ ≤ 1 0 9 ai​,∣ai​∣≤109.

Признаком окончания последовательности является число − 2 × 1 0 9 −2×109. Оно в последовательность не входит.
Формат вывода

В единственной строке выведите тип последовательности.*/
public class task15 {
    private static SecuenceType type = SecuenceType.CONSTANT;
    private static boolean asc = false;
    private static boolean desc = false;
    private static boolean equal = false;
    private static final int STOP = -2000000000;
    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            if(n == STOP) return;
            int next = Integer.parseInt(reader.readLine());
            while (next != STOP){
                if (next == n) equal = true;
                if (next > n) asc = true;
                if (next < n) desc = true;
                n = next;
                next = Integer.parseInt(reader.readLine());
            }
            if (desc && asc) type = SecuenceType.RANDOM;
            else if (!desc && asc && !equal) type = SecuenceType.ASCENDING;
            else if (!desc && asc) type = SecuenceType.WEAKLY_ASCENDING;
            else if (desc && !equal) type = SecuenceType.DESCENDING;
            else if(desc) type = SecuenceType.WEAKLY_DESCENDING;
            System.out.println(type.getName());
        }
    }
    enum SecuenceType{
        CONSTANT("CONSTANT"),
        ASCENDING("ASCENDING"),
        WEAKLY_ASCENDING("WEAKLY ASCENDING"),
        DESCENDING("DESCENDING"),
        WEAKLY_DESCENDING("WEAKLY DESCENDING"),
        RANDOM("RANDOM");

        private String name;

        SecuenceType(String random) {
            this.name = random;
        }

        public String getName() {
            return name;
        }
    }
}
