class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] f = new int[26];
        for(String s: words2){
            int[] t = new int[26];
            for(char ch: s.toCharArray()){
                t[ch-'a']++;

                f[ch-'a'] = Math.max(f[ch-'a'], t[ch-'a']);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String s: words1){
            int t[] = new int[26];
            for(char ch: s.toCharArray()){
                t[ch-'a']++;
            }

            boolean isUniversal = true;
            for(int i = 0; i<26; i++){
                if(t[i] < f[i]){
                    isUniversal = false;
                    break;
                }
            }

            if(isUniversal){
                ans.add(s);
            }
        }

        return ans;
    }
}