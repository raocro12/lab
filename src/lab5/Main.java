package lab5;

import lab1.InputChecker;
import lab5.task1.FractionCached;
import lab5.task2.Cat;
import lab5.task2.Funs;
import lab5.task2.Meowable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
                    FractionCached f1 = readFraction(sc);
                    System.out.println("Первая дробь: " + f1 + ", вещественное значение: " + f1.toDouble());

                    FractionCached f2 = readFraction(sc);
                    System.out.println("Вторая дробь: " + f2 + ", вещественное значение: " + f2.toDouble());

                    f2.setNumerator(InputChecker.readInt(sc, "Введите новый числитель для второй дроби:"));
                    System.out.println("Вещественное значение второй дроби: " + f2.toDouble());
                    System.out.println();
                    break;

                case 2:
                    Cat vasya = new Cat("Вася");
                    Meowable countMeowVasya = new Meowable(vasya);
                    Funs.meowsCare(countMeowVasya);
                    System.out.println("Кот " + countMeowVasya.getCat().getName() + " мяукнул " + countMeowVasya.getCount() + " раз.");
                    System.out.println();
                    break;

                case 3:
                    ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 5, 7, 10));
                    ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 4, 6, 7, 8));
                    List<Integer> r1 = WorkWithList.difference(l1, l2);
                    System.out.println("Исходный L1: " + l1);
                    System.out.println("Исходный L2: " + l2);
                    System.out.println("Результат (L1 - L2): " + r1);

                    ArrayList<String> l3 = new ArrayList<>(Arrays.asList("a", "asdf", "34", "34", "ef", "dv"));
                    ArrayList<String> l4 = new ArrayList<>(Arrays.asList("a", "b", "c"));
                    List<String> r2 = WorkWithList.difference(l3, l4);
                    System.out.println("Исходный L3: " + l3);
                    System.out.println("Исходный L4: " + l4);
                    System.out.println("Результат (L3 - L4): " + r2);

                    ArrayList<Object> l5 = new ArrayList<>();
                    l5.add(2);
                    l5.add("sfjhsfd");
                    Cat vasya3 = new Cat("Вася");
                    l5.add(vasya3);
                    l5.add(new Cat("Мурзмк"));
                    l5.add(new FractionCached(2, 4));
                    l5.add(new FractionCached(-2, 4));

                    ArrayList<Object> l6 = new ArrayList<>();
                    l6.add(vasya3);
                    l6.add(new Cat("Коля"));
                    l6.add(new FractionCached(2, 4));

                    List<Object> r3 = WorkWithList.difference(l5, l6);
                    System.out.println("Исходный L5: " + l5);
                    System.out.println("Исходный L6: " + l6);
                    System.out.println("Результат (L5 - L6): " + r3);
                    System.out.println();
                    break;

                case 4:
                    Map<Integer, List<Integer>> multiValueMap = new HashMap<>();

                    try (BufferedReader br = new BufferedReader(new FileReader("src/lab5/otchet.txt"))) {
                        int n = Integer.parseInt(br.readLine());
                        String line;
                        int totalSum = 0;
                        for (int i = 0; i < n; i++) {
                            line = br.readLine();
                            String[] p = line.split(" ");
//                            String famil = p[0];
//                            String name = p[1];
                            int school = Integer.parseInt(p[2]);
                            int bal = Integer.parseInt(p[3]);

                            multiValueMap.computeIfAbsent(school, k -> new ArrayList<>()).add(bal);
                            totalSum += bal;
                        }

                        double srednee = (double) totalSum / n;

                        ArrayList<Integer> res = new ArrayList<>();
                        for (Map.Entry<Integer, List<Integer>> entry : multiValueMap.entrySet()) {
                            ArrayList<Integer> values = (ArrayList<Integer>) entry.getValue();
                            System.out.println(values);
                            int summ = 0;
                            for (int val : values) {
                                summ += val;
                            }
                            double sredneeInSchool = (double) summ / values.size();
                            System.out.println(sredneeInSchool);
                            if (sredneeInSchool > srednee) {
                                res.add(entry.getKey());
                            }
                        }
                        System.out.println("Школы, где средний балл больше чем в районе: " + res);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 5:
                    String text = Files.readString(Paths.get("src/lab5/text.txt")).toLowerCase();

                    // Разбиваем текст на слова, игнорируя знаки препинания
                    String[] words = text.split("\\W+");


                    break;

                default:
                    System.out.println("Введите правильную цифру!");
            }
        } while (userChoice != 0);

    }

    private static FractionCached readFraction(Scanner sc) {
        while (true) {
            try {
                int num = InputChecker.readInt(sc, "Введите числитель");
                int den = InputChecker.readPositiveInteger(sc, "Введите знаменатель");
                return new FractionCached(num, den); // если все корректно — возвращаем объект
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте снова.");
            }
        }
    }

}
