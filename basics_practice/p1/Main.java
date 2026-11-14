package basics_practice.p1;

public class Main {
    static void count(String word) {
        int vowels = 0;
        int consonants = 0;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (!Character.isLetter(ch)) {
                continue;
            }
            if ("aeiou".indexOf(ch) >= 0) {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String word = args.length > 0 ? args[0] : "Programming";
        count(word);
    }
}
