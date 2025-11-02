package lab4;

import lab1.InputChecker;
import lab3.Figure.Point3D;
import lab4.task1.Student;
import lab4.task2.Box;
import lab4.task2.PointInBox;
import lab4.task3.Methods;
import lab4.task3.MyCombiner;
import lab4.task3.MyFanction;
import lab4.task3.MyFilter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println("1. Задание №1");
            System.out.println("2. Задание №2");
            System.out.println("3. Задание №3");
            System.out.println("0. Завершение программы");

            userChoice = InputChecker.readInt(sc, "Выбeрите действие: "); // вводим до тех пор, пока не будет правильный ответ

            switch (userChoice) {

                case 1:
                    Student vasya = new Student("Vasya");
                    vasya.inputGrades(sc);
                    System.out.println(vasya);
                    System.out.println("Средняя оценка: " + vasya.getAverage());

                    Student petya = new Student("Petya");
                    petya.inputGrades(sc);
                    System.out.println(petya);
                    System.out.println("Средняя оценка: " + petya.getAverage());

                    int a = vasya.compare(petya);
                    if (a == 1)
                        System.out.println("Средняя оценка больше у " + vasya.getName());
                    else if (a == 0)
                        System.out.println("Средние оценки одинаковы");
                    else
                        System.out.println("Средняя оценка больше у " + petya.getName());
                    break;

                case 2:
                    Box<Point3D> box = new Box<>();
                    PointInBox.putPoint(box);  //кладем точку в коробку
                    System.out.println(box);
                    break;

                case 3:
                    System.out.println("Первый пункт: ");
                    //Используйте разработанный метод следующим образом:
                    //1. Передайте в метод список со значениями:“qwerty”, “asdfg”, “zx”, а получите список чисел,
                    //где каждое число соответствует длине каждой строки.
                    List<String> strings1_1 = List.of("qwerty", "asdfg", "zx");
                    List<Integer> lengths = Methods.method1(strings1_1, new MyFanction<String, Integer>() {
                        @Override
                        public Integer apply(String s) {
                            return s.length();
                        }
                    });
                    System.out.println(lengths);

                    //2. Передайте в метод список со значениями: 1,-3,7, а получите список в котором все
                    //отрицательные числа стали положительными, а положительные остались без изменений
                    List<Integer> strings2_1 = List.of(1, -3, 7);
                    List<Integer> polog = Methods.method1(strings2_1, new MyFanction<Integer, Integer>() {
                        @Override
                        public Integer apply(Integer x) {
                            return x >= 0 ? (x) : (-x);
                        }
                    });
                    System.out.println(polog);

                    //3. Передайте в метод список состоящий из массивов целых чисел, а получите список в
                    //котором будут только максимальные значения каждого из исходных массивов
                    List<int[]> strings3_1 = List.of(new int[]{1, 2, 3}, new int[]{5, 7, 1}, new int[]{4, 3, 2});
                    List<Integer> maxes = Methods.method1(strings3_1, new MyFanction<int[], Integer>() {
                        @Override
                        public Integer apply(int[] arr) {
                            int max = arr[0];
                            for (int x : arr) {
                                if (x > max) {
                                    max = x;
                                }
                            }
                            return max;
                        }
                    });
                    System.out.println(maxes);

                    System.out.println("Второй пункт: ");
                    //Используйте разработанный метод следующим образом:
                    //1. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, и отфильтруйте все
                    //строки имеющие менее трех символов
                    List<String> strings1_2 = List.of("qwerty", "asdfg", "zx");
                    List<String> bolee3 = Methods.method2(strings1_2, new MyFilter<String>() {
                        @Override
                        public boolean test(String x) {
                            return x.length() >= 3;
                        }
                    });
                    System.out.println(bolee3);

                    //2. Передайте в метод список со значениями: 1,-3,7, и отфильтруйте все положительные
                    //элементы
                    List<Integer> strings2_2 = List.of(1, -3, 7);
                    List<Integer> pol = Methods.method2(strings2_2, new MyFilter<Integer>() {
                        @Override
                        public boolean test(Integer x) {
                            return x > 0;
                        }
                    });
                    System.out.println(pol);

                    //3. Передайте в метод список состоящий из массивов целых чисел, а получите список в
                    //котором будут только те массивы, в которых нет ни одного положительного элемента
                    List<int[]> strings3_2 = List.of(new int[]{-1, -2, -3}, new int[]{5, 7, -1}, new int[]{4, 3, 2});
                    List<int[]> otric = Methods.method2(strings3_2, new MyFilter<int[]>() {
                        @Override
                        public boolean test(int[] x) {
                            for (int i : x) {
                                if (i > 0)
                                    return false;
                            }
                            return true;
                        }
                    });
                    for (int[] arr : otric) {  //проход по массиву из массивов
                        System.out.println(Arrays.toString(arr));
                    }

                    System.out.println("Третий пункт: ");
                    //Используйте разработанный метод следующим образом:
                    //1. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, и сформируйте одну
                    //большую строку, которая состоит из всех строк исходного списка.
                    List<String> strings1_3 = List.of("qwerty", "asdfg", "zx");
                    String str = Methods.method3(strings1_3, new MyCombiner<String>() {
                        @Override
                        public String combine(List<String> list) {
                            if (list == null || list.isEmpty()) return "";
                            StringBuilder str = new StringBuilder();
                            for (String s : list) {
                                str.append(s);
                            }
                            return str.toString();
                        }
                    });
                    System.out.println(str);

                    //2. Передайте в метод список со значениями: 1,-3,7, и верните сумму всех значений исходного
                    //списка.
                    List<Integer> strings2_3 = List.of(1, -3, 7);
                    int summ = Methods.method3(strings2_3, new MyCombiner<Integer>() {
                        @Override
                        public Integer combine(List<Integer> list) {
                            if (list == null || list.isEmpty()) return 0;
                            int s = 0;
                            for (int i : list) {
                                s += i;
                            }
                            return s;
                        }
                    });
                    System.out.println(summ);

//                    //3. Имеется список, состоящий из списков целых чисел, получите общеe количество
//                    //элементов во всех списках. Подсказка: решить задачу можно в одно действие или
//                    //последовательно использовать методы из 3.3.1 и 3.3.3.
//                    List<int[]> strings3_3 = List.of(new int[]{-1, -2, -3}, new int[]{5, 7, -1}, new int[]{4, 3, 2});
//                    int obKol = Methods.method3(strings3_3, new MyCombiner<Integer>() {
                    break;

                default:
                    System.out.println("Введите правильную цифру!");
            }
        } while (userChoice != 0);


    }
}
