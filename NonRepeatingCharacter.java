import java.util.HashMap;

public class NonRepeatingCharacter {

    public static void main(String[] args) {
        runFind("swiss");
        runFind("aabbcc");
    }

    public static void runFind(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("Input: \"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Input: \"" + text + "\" -> No Non-Repeating Character Found");
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (counts.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }
}
