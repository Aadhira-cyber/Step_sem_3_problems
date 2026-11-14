package week8_practice.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    protected final String title;

    LibraryItem(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    abstract int borrowDays();

    LocalDate dueDate(LocalDate today) {
        return today.plusDays(borrowDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int borrowDays() {
        return 14;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title) {
        super(title);
    }

    int borrowDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int borrowDays() {
        return 3;
    }
}

public class Main {
    static LibraryItem create(String type, String title) {
        return switch (type) {
            case "BOOK" -> new Book(title);
            case "DVD" -> new Dvd(title);
            case "MAGAZINE" -> new Magazine(title);
            default -> throw new IllegalArgumentException("Unknown item type: " + type);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LocalDate today = LocalDate.of(2023, 10, 26);
        int n = Integer.parseInt(br.readLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space).toUpperCase();
            String title = line.substring(space + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }
            items.add(create(type, title));
        }
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.dueDate(today));
        }
    }
}
