class Solution {
    public static int countSubs(String s) {
        // code here
        
        int n = s.length();
        long mod = (1L << 61) - 1;
        long base = 131L;
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long hash = 0;
            for (int j = i; j < n; j++) {
                hash = mul(hash, base, mod);
                hash = add(hash, s.charAt(j) - 'a' + 1, mod);
                set.add(hash);
            }
        }
        return set.size();
    }
    
    private static long add(long a, long b, long mod) {
        long res = a + b;
        if (res >= mod) res -= mod;
        return res;
    }

    private static long mul(long a, long b, long mod) {
        long au = a >>> 31, ad = a & ((1L << 31) - 1);
        long bu = b >>> 31, bd = b & ((1L << 31) - 1);
        long mid = ad * bu + au * bd;
        long midu = mid >>> 30, midd = mid & ((1L << 30) - 1);
        long res = au * bu * 2 + midu + (midd << 31) + ad * bd;
        res = (res >>> 61) + (res & mod);
        if (res >= mod) res -= mod;
        return res;
    }
}