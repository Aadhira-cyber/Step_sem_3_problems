package Assignments.week1;

public class WarehouseBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        
        int highestQuantity = Integer.MIN_VALUE;
        String sourceSection = "";
        int itemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            // Evaluate Section A for maximum quantity
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                sourceSection = "Section A";
                itemIndex = i + 1; // 1-based display index
            }

            // Evaluate Section B for maximum quantity
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                sourceSection = "Section B";
                itemIndex = i + 1; // 1-based display index
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: " + status + 
                           " | Highest Quantity: " + highestQuantity + " (" + sourceSection + ", Item " + itemIndex + ")");
    }

    public static void main(String[] args) {
        // Test Case
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
}

