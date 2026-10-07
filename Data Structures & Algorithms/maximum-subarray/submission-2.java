class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int res=nums[0];
        int maxEnding = nums[0];
        for(int i=1;i<nums.length;i++){
            maxEnding = Math.max(maxEnding+nums[i],nums[i]);
            res = Math.max(res, maxEnding);
        }
        return res; 
    }
}
