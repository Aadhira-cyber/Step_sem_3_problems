package basics_practice.p6;

public class Main {
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] inputs = {29, 21};
        for (int n : inputs) {
            System.out.println(n + (isPrime(n) ? " is prime" : " is not prime"));
        }
    }
}
