class Solution {
    public int maxFreq(HashMap<Integer, Integer> map,HashSet<Integer> set){
        Iterator<Integer> iter = set.iterator();
        int max=iter.next();
        while(iter.hasNext()){
            int curr=iter.next();
            if( map.get(curr) > map.get(max)){
                max=curr;
            }
        }
        return max;
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr=new int[k];
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int i=0;
        while(i<k){
            int currMax=maxFreq(map,set);
            arr[i]=currMax;
            map.remove(currMax,map.get(currMax));
            set.remove(currMax);
            i++;
        }
        return arr;
    }   
}
