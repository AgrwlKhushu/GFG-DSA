class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thieves = new LinkedList<>();
        int caught = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }

            // Try to match police and thieves
            while (!police.isEmpty() && !thieves.isEmpty()) {
                int pol = police.peek();
                int thief = thieves.peek();

                if (Math.abs(pol - thief) <= k) {
                    caught++;
                    police.poll();
                    thieves.poll();
                } else if (thief < pol) {
                    thieves.poll();
                } else {
                    police.poll();
                }
            }
        }

        return caught;
    }
}
