class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int idx=0;
        for(int i=0;i<n;i++){
            if(i>idx) return false;
            idx=Math.max(idx,i+nums[i]);
        }
        return true;
    }
}
