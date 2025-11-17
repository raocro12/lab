package lab5.task2;

public class Cat {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Cat(String name) {
        setName(name);
    }

    public void meow() {
        System.out.println(this.name + ": мяу!");
    }

    @Override
    public String toString() {
        return "кот: " + this.name;
    }
}
