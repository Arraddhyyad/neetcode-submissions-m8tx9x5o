class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<>();
        String wrd, wrd2;

        Set<String> processed = new HashSet<>();

        for(int i=0; i<strs.length; i++){

            wrd = strs[i];

            if(processed.contains(wrd))
            continue;

            ArrayList<String> str = new ArrayList<>();
            str.add(wrd);
            processed.add(wrd);

            for(int j = i+1; j<strs.length; j++){
                wrd2 = strs[j];
                if(isAnagram(wrd, wrd2)){
                      str.add(wrd2); processed.add(wrd2);
                }   
                  
            }
            res.add(str);
        }
        return res;
    }

    public boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        Map<Character, Integer> mymap1 = new TreeMap<>();
        Map<Character, Integer> mymap2 = new TreeMap<>();

        for(char ch : str1.toCharArray())
            mymap1.put(ch, mymap1.getOrDefault(ch, 0)+1);

        for(char ch : str2.toCharArray())
            mymap2.put(ch, mymap2.getOrDefault(ch, 0)+1);

        return mymap1.equals(mymap2);
    }
}
