package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> getUniqueChars(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Text is null.");
        }
        List<Character> result = new ArrayList<>();
        //for each végigmegy a wordon és beírja a listába, ha még az a karakter nem szerepel
        char[] wordCharacters = word.toCharArray();

        for (Character ch : wordCharacters) {
            if (!result.contains(ch)) {
                result.add(ch);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueFinder().getUniqueChars("12j2k415j"));
    }
}
