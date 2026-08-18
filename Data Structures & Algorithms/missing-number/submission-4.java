class Solution {
    public int missingNumber(int[] nums) {
       int totalSum=0;
       int n=nums.length;
       int reqSum=n*(n+1)/2;
       for(int num:nums){
        totalSum+=num;
       }
       return reqSum-totalSum;
    }
}
