class Solution {
    class DSU{
        int n;
        int[] parent;
        int[] rank;

        public DSU(int cap){
            n = cap;
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i<n; i++){
                parent[i] = i;
                rank[i] = 0;
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


            if(rank[x] > rank[y]){
                parent[py] = px;
                rank[px]++;
            }else{
                parent[px] = py;
                rank[py]++;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU ds = new DSU(n);

        for(int i = 0; i<n; i++){
            int u = edges[i][0], v = edges[i][1];

            if(ds.findParent(u-1) == ds.findParent(v-1)){
                return new int[]{u, v};
            }else{
                ds.union(u-1, v-1);
            }
        }

        return new int[]{-1, -1};
    }
}