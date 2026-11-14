package datastructures_practice.p3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    static boolean hasDuplicateNested(String[] transactionIds) {
        for (int i = 0; i < transactionIds.length; i++) {
            for (int j = i + 1; j < transactionIds.length; j++) {
                if (transactionIds[i].equals(transactionIds[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(new String[]{"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"}));
        System.out.println(hasDuplicate(new String[]{"TXN2001", "TXN2002", "TXN2003"}));
        System.out.println(hasDuplicateNested(new String[]{"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"}));
    }
}
