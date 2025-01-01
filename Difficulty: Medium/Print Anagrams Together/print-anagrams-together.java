//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<HashMap<Character, Integer>, ArrayList<String>> b = new HashMap<>();

        for (String x : arr) {
            HashMap<Character, Integer> k = new HashMap<>();

            // Count frequency of each character in the string
            for (char c : x.toCharArray()) {
                k.put(c, k.getOrDefault(c, 0) + 1);
            }

            // If the key exists, add the string to the list
            if (b.containsKey(k)) {
                ArrayList<String> m = b.get(k);
                m.add(x);
            } else {
                // Otherwise, create a new list and add the string
                ArrayList<String> m = new ArrayList<>();
                m.add(x);
                b.put(k, m);
            }
        }

        // Convert the values of the HashMap into a list of lists
        return new ArrayList<>(b.values());
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends