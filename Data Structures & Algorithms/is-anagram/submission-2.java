class Solution {
    public boolean isAnagram(String s, String t) {
        int m=t.length();
        int n=s.length();
        if(n!=m) return false;
        char[] arr1 = new char[n];
       for(int i=0;i<s.length();i++){
            arr1[i] = s.charAt(i);
       }
       HashMap<Character, Integer> map=new HashMap<>();
       for(char c:arr1){
        map.put(c,map.getOrDefault(c,0)+1);
       }
       for(int i=0;i<m;i++){
        char c=t.charAt(i);
        if(!map.containsKey(c)) return false;
        else{
            int count = map.get(c)-1;
            map.put(c,count);
        }
       }
       for(Map.Entry<Character, Integer> e: map.entrySet()){
        if(e.getValue()>0) return false;
       }
       return true; 
    }
}
