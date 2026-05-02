package lr13.ex2;

import java.util.*;

public class ex3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Byte> arr = new ArrayList<>();
            int sum = 0;
            System.out.println("Enter array: ");
            String str = sc.nextLine();
            String[] parts = str.split("\\s+");
            for (String b : parts) {
                try {
                    arr.add(Byte.parseByte(b));
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Недопустимое значение byte");
                }
            }
            for (Byte b : arr) {
                sum += b;
            }
            if (sum > 127 || sum < -128) {
                throw new ArithmeticException("сумма выходит за границы типа");
            }
            System.out.println(sum);
        } catch (InputMismatchException e) {
            System.err.println("Введена строка вместо числа");
        } catch (ArithmeticException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }
}
