class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        int need = (n + 1) / 2;
        int lucky = 0;
        List<Integer> cost = new ArrayList<>();
        for (int num : arr) {
            if (num % k == 0) lucky++;
            else cost.add(k - (num % k));
        }
        if (lucky >= need) return 0;
        Collections.sort(cost);
        int res = 0;
        for (int i = 0; i < need - lucky; i++) res += cost.get(i);
        return res;
    }
}