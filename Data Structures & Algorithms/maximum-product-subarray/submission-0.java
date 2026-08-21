class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int newMax=Math.max(nums[i],Math.max(min*nums[i],max*nums[i]));
            int newMin=Math.min(nums[i],Math.min(max*nums[i],min*nums[i]));
            max=newMax;
            min=newMin;
            ans=Math.max(ans,max);
        }
        return ans;
    }
}
