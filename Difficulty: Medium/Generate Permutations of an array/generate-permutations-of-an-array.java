class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        permutations(res, arr, 0);
        return res;
    }
    
    private static void permutations(ArrayList<ArrayList<Integer>> res, int[] arr, int idx) {
        if (idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int val : arr) temp.add(val);
            res.add(temp);
            return;
        }
        
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            permutations(res, arr, idx + 1);
            swap(arr, idx, i);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
};