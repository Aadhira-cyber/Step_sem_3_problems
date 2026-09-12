package Assignments.week1;

public class SeatChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        
        // Loop through each element
        for (int i = 0; i < seatNumbers.length; i++) {
            // Check against subsequent elements to avoid double-checking
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break; // Move to the next outer loop element
                }
            }
        }
        
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] test1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(test1);

        // Test Case 2
        int[] test2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(test2);
    }
}

