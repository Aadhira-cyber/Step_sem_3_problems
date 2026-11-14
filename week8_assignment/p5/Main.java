package week8_assignment.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Plan {
    protected final String name;
    protected final LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    String getName() {
        return name;
    }

    abstract int validityDays();

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate start) {
        super(name, start);
    }

    int validityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate start) {
        super(name, start);
    }

    int validityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate start) {
        super(name, start);
    }

    int validityDays() {
        return 365;
    }
}

public class Main {
    static Plan create(String type, String name, LocalDate start) {
        return switch (type) {
            case "BASIC" -> new BasicPlan(name, start);
            case "STANDARD" -> new StandardPlan(name, start);
            case "PREMIUM" -> new PremiumPlan(name, start);
            default -> throw new IllegalArgumentException("Unknown plan type: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Plan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            plans.add(create(p[0].toUpperCase(), p[1], LocalDate.parse(p[2])));
        }
        for (Plan p : plans) {
            System.out.println(p.getName() + ": " + p.renewalDate());
        }
    }
}
