package lab4.task3;

import java.util.List;

public interface MyCombiner<T> {
    T combine(List<T> list);
}
