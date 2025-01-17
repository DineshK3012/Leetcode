class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int f = 0;
        int p = 0;
        for(int i = 1; i<n; i++){
            p =  p ^ derived[i-1];
        }

        if((p^derived[n-1]) == f){
            return true;
        }

        f = 1;
        p = 1;
        for(int i = 1; i<n; i++){
            p =  p ^ derived[i-1];
        }

        return (p^derived[n-1]) == f;
    }
}