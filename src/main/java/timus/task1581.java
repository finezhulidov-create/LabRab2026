package timus;

import java.util.Arrays;
import java.util.Scanner;

public class task1581 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        for (int i = 0; i < num; ) {
            int count = 1;
            int current = nums[i];

            while (i + count < num && nums[i + count]  == current){
                count++;
            }
            System.out.print(count + " " + current + " ");
            i+= count;
        }
        System.out.println();
    }

}
