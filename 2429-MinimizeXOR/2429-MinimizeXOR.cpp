class Solution {
public:
    int minimizeXor(int num1, int num2) {
        int x = 0, setBits = __builtin_popcount(num2);

        for(int i = 31; i>=0 && setBits > 0; i--){
            if(num1 & (1 << i)){
                x |= (1 << i);
                setBits--;
            }
        }


        for(int i = 0; i<32 && setBits > 0; i++){
            if(!(x & (1 << i))){
                x |= (1 << i);
                setBits--;
            }
        }

        return x;
    }
};