class Solution {
    private int dfs(int i, int j, boolean[][] visited, int[][] grid){
        visited[i][j] = true;
        int curr = grid[i][j];
    
        //top
        if(i-1 >= 0 && grid[i-1][j] > 0 && !visited[i-1][j])
            curr += dfs(i-1, j, visited, grid);

        //bottom
        if(i+1 < grid.length && grid[i+1][j] > 0 && !visited[i+1][j])
            curr += dfs(i+1, j, visited, grid);

        //left
        if(j-1 >= 0 && grid[i][j-1] > 0 && !visited[i][j-1])
            curr += dfs(i, j-1, visited, grid);

        //right
        if(j+1 < grid[0].length && grid[i][j+1] > 0 && !visited[i][j+1])
            curr += dfs(i, j+1, visited, grid);

        return curr;
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j] && grid[i][j] > 0){
                    ans = Math.max(ans, dfs(i, j, visited, grid));
                }
            }
        }

        return ans;
    }
}