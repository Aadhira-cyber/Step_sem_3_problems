package week8_practice.p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class Question {
    protected final String correctAnswer;
    protected final String studentAnswer;
    protected final double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract String getType();

    abstract double score();
}

class McqQuestion extends Question {
    McqQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    String getType() {
        return "MCQ";
    }

    double score() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    String getType() {
        return "TF";
    }

    double score() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    String getType() {
        return "ESSAY";
    }

    double score() {
        String answer = studentAnswer.toLowerCase();
        int matched = 0;
        for (String keyword : correctAnswer.split(",")) {
            String k = keyword.trim().toLowerCase();
            if (!k.isEmpty() && answer.contains(k)) {
                matched++;
            }
        }
        if (matched >= 2) {
            return points * 0.75;
        }
        if (matched == 1) {
            return points * 0.50;
        }
        return 0;
    }
}

public class Main {
    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        int len = line.length();
        while (i < len) {
            char c = line.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
            } else if (c == '"') {
                int end = line.indexOf('"', i + 1);
                if (end < 0) {
                    end = len;
                }
                tokens.add(line.substring(i + 1, end));
                i = end + 1;
            } else {
                int start = i;
                while (i < len && !Character.isWhitespace(line.charAt(i))) {
                    i++;
                }
                tokens.add(line.substring(start, i));
            }
        }
        return tokens;
    }

    static Question create(List<String> t) {
        double points = t.size() > 4 ? Double.parseDouble(t.get(4)) : 1;
        String correct = t.get(2);
        String student = t.get(3);
        return switch (t.get(0).toUpperCase()) {
            case "MCQ" -> new McqQuestion(correct, student, points);
            case "TF" -> new TrueFalseQuestion(correct, student, points);
            case "ESSAY" -> new EssayQuestion(correct, student, points);
            default -> throw new IllegalArgumentException("Unknown question type: " + t.get(0));
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            questions.add(create(tokenize(br.readLine().trim())));
        }
        double total = 0;
        for (Question q : questions) {
            double s = q.score();
            total += s;
            System.out.println(String.format(Locale.US, "%s: %.2f", q.getType(), s));
        }
        System.out.println(String.format(Locale.US, "Total Score: %.2f", total));
    }
}
