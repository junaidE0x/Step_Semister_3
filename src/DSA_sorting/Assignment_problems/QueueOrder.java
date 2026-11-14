package DSA_sorting.Assignment_problems;

class QueueOrder {
    static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1])
                return i + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 8, 6, 9};
        int[] b = {1, 2, 2, 7};

        System.out.println(firstBreak(a));
        System.out.println(firstBreak(b));
    }
}
