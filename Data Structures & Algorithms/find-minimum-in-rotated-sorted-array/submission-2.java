class Solution {
    public int findMin(int[] nums) {
     int l=0,r=nums.length-1;
     int ans=nums[l];
     while(l<=r){
        int mid = l+(r-l)/2;
        if(nums[l]<nums[r]){
            ans = Math.min(ans, nums[l]);
            break;
        }
        ans=Math.min(ans, nums[mid]);
        if(nums[mid]>=nums[l]) l=mid+1;
        else r=mid-1;
     }
     return ans;   
    }
}
