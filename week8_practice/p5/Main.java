package week8_practice.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Journey {
    protected final double distance;

    Journey(double distance) {
        this.distance = distance;
    }

    abstract String getType();

    abstract double fare();
}

class BusJourney extends Journey {
    BusJourney(double distance) {
        super(distance);
    }

    String getType() {
        return "BUS";
    }

    double fare() {
        return Math.min(10.0, 2.0 + 0.10 * distance);
    }
}

class TrainJourney extends Journey {
    TrainJourney(double distance) {
        super(distance);
    }

    String getType() {
        return "TRAIN";
    }

    double fare() {
        return 3.0 + 0.15 * distance;
    }
}

class MetroJourney extends Journey {
    private final double peakHourFactor;

    MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    String getType() {
        return "METRO";
    }

    double fare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class Main {
    static Journey create(String[] p) {
        double distance = Double.parseDouble(p[1]);
        return switch (p[0].toUpperCase()) {
            case "BUS" -> new BusJourney(distance);
            case "TRAIN" -> new TrainJourney(distance);
            case "METRO" -> new MetroJourney(distance, Double.parseDouble(p[2]));
            default -> throw new IllegalArgumentException("Unknown transport type: " + p[0]);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            journeys.add(create(br.readLine().trim().split("\\s+")));
        }
        double total = 0;
        for (Journey j : journeys) {
            double f = j.fare();
            total += f;
            System.out.println(String.format(Locale.US, "%s: %.2f", j.getType(), f));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
