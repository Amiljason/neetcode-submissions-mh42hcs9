class Solution {
    public int characterReplacement(String s, int k) {
       HashSet<Character> set = new HashSet<>();
       int len=0;
       for(int i=0;i<s.length();i++){
        set.add(s.charAt(i));
       }
       int n=s.length();
       for(char c:set){
        int l=0,count=0;
        for(int r=0;r<n;r++){
            if(s.charAt(r)==c) count++;
        
            while((r-l+1)-count>k){
                if(s.charAt(l)==c) count--;
                l++;
            }
            len = Math.max(len,(r-l+1));
        }
       }
       return len;
    }
}
