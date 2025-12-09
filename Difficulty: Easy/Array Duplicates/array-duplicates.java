class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int key : map.keySet()){
            if(map.get(key) > 1) ans.add(key);
        }
        
        Collections.sort(ans);
        return ans;
    }
}