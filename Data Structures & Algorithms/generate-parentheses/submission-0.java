class Solution {
    public void backTrack(int open,int closed,int n,List<String> res, StringBuilder stack){
        if(open==closed && open==n){
            res.add(stack.toString());
            return;
        }
        if(open<n){
            stack.append('(');
            backTrack(open+1,closed,n,res,stack);
            stack.deleteCharAt(stack.length()-1);
        }
        if(closed<open){
            stack.append(')');
            backTrack(open,closed+1,n,res,stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder stack=new StringBuilder();
        backTrack(0,0,n,res,stack);
        return res;
    }
}
