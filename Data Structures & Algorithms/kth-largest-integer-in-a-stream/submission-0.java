class KthLargest {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    final int K;
    public KthLargest(int k, int[] nums) {
        K=k;
        max=new PriorityQueue<>(Collections.reverseOrder());
        min=new PriorityQueue<>();
        for(int num:nums){
            max.offer(num);
        }
    }
    
    public int add(int val) {
        max.offer(val);
        int i=0;
        while(i!=K-1){
            min.offer(max.poll());
            i++;
        }
        int kThElem=max.peek();
        while(i!=0){
            max.offer(min.poll());
            i--;
        }
        return kThElem;
    }
}
