class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        if (m > n) return res;

        int d = 26; // base for lowercase letters
        int q = 101; // A prime number to mod the hash

        int h = 1;
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        int p = 0; // hash value for pattern
        int t = 0; // hash value for text window

        // Initial hash values
        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text
        for (int i = 0; i <= n - m; i++) {
            // If hash matches, do actual check
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    res.add(i + 1); // 1-based index
            }

            // Update hash for next window
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                // We might get negative value of t, convert it to positive
                if (t < 0)
                    t = (t + q);
            }
        }

        return res;
    }
}
