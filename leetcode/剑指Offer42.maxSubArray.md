```java
class Solution {
    public int maxSubArray(int[] nums) {
        //dp[i]表示以i结尾的最大连续子序和 dp[i] = max(dp[i - 1] + nums[i], nums[i])
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```

