package lr13.ex2;

import java.util.*;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(5, 6, 7, 8));
        matrix.add(Arrays.asList(9, 10, 11, 12));
        matrix.add(Arrays.asList(13, 14, 15, 16));

        try {
            System.out.println("Введите номер столбца (от 1 до " + matrix.getFirst().size() + ")");
            int colNum = sc.nextInt() - 1;
            if (colNum < 0 || colNum >= matrix.getFirst().size()) {
                throw new IndexOutOfBoundsException("Номер столбца меньше 0, либо выходит за пределы массива");

            }
            System.out.println("Row " + (colNum + 1) + ":");
            for (List<Integer> list : matrix) {
                System.out.println(list.get(colNum));
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: " + e);
        } catch (InputMismatchException e){
            System.err.println("Должны быть введены только числа!" + e);
        }finally {
            sc.close();
        }
    }


}
