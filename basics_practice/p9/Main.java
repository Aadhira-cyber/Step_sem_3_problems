package basics_practice.p9;

public class Main {
    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        int[] years = {2024, 1900, 2000};
        for (int y : years) {
            System.out.println(isLeap(y) ? "Leap year" : "Not a leap year");
        }
    }
}
