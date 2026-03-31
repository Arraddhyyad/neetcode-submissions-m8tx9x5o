class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0; int maxL = 0;
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(Collections.max(map.values()) + k >= (r - l + 1))
                maxL = Math.max(maxL, r - l + 1);
            else{
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
        }
        return maxL;
    }
}