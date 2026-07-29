class Solution {
    public boolean isPalindrome(String s){
       String res=s.replaceAll("[^a-z0-9A-Z]","");
       int l=0,r=res.length()-1;
       while(l<r){
        String str1=String.valueOf(res.charAt(l));
        String str2=String.valueOf(res.charAt(r));
        if(!str1.equalsIgnoreCase(str2)) return false;
        l++;
        r--;
       }
       return true;
    }
}
