package timus.coderun;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task14 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        List<Integer> nums = new ArrayList<>();
        for(String num : line){
            nums.add(Integer.parseInt(num));
        }

        Collections.sort(nums);

        String result;

        var max1 = nums.getLast();
        var max2 = nums.get(nums.size() -2);
        var max3 = nums.get(nums.size() -3);

        var min1 = nums.get(0);
        var min2 = nums.get(1);

        if((long)max1 * max2 * max3 > (long)min1 *min2 * max1){
            result = max1 + " " + max2 + " " + max3;
        } else {
            result = min1 + " " + min2 + " " + max1;
        }

        writer.write(String.valueOf(result));
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}
