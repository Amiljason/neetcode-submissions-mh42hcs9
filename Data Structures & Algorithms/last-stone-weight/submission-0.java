class Solution {
    PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int stone:stones){
            max.offer(stone);
        }
        while(max.size()>=2){
            int first=max.poll();
            int second=max.poll();
            if(first<second){
                max.offer(second-first);
            }
            else if(first>second){
                max.offer(first-second);
            }
        }
        return (max.isEmpty())?0:max.poll();
    }
}
