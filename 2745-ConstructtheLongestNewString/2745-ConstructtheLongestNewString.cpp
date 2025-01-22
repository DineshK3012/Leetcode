class Solution {
public:
    int longestString(int x, int y, int z) {
        if(x == y){
            return 2*(z + x + y); 
        }else if(x > y){
            return 2 *(z + 2 * y + 1);
        }else{
            return 2*(z + 2 *x + 1);
        }
    }
};