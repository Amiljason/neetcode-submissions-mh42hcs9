class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        dfs(0,new ArrayList<>(),0,candidates,target);
        return res;
    }
    public void dfs(int idx, List<Integer> path, int currSum, int[] candidates, int target){
        if(currSum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(currSum+candidates[i]>target) break;
            path.add(candidates[i]);
            dfs(i+1,path,currSum+candidates[i],candidates,target);
            path.remove(path.size()-1);
        }
    }
}
