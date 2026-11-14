package interfaces_assignment.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

interface Insurable {
    double INSURANCE_RATE = 0.02;

    double declaredValue();

    default double insurance() {
        return declaredValue() * INSURANCE_RATE;
    }
}

abstract class Parcel {
    protected final double weight;
    protected final double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract String typeName();

    abstract double charge();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    String typeName() {
        return "STANDARD";
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    String typeName() {
        return "EXPRESS";
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double declaredValue() {
        return declaredValue;
    }
}

class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    String typeName() {
        return "FRAGILE";
    }

    double charge() {
        return super.charge() + 50;
    }

    public double declaredValue() {
        return declaredValue;
    }
}

public class Main {
    static Parcel create(String type, double weight, double value) {
        return switch (type) {
            case "STANDARD" -> new StandardParcel(weight, value);
            case "EXPRESS" -> new ExpressParcel(weight, value);
            case "FRAGILE" -> new FragileParcel(weight, value);
            default -> throw new IllegalArgumentException("Unknown parcel type: " + type);
        };
    }

    static double insuranceOf(Parcel p) {
        return p instanceof Insurable i ? i.insurance() : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            Parcel parcel = create(p[0].toUpperCase(), Double.parseDouble(p[1]), Double.parseDouble(p[2]));
            double charge = parcel.charge();
            double insurance = insuranceOf(parcel);
            double total = charge + insurance;
            grand += total;
            System.out.println(String.format(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f", parcel.typeName(), charge, insurance, total));
        }
        System.out.println(String.format(Locale.US, "Grand Total: %.2f", grand));
    }
}
