class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0;
        int maxLen=1;
        for(int i=0;i<n;i++){
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                int len=r-l+1;
                if(len>maxLen){
                    maxLen=len;
                    start=l;
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                int len=r-l+1;
                if(len>maxLen){
                    maxLen=len;
                    start=l;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, start+maxLen);
    }
}
