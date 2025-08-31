class Solution {
    public int maxWater(int arr[]) {
        int left = 0, right = arr.length - 1;
        int max = 0;
        while (left < right) {
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            max = Math.max(max, height * width);
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
