class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int i = 0; int maxL = 0; int len = 0;
        for(int j = 0; j<s.length(); j++){
            if(seen.containsKey(s.charAt(j)))
                i = Math.max(i, seen.get(s.charAt(j))+1);

            seen.put(s.charAt(j), j);
            len = j-i+1;
            maxL = Math.max(maxL, len);    
        }

        return maxL;
    }
}
