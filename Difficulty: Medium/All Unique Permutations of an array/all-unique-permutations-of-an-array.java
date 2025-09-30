class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        backtrack(res, new ArrayList<>(), arr, used);
        return res;
    }
    private static void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr, boolean[] used) {
        if (temp.size() == arr.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;
            used[i] = true;
            temp.add(arr[i]);
            backtrack(res, temp, arr, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
