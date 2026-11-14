package week8_practice.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Payment {
    protected final double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract String getType();

    abstract double finalAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "CARD";
    }

    double finalAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "WALLET";
    }

    double finalAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "BANKTRANSFER";
    }

    double finalAmount() {
        return amount;
    }
}

public class Main {
    static Payment create(String type, double amount) {
        return switch (type) {
            case "CARD" -> new CardPayment(amount);
            case "WALLET" -> new WalletPayment(amount);
            case "BANKTRANSFER" -> new BankTransferPayment(amount);
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            payments.add(create(p[0].toUpperCase(), Double.parseDouble(p[1])));
        }
        double total = 0;
        for (Payment p : payments) {
            double f = p.finalAmount();
            total += f;
            System.out.println(String.format(Locale.US, "%s: %.2f", p.getType(), f));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
