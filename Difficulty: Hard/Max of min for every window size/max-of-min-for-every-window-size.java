import java.util.*;

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] stack = new int[n];
        int top = -1;

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) top--;
            if (top >= 0) left[i] = stack[top];
            stack[++top] = i;
        }

        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) top--;
            if (top >= 0) right[i] = stack[top];
            stack[++top] = i;
        }

        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            if (arr[i] > res[len]) res[len] = arr[i];
        }

        for (int i = n - 1; i >= 1; i--) {
            if (res[i + 1] > res[i]) res[i] = res[i + 1];
        }

        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) ans.add(res[i]);
        return ans;
    }
}
