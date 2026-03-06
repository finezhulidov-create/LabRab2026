package lr9.ex9;

import java.util.Deque;
import java.util.List;
import java.util.Set;

public interface RunningTime {
    long getRunningTime(Deque<Integer> deque);
    long getRunningTime(List<Integer> list);
    long getRunningTime(Set<Integer> set);
}
