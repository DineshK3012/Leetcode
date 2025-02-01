class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int curr = 0;
        for(int i = 0; i<k; i++){
            curr += (endTime[i] - startTime[i]);
        }

        if(k == n){
            return eventTime - curr;   
        }

        int prev = -1;
        int max = 0;
        for(int i = k; i < startTime.length; i++){
            int start = prev == -1 ? 0: endTime[prev];
            int end = startTime[i] - curr;
            
            max = Math.max(max, (end - start));
            // System.out.println(i + " " + max);

            curr -= (endTime[i-k] - startTime[i-k]);
            curr += (endTime[i] - startTime[i]);
            prev = i-k;
        }
        int start = prev == -1 ? 0: (endTime[prev] + curr);
        int end = eventTime;
        max = Math.max(max, (end - start));

        return max;
    }
}