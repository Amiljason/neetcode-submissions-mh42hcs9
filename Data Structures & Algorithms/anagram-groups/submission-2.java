class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String , ArrayList<String>> map=new HashMap<>();
       for(String s:strs){
        char[] letters=s.toCharArray();
        Arrays.sort(letters);
        String key=new String(letters);
        if(!map.containsKey(key)){
            ArrayList<String> l=new ArrayList<>();
            l.add(s);
            map.put(key,l);
        } 
        else{
            map.get(key).add(s);
        }
       }
       List<List<String>> gA=new ArrayList<>();
       for(Map.Entry<String, ArrayList<String>> e:map.entrySet()){
        gA.add(e.getValue());
       }
       return gA;
    }
}
