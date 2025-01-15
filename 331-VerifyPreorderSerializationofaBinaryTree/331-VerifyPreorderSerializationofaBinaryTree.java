class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        int vacancy = 1;
        for(String s: nodes){
            if(vacancy == 0){
                return false;
            }

            if(s.equals("#")){
                vacancy--;
            }else{
                vacancy++;
            }
        }

        return vacancy == 0;
    }
}