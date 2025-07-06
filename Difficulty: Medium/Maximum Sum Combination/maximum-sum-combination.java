import java.util.*;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.sum, p1.sum));
        Set<String> visited = new HashSet<>();
        
        int i = n - 1;
        int j = n - 1;
        maxHeap.offer(new Pair(i, j, a[i] + b[j]));
        visited.add(i + "," + j);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (k-- > 0 && !maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.add(current.sum);
            i = current.i;
            j = current.j;
            
            // Move to (i-1, j)
            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                maxHeap.offer(new Pair(i - 1, j, a[i - 1] + b[j]));
                visited.add((i - 1) + "," + j);
            }
            // Move to (i, j-1)
            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                maxHeap.offer(new Pair(i, j - 1, a[i] + b[j - 1]));
                visited.add(i + "," + (j - 1));
            }
        }
        return result;
    }

    class Pair {
        int i, j, sum;
        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}
