package basics_practice.p5;

public class Main {
    static void process(int n) {
        int sum = 0;
        int rev = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            rev = rev * 10 + d;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
    }

    public static void main(String[] args) {
        process(4721);
    }
}
