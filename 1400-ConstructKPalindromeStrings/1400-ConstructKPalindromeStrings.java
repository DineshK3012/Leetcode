class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)  return false;

        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        int odds = 0;
        for(int f: freq){
            if(f % 2 != 0){
                odds++;
            }

            if(odds > k){
                return false;
            }
        }

        return odds <= k;
    }
}