class Solution {
    public List<String> res=new ArrayList<>();
    public String[] digitToChar=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backTrack(0,"",digits);
        return res;
    }
    public void backTrack(int idx, String sub, String digits){
        if(sub.length()==digits.length()){
            res.add(sub);
            return;
        }
        String chars=digitToChar[digits.charAt(idx)-'0'];
        for(char c:chars.toCharArray()){
            backTrack(idx+1,sub+c,digits);
        }
    }
}
