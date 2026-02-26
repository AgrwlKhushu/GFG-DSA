class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for(int i = 0; i < s1.length(); i++){
            if(m1[s1.charAt(i)] != m2[s2.charAt(i)]) return false;
            m1[(int)s1.charAt(i)] = i+1;
            m2[(int)s2.charAt(i)] = i+1;
        }
        return true;
    }
}