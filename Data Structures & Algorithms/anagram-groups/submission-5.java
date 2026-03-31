class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String s : strs)
        {
            char ch[] = new char[26];
            for( char c : s.toCharArray())
            {
                ch[c-'a']++;
            }
            String key = Arrays.toString(ch);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
            return new ArrayList<>(res.values());
    }
}
