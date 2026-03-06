package lr9.ex7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*В кругу стоят N человек, пронумерованных от 1 до N.
При ведении счета по кругу вычеркивается каждый второй человек,
пока не останется один. Составить две программы, моделирующие процесс.
Одна из программ должна использовать класс ArrayList,
а вторая — LinkedList. Какая из двух программ работает быстрее? Почему? */
// при входных данных 50000 ArrayList работает за 70 миллисекунд, LinkedList за 603 милисекунды
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter num of peoples");
        int n = scanner.nextInt();
        long time = System.currentTimeMillis();
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1){
            index = (index + 1) % list.size();
            list.remove(index);
        }
        System.out.println(list.getFirst());
        System.out.println(System.currentTimeMillis() - time);
    }
}
