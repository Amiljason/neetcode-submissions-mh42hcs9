class Solution {
    public int lengthOfLongestSubstring(String s) {
       int len=0;
       int n=s.length(),l=0,r=0,size=0;
       HashSet<Character> set=new HashSet<>();
       while(r<n){
        while(set.contains(s.charAt(r))){
            set.remove(s.charAt(l));
            l++;
        }
        set.add(s.charAt(r));
        size=Math.max(size,r-l+1);
        r++;
       }
       return size;
    }
}
