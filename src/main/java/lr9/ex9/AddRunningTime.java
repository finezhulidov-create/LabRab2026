package lr9.ex9;

import java.util.*;

public class AddRunningTime implements RunningTime{
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        AddRunningTime at = new AddRunningTime();
        System.out.println("add time arrayDeque: " + at.getRunningTime(deque));
        System.out.println("add time arrayList: " + at.getRunningTime(list));
        System.out.println("add time treeSet: " + at.getRunningTime(set));
    }

    @Override
    public  long getRunningTime(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            deque.add(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    @Override
    public long getRunningTime(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            list.add(i);

        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    @Override
    public long getRunningTime(Set<Integer> set) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            set.add(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }


}
