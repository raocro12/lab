package lab4.task2;

import java.util.NoSuchElementException;

//Обобщённая коробка
public class Box<T> {

    private T item;  // единственное поле класса

    public void put(T newItem) {
        if (item != null) {
            throw new IllegalStateException("Коробка занята");
        } else {
            item = newItem;
        }
    }

    public T take() {
        if (item == null) {
            throw new NoSuchElementException();
        } else {
            T tItem = item;
            item = null;
            return tItem;
        }
    }

    //метод проверки на заполненность
    public boolean isEmpty() {
        return item == null;
    }

    @Override
    public String toString() {
        if (item == null)
            return "Коробка пуста";
        return "Коробка содержит: " + item;
    }
}
