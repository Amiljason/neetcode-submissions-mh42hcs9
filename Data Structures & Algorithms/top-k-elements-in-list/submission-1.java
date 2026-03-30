class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        } 
        while(!map.isEmpty()){
            int maxKey=0;
            int maxFreq=Integer.MIN_VALUE;
            for(Map.Entry<Integer,Integer> e:map.entrySet()){
                if(e.getValue()>maxFreq){
                    maxFreq=e.getValue();
                    maxKey=e.getKey();
                }
            }
            res.add(maxKey);
            map.remove(maxKey); 
        }
        int[] arr=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        int[] ans=new int[k];
        int i=0;
        while(k!=0){
            ans[i]=arr[i];
            k--;
            i++;
        }
        return ans;
    }   
}
