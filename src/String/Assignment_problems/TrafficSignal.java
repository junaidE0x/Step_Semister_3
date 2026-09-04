package String.Assignment_problems;

import java.util.Scanner;

public class TrafficSignal {
    public TrafficSignal() {
    }

    public static void findLongestStreak(String signalLog) {
        char currentColour = signalLog.charAt(0);
        char longest = currentColour;
        int streak = 1;
        int maxStreak = 1;

        for(int i = 1; i < signalLog.length(); ++i) {
            if (signalLog.charAt(i) == currentColour) {
                ++streak;
            } else {
                if (streak > maxStreak) {
                    maxStreak = streak;
                    longest = currentColour;
                }

                currentColour = signalLog.charAt(i);
                streak = 1;
            }
        }

        if (streak > maxStreak) {
            maxStreak = streak;
            longest = currentColour;
        }

        System.out.println("Longest Streak: '" + longest + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();
        findLongestStreak(signalLog);
        sc.close();
    }
}

