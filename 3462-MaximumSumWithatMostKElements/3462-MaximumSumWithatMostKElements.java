class Solution {
    // Helper function to reverse an int array
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
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i = 0; i<n; i++){
            Arrays.sort(grid[i]); // Sort in ascending order first
            reverseArray(grid[i]); // Then reverse the array

            for(int j = 0; j<limits[i]; j++){
                pq.add((long)grid[i][j]);

                if(pq.size() > k){
                    pq.remove();
                }
            }
        }

        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.remove();
        }

        return sum;
    }   
}