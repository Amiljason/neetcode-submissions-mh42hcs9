class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Integer> map=new HashMap<>();
        HashSet<Character>set=new HashSet<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            set.add(c);
        }
        for(char c:set){
            if(!map.containsKey(c))return false;
            else{
                int freq=0;
                for(int i=0;i<t.length();i++){
                    if(t.charAt(i)==c)freq++;
                }
                if(map.get(c)!=freq)return false;
            }
        }
        return true;
    }
}
