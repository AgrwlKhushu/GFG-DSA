class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        Arrays.sort(b);
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : a) {
            int count = upperBound(b, num);
            result.add(count);
        }

        return result;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
