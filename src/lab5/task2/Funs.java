package lab5.task2;

import java.util.Random;

public class Funs {
    public static void meowsCare(Meowing... meowings) {
        Random rand = new Random();

        int r = rand.nextInt(10);
        for (int i = 0; i < r; i++) {
            for (Meowing m: meowings){
                m.meow();
            }
        }
    }
}
