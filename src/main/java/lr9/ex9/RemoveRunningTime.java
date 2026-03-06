package lr9.ex9;

import java.util.*;

public class RemoveRunningTime implements RunningTime{
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        RunningTime at = new RemoveRunningTime();
        add(deque);
       // add(list);
       // add(set);
       System.out.println("remove time arrayDeque: " + at.getRunningTime(deque));
        // System.out.println("remove time arrayList: " + at.getRunningTime(list));
      // System.out.println("remove time treeSet: " + at.getRunningTime(set));
    }
    @Override
    public long getRunningTime(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            deque.removeLast();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    @Override
    public long getRunningTime(List<Integer> list) {
        long start = System.currentTimeMillis();
        while (!list.isEmpty()){
            list.removeLast();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    @Override
    public long getRunningTime(Set<Integer> set) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            set.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static void add(Deque<Integer> deque){
        for (int i = 0; i < 9000000; i++) {
            deque.add(i);
        }
    }
    private static void add(List<Integer> list){
        for (int i = 0; i < 9000000; i++) {
            list.add(i);
        }
    }
    private static void add(Set<Integer> set){
        for (int i = 0; i < 9000000; i++) {
            set.add(i);
        }
    }
}
