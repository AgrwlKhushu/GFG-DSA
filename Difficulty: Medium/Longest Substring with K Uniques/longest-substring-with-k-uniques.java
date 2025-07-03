class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        
        int maxLen = -1;
        int l = 0, r = 0;
        
        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            
            while(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                
                l++;
            }
            
            if(map.size() == k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            
            r++;
        }
        
        return maxLen;
    }
}