package Assignments.week2;

public class IsbnValidator {
    public static String normalizeCode(String raw) {
        if (raw == null || raw.trim().length() < 3) {
            return raw;
        }
        // Trim spaces
        String trimmed = raw.trim();
        // Uppercase only the first 3 characters and keep the rest intact
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        // 1. Length validation
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // 2. Publisher code validation (First 3 characters must be letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // 3. Body validation (Remaining 10 characters must be digits)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extracting fields for the final output format
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        // Building the validated line display
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(pubCode).append("] ")
                 .append("YEAR: ").append(year).append(" | ")
                 .append("CATALOG: ").append(catalog);

        return formatted.toString();
    }

    public static void main(String[] args) {
        // Test Case 1
        String normalized1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalized1));

        // Test Case 2
        String normalized2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(normalized2));
    }
}
