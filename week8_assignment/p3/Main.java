package week8_assignment.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Room {
    protected final double units;

    Room(double units) {
        this.units = units;
    }

    abstract String getType();

    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(double units) {
        super(units);
    }

    String getType() {
        return "SINGLE";
    }

    double bill() {
        return units * 8;
    }
}

class SharedRoom extends Room {
    private final int occupants;

    SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    String getType() {
        return "SHARED";
    }

    double bill() {
        return units * 6 / occupants;
    }
}

class AcRoom extends Room {
    AcRoom(double units) {
        super(units);
    }

    String getType() {
        return "AC";
    }

    double bill() {
        return units * 10 + 200;
    }
}

public class Main {
    static Room create(String[] p) {
        double units = Double.parseDouble(p[1]);
        return switch (p[0].toUpperCase()) {
            case "SINGLE" -> new SingleRoom(units);
            case "SHARED" -> new SharedRoom(units, Integer.parseInt(p[2]));
            case "AC" -> new AcRoom(units);
            default -> throw new IllegalArgumentException("Unknown room type: " + p[0]);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(create(br.readLine().trim().split("\\s+")));
        }
        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            total += b;
            System.out.println(String.format(Locale.US, "%s: %.2f", r.getType(), b));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
