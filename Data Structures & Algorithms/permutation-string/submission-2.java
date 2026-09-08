class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] str1=s1.toCharArray();
        Arrays.sort(str1);
        String ns1=new String(str1);
        int wL=ns1.length();
        int len=s2.length();
        int left=0;
        while(left+wL<=len){
            String ss2=s2.substring(left,left+wL);
            char[] str2=ss2.toCharArray();
            Arrays.sort(str2);
            String ns2=new String(str2);
            if(ns1.equals(ns2)) return true;
            left++;
        }
        return false;
    }
}
