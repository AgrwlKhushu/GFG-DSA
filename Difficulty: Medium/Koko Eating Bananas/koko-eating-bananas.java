class Solution {
    public int kokoEat(int[] arr, int k) {
        int left = 1, right = getMax(arr);
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(arr, k, mid)) {
                answer = mid; // try smaller speed
                right = mid - 1;
            } else {
                left = mid + 1; // need more speed
            }
        }

        return answer;
    }

    private boolean canEatAll(int[] arr, int k, int speed) {
        int hours = 0;

        for (int pile : arr) {
            hours += (pile + speed - 1) / speed;
            if (hours > k) return false;
        }

        return hours <= k;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}
