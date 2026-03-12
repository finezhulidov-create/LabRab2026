package lr9.ex9;


import java.util.*;

public class PerformanceTest {
    private static final int N = 9_000_000;
    private static final Random random = new Random(42); // для предсказуемых значений

    public static void main(String[] args) {
        System.out.println("Инициализация тестовых данных...");

        // Подготовим данные для вставки
        List<Integer> data = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            data.add(random.nextInt());
        }

        // Тесты
        testAddToFront(new ArrayList<>(), "ArrayList - add to front", data);
        testAddToFront(new ArrayDeque<>(), "ArrayDeque - add to front", data);
        System.out.println("Добавить в начало в сете невозможно");

//        testAddToBack(new ArrayList<>(), "ArrayList - add to back", data);
//        testAddToBack(new ArrayDeque<>(), "ArrayDeque - add to back", data);
//        System.out.println("Добавить в конец в сете невозможно");
//
//        testAddToMiddle(new ArrayList<>(), "ArrayList - add to middle", data);
//        System.out.println("Добавить в середину в деке невозможно");
//        System.out.println("Добавить в середину в сете невозможно");
//
//        // Создадим заполненные коллекции для удаления и get()
//        ArrayList<Integer> arrayList = new ArrayList<>(data);
//        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(data);
//        TreeSet<Integer> treeSet = new TreeSet<>(data);
//
//        testRemoveFromFront(new ArrayList<>(arrayList), "ArrayList - remove from front");
//        testRemoveFromFront(new ArrayDeque<>(arrayDeque), "ArrayDeque - remove from front");
//        testRemoveFromFront(new TreeSet<>(treeSet), "TreeSet - remove from front");
//
//        testRemoveFromBack(new ArrayList<>(arrayList), "ArrayList - remove from back");
//        testRemoveFromBack(new ArrayDeque<>(arrayDeque), "ArrayDeque - remove from back");
//        testRemoveFromBack(new TreeSet<>(treeSet), "TreeSet - remove from back");
//
//        testRemoveFromMiddle(new ArrayList<>(arrayList), "ArrayList - remove from middle");
//        System.out.println("Удалить из  середины в деке невозможно");
//        System.out.println("Удалить из середины в сете невозможно");
//
//        testGetByIndex(new ArrayList<>(arrayList), "ArrayList - get by index");
//        // ArrayDeque и TreeSet не поддерживают get(index) напрямую
//        testGetByIndexForDeque(new ArrayDeque<>(arrayDeque), "ArrayDeque - get by index (via iterator)");
//        // TreeSet — пропустим, так как нет индексов
  }

    private static void testAddToFront(List<Integer> list, String label, List<Integer> data) {
        long start = System.nanoTime();
        for (Integer value : data) {
            list.addFirst( value);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static void testAddToFront(Deque<Integer> list, String label, List<Integer> data) {
        long start = System.nanoTime();
        for (Integer value : data) {
            list.addFirst(value);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }



    private static void testAddToBack(List<Integer> list, String label, List<Integer> data) {
        long start = System.nanoTime();
        for (Integer value : data) {
            list.add(value);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

 private static void testAddToBack(Deque<Integer> list, String label, List<Integer> data) {
        long start = System.nanoTime();
        for (Integer value : data) {
            list.add(value);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static void testAddToMiddle(List<Integer> list, String label, List<Integer> data) {
        long start = System.nanoTime();
        for (Integer value : data) {
            list.add(list.size() / 2, value);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static void testRemoveFromFront(List<Integer> list, String label) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(0);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }
    private static void testRemoveFromFront(Deque<Integer> list, String label) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.removeFirst();
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static void testRemoveFromFront(Set<Integer> list, String label) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
               Integer first = list.iterator().next();
               list.remove(first);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static void testRemoveFromBack(List<Integer> list, String label) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static void testRemoveFromBack(Deque<Integer> list, String label) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.removeLast();
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }
    private static void testRemoveFromBack(TreeSet<Integer> list, String label) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.pollLast();
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static void testRemoveFromMiddle(List<Integer> list, String label) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            int mid = list.size() / 2;
            if (mid < list.size()) {
                list.remove(mid);
            } else {
                list.remove(list.size() - 1);
            }
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static void testGetByIndex(ArrayList<Integer> list, String label) {
        long start = System.nanoTime();
        for (int i = 0; i < list.size(); i += 100_000) { // выборка каждого 100к-го
            list.get(i);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f мс\n", label, (end - start) / 1e6);
    }

    private static void testGetByIndexForDeque(ArrayDeque<Integer> deque, String label) {
        long start = System.nanoTime();
        for (int i = 0; i < N; i += 100_000) {
            getIndexFromDeque(deque, i);
        }
        long end = System.nanoTime();
        System.out.printf("%s: %.3f сек\n", label, (end - start) / 1e9);
    }

    private static Integer getIndexFromDeque(ArrayDeque<Integer> deque, int index) {
        if (index < deque.size() / 2) {
            Iterator<Integer> it = deque.iterator();
            for (int i = 0; i <= index; i++) {
                if (i == index) return it.next();
                it.next();
            }
        } else {
            Iterator<Integer> it = deque.descendingIterator();
            int fromEnd = deque.size() - 1 - index;
            for (int i = 0; i <= fromEnd; i++) {
                if (i == fromEnd) return it.next();
                it.next();
            }
        }
        return null;
    }
}
