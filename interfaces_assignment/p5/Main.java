package interfaces_assignment.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

interface SaverCapable {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    private static final double RATE_PER_UNIT = 8;

    abstract String applianceName();

    abstract double powerWatts();

    double units(double hours, boolean saver) {
        double u = powerWatts() * hours / 1000;
        if (saver) {
            u *= SaverCapable.SAVER_FACTOR;
        }
        return u;
    }

    double cost(double units) {
        return units * RATE_PER_UNIT;
    }
}

class Fridge extends Appliance {
    String applianceName() {
        return "FRIDGE";
    }

    double powerWatts() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverCapable {
    String applianceName() {
        return "AC";
    }

    double powerWatts() {
        return 1500;
    }
}

class Television extends Appliance {
    String applianceName() {
        return "TV";
    }

    double powerWatts() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverCapable {
    String applianceName() {
        return "WASHER";
    }

    double powerWatts() {
        return 500;
    }
}

public class Main {
    static Appliance create(String type) {
        return switch (type) {
            case "FRIDGE" -> new Fridge();
            case "AC" -> new AirConditioner();
            case "TV" -> new Television();
            case "WASHER" -> new WashingMachine();
            default -> throw new IllegalArgumentException("Unknown appliance: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            Appliance a = create(p[0].toUpperCase());
            boolean saver = p.length > 2 && p[2].equalsIgnoreCase("SAVER");
            if (saver && !(a instanceof SaverCapable)) {
                System.out.println(a.applianceName() + ": saver mode not supported");
                continue;
            }
            double units = a.units(Double.parseDouble(p[1]), saver);
            double cost = a.cost(units);
            total += cost;
            System.out.println(String.format(Locale.US, "%s: Units=%.2f Cost=%.2f", a.applianceName(), units, cost));
        }
        System.out.println(String.format(Locale.US, "Total Cost: %.2f", total));
    }
}
