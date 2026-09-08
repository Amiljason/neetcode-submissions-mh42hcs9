class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n=nums.length,l=0,r=0;
       int[] output=new int[n-k+1];
       Deque<Integer> dq=new LinkedList<>();
       while(r<n){
        while(!dq.isEmpty() && nums[dq.getLast()]<nums[r]) dq.removeLast();
        dq.addLast(r);
        if(l>dq.getFirst()) dq.removeFirst();
        if((r+1)>=k){
            output[l]=nums[dq.getFirst()];
            l++;
        }
        r++;
       }
       return output;
    }
}
