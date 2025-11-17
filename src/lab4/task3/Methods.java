package lab4.task3;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    public static <T, P> List<P> method1(List<T> list, MyFanction<T, P> func) {

        List<P> result = new ArrayList<>();
        for (T element : list) {
            result.add(func.apply(element));
        }
        return result;
    }

    public static <T> List<T> method2(List<T> list, MyFilter<T> filter) {

        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (filter.test(element)) { //если удовлетворяет условиям
                result.add(element);
            }
        }
        return result;
    }

    public static <T> T method3(List<T> list, MyCombiner<T> combiner){
        return combiner.combine(list);
    }

    public static <T,P> P collect(
            List<T> list,
            Supplier<P> supplier,
            BiConsumer<P,T> accumulator) {

        P result = supplier.get();

        for (T element : list) {
            accumulator.accept(result, element);
        }
        return result;
    }

}