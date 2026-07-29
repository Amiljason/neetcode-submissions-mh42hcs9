class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return 1;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        int longest=Integer.MIN_VALUE;
        for(int num:set){
            if(!set.contains(num-1)){
                int curr=num;
                int count=1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest=Math.max(longest, count);
            }
        }
        return longest;
    }
}
