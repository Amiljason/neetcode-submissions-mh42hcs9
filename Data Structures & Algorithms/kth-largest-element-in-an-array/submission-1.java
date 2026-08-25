class Solution {
    PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
    public int findKthLargest(int[] nums, int k) {
        for(int num:nums){
            max.offer(num);
        }
        int i=0;
        while(i!=k-1){
            max.poll();
            i++;
        }
        return max.peek();
    }
}
