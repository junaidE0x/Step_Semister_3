package DSA_introduction.Assignment_problems;


import java.util.*;

class ScoreBand {
    static int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (a[mid] < x)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    static int upperBound(int[] a, int x) {
        int l = 0, r = a.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (a[mid] <= x)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(a, low, high));
        sc.close();
    }
}

