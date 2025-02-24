class Solution {
    private boolean dfs(int i, int l, ArrayList<ArrayList<Integer>> adj, HashMap<Integer, Integer> map, boolean[] visited){
        visited[i] = true;
        map.put(i, l);
        if(i == 0){
            return true;
        }
        
        for(int j: adj.get(i)){
            if(!visited[j] && dfs(j, l+1, adj, map, visited)){
                return true;
            }
        }
        map.remove(i);
        return false; 
    }

    private int aliceIncome;

    private void dfs2(int i, int l, int income, ArrayList<ArrayList<Integer>> adj, HashMap<Integer, Integer> map, int[] amount, boolean[] visited){
        visited[i] = true;
        if(map.containsKey(i)){
            if(map.get(i) < l){
                income += 0;
            }else if(map.get(i) == l){
                income += amount[i]/2;
            }else{
                income += amount[i];
            }
        }else{
            income += amount[i];
        }

        
        if(adj.get(i).size() == 1 && i != 0){
            aliceIncome = Math.max(income, aliceIncome);
        }

        int ans = Integer.MIN_VALUE;
        for(int j: adj.get(i)){
            if(!visited[j])
                dfs2(j, l+1, income, adj, map, amount, visited);
        }
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        aliceIncome = Integer.MIN_VALUE;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=edges.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int u = e[0], v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[] = new boolean[edges.length + 1];

        //finding the path from bob to root node
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(bob, 0, adj, map, visited);

        visited = new boolean[edges.length + 1];

        //traversing all paths for Alice
        int income = 0;
        dfs2(0, 0, income, adj, map, amount, visited);
        return aliceIncome;
    }
}