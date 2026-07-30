class Solution {
    public int maxNum(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int n:nums){
            max=Math.max(n, max);
        }
        return max;
    }
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int max=maxNum(nums);
        for(int i=1;i<nums.length;i++){
            int diff=nums[i]-nums[i-1];
            if(diff!=1) return nums[i-1]+1;
        }
        return (nums[0]!=0)?0:max+1;
    }
}
