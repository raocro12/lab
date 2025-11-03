package lab4.task3;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    public static <T, P> List<P> method1(List<T> list, MyFanction<T, P> func) {
        //Разработайте такой метод, который будет принимать список значений типа T, и объект имеющий
        //единственный метод apply. Данный метод надо применить к каждому элементу списка, и вернуть
        //новый список значений типа P, при этом типы T и P могут совпадать, а могут не совпадать.

        List<P> result = new ArrayList<>();
        for (T element : list) {
            result.add(func.apply(element));
        }
        return result;
    }

    public static <T> List<T> method2(List<T> list, MyFilter<T> filter) {
        //Разработайте такой метод, который будет принимать список значений типа T и объект имеющий
        //единственный метод test (принимает T и возвращает boolean). Верните новый список типа T, из
        //которого удалены все значения не прошедшие проверку условием.

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


}