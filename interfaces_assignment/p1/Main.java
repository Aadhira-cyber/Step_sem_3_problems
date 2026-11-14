package interfaces_assignment.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20;

    abstract String seatName();

    abstract double seatPrice();

    final double amount(int count) {
        return count * (seatPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    String seatName() {
        return "REGULAR";
    }

    double seatPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    String seatName() {
        return "PREMIUM";
    }

    double seatPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    String seatName() {
        return "RECLINER";
    }

    double seatPrice() {
        return 400;
    }
}

public class Main {
    static Ticket create(String seat) {
        return switch (seat) {
            case "REGULAR" -> new RegularTicket();
            case "PREMIUM" -> new PremiumTicket();
            case "RECLINER" -> new ReclinerTicket();
            default -> throw new IllegalArgumentException("Unknown seat type: " + seat);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            Ticket t = create(p[0].toUpperCase());
            double amount = t.amount(Integer.parseInt(p[1]));
            total += amount;
            System.out.println(String.format(Locale.US, "%s: %.2f", t.seatName(), amount));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
