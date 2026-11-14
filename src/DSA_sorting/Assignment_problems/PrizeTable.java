package DSA_sorting.Assignment_problems;

import java.util.*;

class PrizeTable {
    static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int max = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[max])
                    max = j;
            }

            if (max != i) {
                int temp = marks[i];
                marks[i] = marks[max];
                marks[max] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] a = {45, 90, 60, 75};
        int[] b = {80, 70, 60};

        int s1 = prizeTable(a);
        int s2 = prizeTable(b);

        System.out.println(Arrays.toString(a) + " Swaps: " + s1);
        System.out.println(Arrays.toString(b) + " Swaps: " + s2);
    }
}

