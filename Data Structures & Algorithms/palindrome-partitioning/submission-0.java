class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> sub=new ArrayList<>();
        dfs(0,s,res,sub);
        return res;
    }
    public void dfs(int start, String s, List<List<String>> res, List<String> sub){
        if(start==s.length()){
            res.add(new ArrayList<>(sub));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(isPalindrome(s,start,end)){
                sub.add(s.substring(start,end+1));
                dfs(end+1,s,res,sub);
                sub.remove(sub.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
