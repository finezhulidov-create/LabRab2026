package timus.coderun;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class task13 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        var nums = new ArrayList<>(Arrays.stream(reader.readLine().split(" "))
                .map(n -> Integer.parseInt(n)).toList());
        var result = new ArrayList<Integer>(N * 2);

        for(int i = 0; i < N; i++){
            int x = nums.get(i);
            if(isPalindrome(nums)){
                break;
            } else {
                result.add(x);
                nums.add(nums.size() - i, x);
            }
        }
        writer.write(String.valueOf(result.size()));
        writer.newLine();
        Collections.reverse(result);
        writer.write(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));



        reader.close();
        writer.close();
    }
    private static boolean isPalindrome(List<Integer> list){
        int start = 0;
        int end = list.size() - 1;
        while(start <= end){
            if(!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
