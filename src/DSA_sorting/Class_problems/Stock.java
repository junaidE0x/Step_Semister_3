package DSA_sorting.Class_problems;

class Stock {
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;

            int profit = price - minPrice;

            if (profit > maxProfit)
                maxProfit = profit;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(a));
        System.out.println(maxProfit(b));
    }
}

