package week8_assignment.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Vehicle {
    protected final int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract String getType();

    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    String getType() {
        return "BIKE";
    }

    double charge() {
        return 10.0 * hours;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    String getType() {
        return "CAR";
    }

    double charge() {
        return 30.0 + 20.0 * (hours - 1);
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    String getType() {
        return "TRUCK";
    }

    double charge() {
        return Math.max(100.0, 50.0 * hours);
    }
}

public class Main {
    static Vehicle create(String type, int hours) {
        return switch (type) {
            case "BIKE" -> new Bike(hours);
            case "CAR" -> new Car(hours);
            case "TRUCK" -> new Truck(hours);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            vehicles.add(create(p[0].toUpperCase(), Integer.parseInt(p[1])));
        }
        double total = 0;
        for (Vehicle v : vehicles) {
            double c = v.charge();
            total += c;
            System.out.println(String.format(Locale.US, "%s: %.2f", v.getType(), c));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
