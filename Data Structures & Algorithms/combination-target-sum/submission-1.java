class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    public void cB(int[] nums, int i,List<Integer> c,List<List<Integer>> list,int target){
        if(target==0 && !set.contains(new ArrayList<>(c))) {
            list.add(new ArrayList<>(c));
            set.add(new ArrayList<>(c)); 
            return;
        }
        if(i==nums.length||target<0) return ;
        c.add(nums[i]);
        //cB(nums,i+1,c,list,target-nums[i]);
        cB(nums,i,c,list,target-nums[i]);
        c.remove(c.size()-1);
        cB(nums,i+1,c,list,target);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> c=new ArrayList<>();
        // for(int n:nums){
        //     if(n==target) list.add(List.of(target));
        // }

        int i=0;
        cB(nums,i,c,list,target);
        return list;

    }
}
