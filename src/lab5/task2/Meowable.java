package lab5.task2;

public class Meowable implements Meowing{
    private Cat cat;
    private int count = 0;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public int getCount() {
        return count;
    }

    public Meowable(Cat cat){
        setCat(cat);
    }

    @Override
    public void meow() {
        cat.meow();
        count++;
    }
}
