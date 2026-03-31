class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())
            return false;

        Map<Character, Integer> mymap1 = new TreeMap<>();
        Map<Character, Integer> mymap2 = new TreeMap<>();


        for(char ch: s.toCharArray()){
           mymap1.put(ch, mymap1.getOrDefault(ch, 0)+1);
        }

        for(char ch: t.toCharArray()){
           mymap2.put(ch, mymap2.getOrDefault(ch, 0)+1);
        }

        return mymap1.equals(mymap2);


    }

   
}
