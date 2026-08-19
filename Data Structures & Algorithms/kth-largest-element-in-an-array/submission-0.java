class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.offer(num);
        }
        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            int curr=pq.poll();
            list.add(curr);
        }
        return list.get(k-1);
    }
}
