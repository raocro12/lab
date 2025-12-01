package lab5.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class SetFunc {
    public static Set<Character> disjunction(String path) {
        String text = null;
        try {
            text = Files.readString(Paths.get(path)).toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(text);
        String[] words = text.split(" ");

        Set<Character> unique = new HashSet<>();
        Set<Character> repeated = new HashSet<>();
        for (String word : words) {

            Set<Character> charSet = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (unique.contains(c)) {
                    unique.remove(c);
                    repeated.add(c);
                } else if (!repeated.contains(c)) {
                    unique.add(c);
                }
            }
        }
        return unique;
    }
}