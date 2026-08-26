class Solution {
    public boolean isAnagram(String s, String t) {
         char[] str=s.toCharArray();
        char[] target=t.toCharArray();
        Arrays.sort(str);
        Arrays.sort(target);
        String nt=new String(target);
        String ns=new String(str);
        return (ns.equals(nt))?true:false;
    }
}
