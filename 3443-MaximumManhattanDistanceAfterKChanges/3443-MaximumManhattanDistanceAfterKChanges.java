class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;
        int curr = 0, temp = k;
        //going in NE direction
        for(char ch: s.toCharArray()){
            if(ch == 'N' || ch == 'E' || temp-- > 0){
                curr++;
            }else{
                curr--;
            }
            ans = Math.max(ans, curr);
        }

        curr = 0;
        temp = k;
        //going in NW direction
        for(char ch: s.toCharArray()){
            if(ch == 'N' || ch == 'W' || temp-- > 0){
                curr++;
            }else{
                curr--;
            }
            ans = Math.max(ans, curr);
        }

        curr = 0;
        temp = k;
        //going in SW direction
        for(char ch: s.toCharArray()){
            if(ch == 'S' || ch == 'W' || temp-- > 0){
                curr++;
            }else{
                curr--;
            }
            ans = Math.max(ans, curr);
        }

        curr = 0;
        temp = k;
        //going in SE direction
        for(char ch: s.toCharArray()){
            if(ch == 'S' || ch == 'E' || temp-- > 0){
                curr++;
            }else{
                curr--;
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}