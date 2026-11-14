package week7_practice.p1;

class PiggyBank {
    private final String id;
    private double savings;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    void withdraw(double amount) {
        if (amount <= 0 || amount > savings) {
            System.out.println("Withdrawal rejected, savings stays " + savings);
            return;
        }
        savings -= amount;
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("savings = " + pb.getSavings());
    }
}
