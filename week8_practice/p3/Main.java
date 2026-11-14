package week8_practice.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Delivery {
    protected final double weight;
    protected final double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract String getType();

    abstract double fee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    String getType() {
        return "STANDARD";
    }

    double fee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    String getType() {
        return "EXPRESS";
    }

    double fee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    private final double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    String getType() {
        return "INTERNATIONAL";
    }

    double fee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class Main {
    static Delivery create(String[] p) {
        double weight = Double.parseDouble(p[1]);
        double distance = Double.parseDouble(p[2]);
        return switch (p[0].toUpperCase()) {
            case "STANDARD" -> new StandardDelivery(weight, distance);
            case "EXPRESS" -> new ExpressDelivery(weight, distance);
            case "INTERNATIONAL" -> new InternationalDelivery(weight, distance, Double.parseDouble(p[3]));
            default -> throw new IllegalArgumentException("Unknown delivery type: " + p[0]);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            deliveries.add(create(br.readLine().trim().split("\\s+")));
        }
        double total = 0;
        for (Delivery d : deliveries) {
            double f = d.fee();
            total += f;
            System.out.println(String.format(Locale.US, "%s: %.2f", d.getType(), f));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
