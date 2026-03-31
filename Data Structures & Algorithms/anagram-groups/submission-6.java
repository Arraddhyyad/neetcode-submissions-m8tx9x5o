class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mymap = new HashMap<>();

        for(String str: strs){
            char arr[] = new char[26];
            for(char ch : str.toCharArray()){
                arr[ch-'a']++;
            }
            String key = Arrays.toString(arr);
            mymap.putIfAbsent(key, new ArrayList());
            mymap.get(key).add(str);
        }

        return new ArrayList<>(mymap.values());

    }
}
