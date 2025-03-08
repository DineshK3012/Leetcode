class Solution {
    public int minimumRecolors(String blocks, int k) {
        int white = 0;
        for(int i = 0; i<k; i++){
            white += (blocks.charAt(i) == 'W'? 1: 0);
        }

        int ans = white;
        for(int i = k; i<blocks.length(); i++){
            white += (blocks.charAt(i) == 'W'? 1: 0) - (blocks.charAt(i-k) == 'W' ? 1: 0);
            ans = Math.min(ans, white);
        }

        return ans;
    }
}