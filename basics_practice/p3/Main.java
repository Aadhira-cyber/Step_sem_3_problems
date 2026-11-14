package basics_practice.p3;

public class Main {
    public static void main(String[] args) {
        int[] list = {3, 8, 12, 5, 7, 10};
        int even = 0;
        int odd = 0;
        for (int x : list) {
            if (x % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
