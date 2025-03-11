class Solution {
    public int numberOfSubstrings(String s) {
        int[] f = new int[3];
        int i = 0, j = 0, ans = 0, n = s.length();
        while(j < n){
            f[s.charAt(j) - 'a']++;

            while(f[0] > 0 && f[1] > 0 && f[2] > 0){
                ans += (n - j);
                f[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }

        return ans;
    }
}