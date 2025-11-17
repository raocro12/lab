package lab5;

import java.util.ArrayList;
import java.util.List;

public class WorkWithList {
    static public <T> List<T> difference(List<T> a, List<T> b){
        List<T> result = new ArrayList<>();
        for (T x : a) {
            if (!b.contains(x) && !result.contains(x)) {
                result.add(x);
            }
        }
        return result;
    }
}
