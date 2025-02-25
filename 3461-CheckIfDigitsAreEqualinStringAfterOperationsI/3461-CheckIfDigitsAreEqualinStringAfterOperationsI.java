class Solution {
    public boolean hasSameDigits(String s) {
        Queue<Integer> q = new LinkedList<>();

        for(char ch: s.toCharArray()){
            q.add(ch-'0');
        }

        while(q.size() > 2){
            int n = q.size();

            for(int i = 0; i<n-1; i++){
                int first = q.remove();
                int second = q.peek();
                // System.out.println(first + " " + second);
                q.add((first + second) % 10);
            }
            q.remove();
        }

        int first = q.remove();
        int second = q.remove();

        // System.out.println(first + " " + second);

        return first == second;
    }
}