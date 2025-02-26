class Solution {
    private String rle(String s){
        StringBuilder str = new StringBuilder();
        int count = 0;
        char prev = '-';
        for(char ch: s.toCharArray()){
            if(prev == ch){
                count++;
            }else{
                if(prev != '-'){
                    str.append(count).append(prev);
                }
                count = 1;
                prev = ch;
            }
        }
        str.append(count).append(prev);

        return str.toString();
    }

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }

        String s = countAndSay(n-1);

        return rle(s);
    }
}