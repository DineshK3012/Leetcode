class Solution {
    private boolean isVowel(char ch){
        if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
            return false;
        }

        return true;
    }

    private long countAtLeastK(String word, int k){
        HashMap<Character, Integer> vowels = new HashMap<>();
        int cc = 0; // consonent count
    
        long ans = 0;
        int i = 0, j = 0;
        while(j < word.length()){
            char ch = word.charAt(j);
            if(isVowel(ch)){
                vowels.put(ch, vowels.getOrDefault(ch, 0) + 1);
            }else{
                cc++;
            }

            while(vowels.size() == 5 && cc >= k){
                ans += (word.length() - j);

                char ch1 = word.charAt(i);
                if(isVowel(ch1)){
                    int f = vowels.get(ch1);

                    if(f == 1){
                        vowels.remove(ch1);
                    }else{
                        vowels.put(ch1, f-1);
                    }
                }else{
                    cc--;
                }
                i++;
            }

            j++;
        }

        return ans;
    }

    public long countOfSubstrings(String word, int k) {
        return countAtLeastK(word, k) - countAtLeastK(word, k+1);
    }
}