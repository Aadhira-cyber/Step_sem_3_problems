package problems.week1;

public class CustomerNameReversal {

    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversed = reverseCustomerName(customerName);
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
    }

    public static String reverseCustomerName(String customerName) {
        char[] origChars = customerName.toCharArray();
        char[] revChars = new char[origChars.length];
        for (int i = 0; i < origChars.length; i++) {
            revChars[i] = origChars[origChars.length - 1 - i];
        }
        return new String(revChars);
    }
}
