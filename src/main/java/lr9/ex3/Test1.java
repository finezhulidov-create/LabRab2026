package lr9.ex3;

import java.util.Scanner;

public class Test1 {
    private static Scanner scanner = new Scanner(System.in);
    private static void printArr(int[] arr, int index){
        if (index >= arr.length){
            return;
        }
        System.out.print("[ " + arr[index] + " ," + "]");
        printArr(arr, index + 1);
    }
    private static void inputArr(int[] arr, int index){
        if (index >= arr.length){
            return;
        }
        System.out.print("Input elem [" + index + "]: ");
        arr[index] = scanner.nextInt();
        inputArr(arr, index + 1);
    }

    public static void main(String[] args) {
        System.out.println("array length");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Input elem");
        inputArr(array, 0);
        System.out.println("\nEntered Array ");
        printArr(array, 0);
        scanner.close();
    }
}
