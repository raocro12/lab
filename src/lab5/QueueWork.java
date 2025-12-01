package lab5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueWork {
    public static <T> Queue<T> reverse(List<T> a){
        Queue<T> L1 = new LinkedList<T>(a);
        Queue<T> L2 = new LinkedList<>();

        while (!L1.isEmpty()) {
            int size = L1.size();

            for (int i = 0; i < size - 1; i++) {
                L1.add(L1.remove());
            }

            L2.add(L1.remove());
        }
        return L2;
    }
}
