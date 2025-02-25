class Solution {
    private void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public long maxSum(int[][] grid, int[] limits, int k) {
        if(k == 0){
            return 0;
        }

        int n = grid.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]);
            reverseArray(grid[i]);

            for (int j = 0; j < limits[i]; j++) {
                long num = (long) grid[i][j];
                if (pq.isEmpty() || pq.size() < k) {
                    pq.offer(num); // Add if PQ is not full
                } else if (pq.peek() < num) { // Check if new element is larger than smallest in PQ
                    pq.poll(); // Remove the smallest element
                    pq.offer(num); // Add the new element
                }
            }
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}