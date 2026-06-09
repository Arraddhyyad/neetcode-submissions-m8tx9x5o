class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len-1];
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<len-1; i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        int[] pd = new int[len-1];
        pd[0] = nums[1];
        pd[1] = Math.max(nums[1], nums[2]);

        for(int i=2; i<len-1; i++)
        {
            pd[i]=Math.max(pd[i-1], pd[i-2]+nums[i+1]);
        }


        return Math.max(dp[len-2], pd[len-2]);
    }
}
