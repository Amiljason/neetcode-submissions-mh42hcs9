class Solution {
    public void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void dfs(int[] nums, int idx, List<Integer> subset, List<List<Integer>> res){
        if(idx==nums.length){
            for(int num:nums) subset.add(num);
            res.add(new ArrayList<>(subset));
            subset.clear();
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            dfs(nums,idx+1,subset,res);
            swap(nums,idx,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        dfs(nums,0,subset,res);
        return res;
    }
}
