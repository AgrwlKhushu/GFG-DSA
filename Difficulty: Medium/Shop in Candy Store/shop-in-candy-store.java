class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices);
        int n = prices.length;
        
        int minCost = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            minCost += prices[i];
            i++;
            j -= k;
        }
        
        int maxCost = 0;
        i = n - 1;
        j = 0;
        while (j <= i) {
            maxCost += prices[i];
            i--;
            j += k;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(minCost);
        result.add(maxCost);
        return result;
    }
}
