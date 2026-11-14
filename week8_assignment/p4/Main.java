package week8_assignment.p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Employee {
    protected final String name;
    protected final double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    String getName() {
        return name;
    }

    abstract double bonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return 2000;
    }
}

public class Main {
    static Employee create(String type, String name, double salary) {
        return switch (type) {
            case "FULLTIME" -> new FullTimeEmployee(name, salary);
            case "PARTTIME" -> new PartTimeEmployee(name, salary);
            case "INTERN" -> new InternEmployee(name, salary);
            default -> throw new IllegalArgumentException("Unknown employee type: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            employees.add(create(p[0].toUpperCase(), p[1], Double.parseDouble(p[2])));
        }
        double total = 0;
        for (Employee e : employees) {
            double b = e.bonus();
            total += b;
            System.out.println(String.format(Locale.US, "%s: %.2f", e.getName(), b));
        }
        System.out.println(String.format(Locale.US, "Total Bonus: %.2f", total));
    }
}
