package Assignments.week2;

public class PinValidator {
    public static void checkPinLength(String pin) {
        // Check if the pin length is exactly 4 digits
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        // Test Cases
        checkPinLength("482");
        checkPinLength("4820");
    }
}
