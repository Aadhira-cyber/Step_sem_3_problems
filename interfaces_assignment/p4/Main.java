package interfaces_assignment.p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

interface NightService {
    double NIGHT_SURCHARGE = 0.20;

    default double nightFare(double dayFare) {
        return dayFare * (1 + NIGHT_SURCHARGE);
    }
}

abstract class Cab {
    private static final double MINIMUM_FARE = 100;

    abstract String cabName();

    abstract double ratePerKm();

    final double fare(double km) {
        return Math.max(MINIMUM_FARE, km * ratePerKm());
    }
}

class MiniCab extends Cab {
    String cabName() {
        return "MINI";
    }

    double ratePerKm() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    String cabName() {
        return "SEDAN";
    }

    double ratePerKm() {
        return 14;
    }
}

class SuvCab extends Cab implements NightService {
    String cabName() {
        return "SUV";
    }

    double ratePerKm() {
        return 18;
    }
}

public class Main {
    static Cab create(String type) {
        return switch (type) {
            case "MINI" -> new MiniCab();
            case "SEDAN" -> new SedanCab();
            case "SUV" -> new SuvCab();
            default -> throw new IllegalArgumentException("Unknown cab type: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            Cab cab = create(p[0].toUpperCase());
            double fare = cab.fare(Double.parseDouble(p[1]));
            boolean night = p[2].equalsIgnoreCase("NIGHT");
            if (night) {
                if (cab instanceof NightService ns) {
                    fare = ns.nightFare(fare);
                } else {
                    System.out.println(cab.cabName() + ": night service not available");
                    continue;
                }
            }
            total += fare;
            System.out.println(String.format(Locale.US, "%s: %.2f", cab.cabName(), fare));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
