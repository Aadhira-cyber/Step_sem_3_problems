package week7_practice.p5;

class AttendanceSheet {
    private final String[] present;
    private int count;

    AttendanceSheet(int maxSize) {
        present = new String[maxSize];
        count = 0;
    }

    void markPresent(String name) {
        if (isPresent(name) || count >= present.length) {
            return;
        }
        present[count++] = name;
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (present[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}
