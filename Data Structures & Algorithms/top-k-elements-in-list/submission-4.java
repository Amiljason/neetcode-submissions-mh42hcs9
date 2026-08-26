class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> max=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            max.offer(new int[]{e.getKey(),e.getValue()});
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            int[] curr=max.poll();
            res[i]=curr[0];
        }
        return res;
    }   
}
