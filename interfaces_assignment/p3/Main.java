package interfaces_assignment.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

abstract class CollegeStudent {
    protected final String name;

    CollegeStudent(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract double tuition();

    double totalFee() {
        double fee = tuition();
        if (this instanceof BusUser) {
            fee += BusUser.TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends CollegeStudent implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends CollegeStudent {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends CollegeStudent implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double tuition() {
        return 40000 / 2.0;
    }
}

public class Main {
    static CollegeStudent create(String type, String name) {
        return switch (type) {
            case "DAY_SCHOLAR" -> new DayScholar(name);
            case "HOSTELLER" -> new Hosteller(name);
            case "SCHOLAR" -> new ScholarshipStudent(name);
            default -> throw new IllegalArgumentException("Unknown student type: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            CollegeStudent s = create(p[0].toUpperCase(), p[1]);
            double fee = s.totalFee();
            total += fee;
            System.out.println(String.format(Locale.US, "%s: %.2f", s.getName(), fee));
        }
        System.out.println(String.format(Locale.US, "Total Collected: %.2f", total));
    }
}
