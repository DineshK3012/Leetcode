class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)  return nums[0];
        if(n == 2)  return Math.max(nums[0], nums[1]);
        if(n == 3)  return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int p1 = nums[0];
        int p2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n-1; i++){
            //not robbing the current house
            int ans1 = p2;

            //robbing the current house
            int ans2 = nums[i] + p1;

            p1 = p2;
            p2 = Math.max(ans1, ans2);
        }

        int p3 = nums[1];
        int p4 = Math.max(nums[1], nums[2]);
        for(int i = 3; i<n; i++){
            //not robbing the current house
            int ans1 = p4;

            //robbing the current house
            int ans2 = nums[i] + p3;

            p3 = p4;
            p4 = Math.max(ans1, ans2);
        }

        return Math.max(p2, p4);
    }
}