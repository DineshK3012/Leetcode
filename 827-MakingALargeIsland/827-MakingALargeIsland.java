class Solution {
    class DSU{
        int n;
        int[] parent;
        int[] size;

        public DSU(int cap){
            n = cap;
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int x){
            if(parent[x] == x){
                return x;
            }

            return parent[x] = findParent(parent[x]);
        }

        public void union(int x, int y){
            int px = findParent(x);
            int py = findParent(y);

            if(px == py)    return;


            if(size[x] > size[y]){
                parent[py] = px;
                size[px] += size[py];
            }else{
                parent[px] = py;
                size[py] += size[px];
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        DSU ds = new DSU(n*m);

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    int currCell = i*m+j;

                    if(i-1 >= 0 && grid[i-1][j] == 1){
                        ds.union(currCell, (i-1)*m + j);
                    }

                    if(i+1 < n && grid[i+1][j] == 1){
                        ds.union(currCell, (i+1)*m + j);
                    }

                    if(j-1 >= 0 && grid[i][j-1] == 1){
                        ds.union(currCell, i*m + j-1);
                    }

                    if(j+1 < m && grid[i][j+1] == 1){
                        ds.union(currCell, i*m + j + 1);
                    }
                }
            }
        }

        int largest = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();

                    if(i-1 >= 0 && grid[i-1][j] == 1){
                        set.add(ds.findParent((i-1)*m + j));
                    }

                    if(i+1 < n && grid[i+1][j] == 1){
                        set.add(ds.findParent((i+1)*m + j));
                    }

                    if(j-1 >= 0 && grid[i][j-1] == 1){
                        set.add(ds.findParent(i*m + j - 1));
                    }

                    if(j+1 < m && grid[i][j+1] == 1){
                        set.add(ds.findParent(i*m + j + 1));
                    }

                    int size = 1;
                    for(int x: set){
                        size += ds.size[x];
                    }

                    largest = Math.max(largest, size);
                }else{
                    int p = ds.findParent(i*m + j);
                    largest = Math.max(largest, ds.size[p]);
                }
            }
        }

        return largest;
    }
}