class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i], i);
        }
        int[] arr=new int[2];
        for(int i=0;i<n;i++){
            int req = target-nums[i];
            if(map.containsKey(req) && map.get(req)!=i){
                arr[0] = Math.min(map.get(req), i);
                arr[1] = Math.max(map.get(req), i);
                return arr;
            }
        }
        return arr;
    }
}
