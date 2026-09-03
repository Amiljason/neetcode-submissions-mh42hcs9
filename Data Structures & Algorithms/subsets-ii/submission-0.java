class Solution {
    public void dfs(List<List<Integer>> res,int start,List<Integer> subset,int[] nums){
        res.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            dfs(res,i+1,subset,nums);
            subset.remove(subset.size()-1);
        }
        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        dfs(res,0,subset,nums);
        return res;
    }
}
