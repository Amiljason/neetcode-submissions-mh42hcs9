class Solution {
    public int helper(int[] nums){
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int homes=nums.length;
        int[] dp=new int[homes];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<homes;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[homes-1];
    }
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==3){
            return Math.max(nums[0], Math.max(nums[1],nums[2]));
        }
        int[] street1=new int[nums.length-1];
        int[] street2=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            street1[i]=nums[i];
        }
        for(int i=1;i<nums.length;i++){
            street2[i-1]=nums[i];
        }
        return Math.max(helper(street1), helper(street2));
    }
}
