package OOP_Abstraction_Interface.Class_problems;

import java.util.Scanner;

public class Grader {
    static abstract class Question {
        String correct, answer;
        double points;

        Question(String correct, String answer, double points) {
            this.correct = correct;
            this.answer = answer;
            this.points = points;
        }

        abstract double score();
    }

    static class MCQ extends Question {
        MCQ(String c, String a, double p) {
            super(c, a, p);
        }

        double score() {
            return answer.equalsIgnoreCase(correct) ? points : 0;
        }
    }

    static class TF extends Question {
        TF(String c, String a, double p) {
            super(c, a, p);
        }

        double score() {
            return answer.equalsIgnoreCase(correct) ? points : 0;
        }
    }

    static class Essay extends Question {
        Essay(String c, String a, double p) {
            super(c, a, p);
        }

        double score() {
            int count = 0;

            for (String keyword : correct.split(",")) {
                if (answer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                    count++;
                }
            }

            if (count >= 2) {
                return points * 0.75;
            } else if (count == 1) {
                return points * 0.50;
            }

            return 0;
        }
    }

    static String[] readFields(String line) {
        java.util.regex.Matcher m =
                java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);

        java.util.ArrayList<String> fields = new java.util.ArrayList<>();

        while (m.find()) {
            fields.add(m.group(1) != null ? m.group(1) : m.group(2));
        }

        return fields.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }

            String[] f = readFields(line);
            String type = f[0].toUpperCase();
            Question q;

            if (type.equals("MCQ")) {
                q = new MCQ(f[2], f[3], Double.parseDouble(f[4]));
            } else if (type.equals("TF")) {
                q = new TF(f[2], f[3], Double.parseDouble(f[4]));
            } else {
                q = new Essay(f[2], f[3], Double.parseDouble(f[4]));
            }

            double score = q.score();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
