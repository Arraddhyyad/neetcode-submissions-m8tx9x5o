class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length())
            return false;
        
        int[] freq_s1 = new int[26];
        freq_s1 = freq_count(s1);
        
        int j = s1.length()-1;
        for(int i=0; i<=s2.length()-s1.length();i++){
            int[] freq_s2 = new int[26];
            freq_s2 = freq_count(s2.substring(i, j+1));
            if(Arrays.equals(freq_s1, freq_s2))
                return true;
            else
                j++;
        }

        return false;
    }

    public int[] freq_count(String str){
        int freq[] = new int[26];
        for(char ch: str.toCharArray()){
            freq[ch - 'a']++;
        }
        return freq;
    }
}
