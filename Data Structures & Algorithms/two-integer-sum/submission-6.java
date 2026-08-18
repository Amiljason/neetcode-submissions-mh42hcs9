class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] arr=new int[2];
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        map.put(nums[i],i);
       }
       for(int i=0;i<nums.length;i++){
        int need=target-nums[i];
        if(map.containsKey(need) && map.get(need)!=i){
            arr[0]=Math.min(map.get(need),i);
            arr[1]=Math.max(map.get(need),i);
        }   
       }
       return arr;
    }
}
