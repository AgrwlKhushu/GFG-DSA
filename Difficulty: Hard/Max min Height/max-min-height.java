class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = low + k;
        int answer = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAchieve(arr, k, w, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canAchieve(int[] arr, int k, int w, int target) {
        int n = arr.length;
        int[] water = new int[n + 1];
        int used = 0;
        int added = 0;

        for (int i = 0; i < n; i++) {
            added += water[i];
            int currentHeight = arr[i] + added;

            if (currentHeight < target) {
                int need = target - currentHeight;
                used += need;
                if (used > k) return false;

                added += need;
                if (i + w < water.length) {
                    water[i + w] -= need;
                }
            }
        }

        return true;
    }
}
