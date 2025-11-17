package lab4.task3;

//как добавить один элемент в колекцию
public interface BiConsumer<P, T> {
    void accept(P collection, T element);
}

