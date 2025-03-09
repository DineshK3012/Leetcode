class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[][] temp = new long[n][3];
        for (int i = 0; i < n; i++) {
            temp[i][0] = (long) nums1[i];
            temp[i][1] = (long) nums2[i];
            temp[i][2] = 0; // Initialize the third column
        }

        Arrays.sort(temp, (a, b) -> Long.compare(a[0], b[0]));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashMap<Long, Long> map = new HashMap<>();

        pq.add(temp[0][1]); // Add the first nums2 value
        long sum = temp[0][1];
        map.put(temp[0][0], 0L); // Initialize the map with the first nums1 value

        for (int i = 1; i < n; i++) {
            if (temp[i][0] != temp[i - 1][0]) {
                temp[i][2] = sum;
            } else {
                temp[i][2] = temp[i - 1][2];
            }

            map.put(temp[i][0], temp[i][2]);

            sum += temp[i][1];
            pq.add(temp[i][1]);

            if (pq.size() > k) {
                sum -= pq.poll();
            }
        }

        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get((long) nums1[i]);
        }

        return ans;
    }
}