package week8_assignment.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Customer {
    protected final double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract String getType();

    abstract double finalAmount();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) {
        super(amount);
    }

    String getType() {
        return "STUDENT";
    }

    double finalAmount() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) {
        super(amount);
    }

    String getType() {
        return "STAFF";
    }

    double finalAmount() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) {
        super(amount);
    }

    String getType() {
        return "GUEST";
    }

    double finalAmount() {
        return amount + 10;
    }
}

public class Main {
    static Customer create(String type, double amount) {
        return switch (type) {
            case "STUDENT" -> new StudentCustomer(amount);
            case "STAFF" -> new StaffCustomer(amount);
            case "GUEST" -> new GuestCustomer(amount);
            default -> throw new IllegalArgumentException("Unknown customer type: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            bills.add(create(p[0].toUpperCase(), Double.parseDouble(p[1])));
        }
        double total = 0;
        for (Customer c : bills) {
            double f = c.finalAmount();
            total += f;
            System.out.println(String.format(Locale.US, "%s: %.2f", c.getType(), f));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
