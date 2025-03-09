class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] temp = new int[n+k];

        temp[0] = 1;
        for(int i = 1; i<n+k-1; i++){
            if(colors[i % n] != colors[(i-1)%n]){
                temp[i] = temp[i-1] + 1;
            }else{
                temp[i] = 1;
            }
        }

        int ans = temp[k-1] == k? 1: 0;
        for(int i = k; i<n + k - 1; i++){
            if(temp[i] >= k){
                ans++;
            }
        }

        return ans;
    }
}