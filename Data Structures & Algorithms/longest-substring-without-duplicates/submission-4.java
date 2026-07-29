class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(" ")) return 1;
        if(s.length()==1) return 1;
        StringBuilder sb=new StringBuilder();
        int len=0;
        int l=0,r=0,n=s.length();
        while(r<n){
            String str=String.valueOf(s.charAt(r));
            if(sb.indexOf(str)==-1){
                sb.append(str);
                r++;
                }
            else{
                sb.setLength(0);
                l++;
                r=l;
            }
            len=Math.max(len,sb.length());
        }
        return len;
    }
}
