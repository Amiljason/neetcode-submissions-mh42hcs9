class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
       HashSet<Integer> set=new HashSet<>();
       for(int num:nums) set.add(num);
       int longest=Integer.MIN_VALUE;
       for(int num:set){
        if(!set.contains(num-1)){
            int current=num;
            int count=1;
            while(set.contains(current+1)){
                current++;
                count++;
            }
            longest=Math.max(longest, count);
        }
       }
       return longest;
    }
}
