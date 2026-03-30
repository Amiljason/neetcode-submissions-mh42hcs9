class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        List<List<String>> res=new ArrayList<>();
        for(String word:strs){
            List<Character> chars=new ArrayList<>();
            for(char c:word.toCharArray()){
                chars.add(c);
            }
            Collections.sort(chars);
            String sortedKey="";
            for(char c:chars){
                sortedKey+=c;
            }
            if(map.containsKey(sortedKey)) map.get(sortedKey).add(word);
            else{
                ArrayList<String> list=new ArrayList<>();
                list.add(word);
                map.put(sortedKey, list);
            }
        }
        for(Map.Entry<String, ArrayList<String>> e:map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}
