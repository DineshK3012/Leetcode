class Solution {
    public int numberOfSubstrings(String s) {
        int[] f= new int[3];
        int i = 0, j = 0, ans = 0, n = s.length();

        while(j < n){
            char ch = s.charAt(j);
            f[ch - 'a']++;

            while(f[0] > 0 && f[1] > 0 && f[2] > 0){
                ans += (s.length() - j);
                char ch1 = s.charAt(i);
                f[ch1 - 'a']--;
                i++;
            }
            j++;
        }

        return ans;
    }
}