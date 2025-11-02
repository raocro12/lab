package lab4.task1;

import lab1.InputChecker;

import java.util.Scanner;

public class Student extends lab2.Student implements MyComparable<Student> {

    private double average; //средняя оценка

    @Override
    public double getAverage() {
        return average;
    }

    public void setAverage() {
        int[] gr = getGrades();
        if (gr == null || gr.length == 0) {
            this.average = 0;
        } else {
            double avrg = 0;
            for (int grad : gr) {
                avrg += grad;
            }
            avrg /= gr.length;
            this.average = avrg;
        }
    }

    @Override
    public void setGrades(int[] grades) {
        super.setGrades(grades);
        setAverage();
    }

    public Student(String name, int... grades) {
        super(name, grades);
        setAverage();
    }

    public int compare(Student other) {
        // Если средняя оценка текущего студента больше, чем у того с которым выполняется
        //сравнение – возвращается 1.
        // Если средние оценки сравниваемых студентов одинаковы – возвращается 0.
        // Если средняя оценка текущего студента меньше, чем у того с которым выполняется
        //сравнение – возвращается -1
        if (other == null) {
            throw new NullPointerException("Student to compare is null");
        }
        //корректное сравнение чисел с плавающей точкой
        return Double.compare(this.average, other.average);  //возвращает 1, если первое больше второго
    }

    //метод для заполнения вручную оценок студента
    public void inputGrades(Scanner scanner){
        while (true) {  //бесконечный цикл ввода
            int[] grades = InputChecker.readArrIntNum(scanner);  //заполняем массив
            try {  //пытаемся присвоить значение
                setGrades(grades);  //внутри проходит проверка на корректность данных
                break;  //если всё успешно, останавливаем цикл
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());  //возвращаем ошибку пользователю
            }
        }
    }
}
