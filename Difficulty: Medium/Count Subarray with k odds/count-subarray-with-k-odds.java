class Solution {
    public int countSubarrays(int[] arr, int k) {
        // code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            if ((num & 1) == 1) {
                prefixSum++;
            }

            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;

    }
}
