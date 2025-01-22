class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] height = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the height array and add water cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    height[i][j] = 0;
                } else {
                    height[i][j] = -1;
                }
            }
        }
        
        // Directions for moving up, down, left, right
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        // Process the queue
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            
            // Visit neighbors
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && height[newX][newY] == -1) {
                    height[newX][newY] = height[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        
        return height;
    }
}
