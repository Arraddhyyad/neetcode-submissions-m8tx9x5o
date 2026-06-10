class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
    }

    public int dfs(String s, int i, int[] memo){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(memo[i]!=-1) return memo[i];
        
        int res = dfs(s, i+1, memo);

        if(i+1<s.length() && 
        (s.charAt(i)=='1'|| (s.charAt(i)=='2'&& s.charAt(i+1)<='6')))
        {
            res+=dfs(s, i+2, memo);
        }

        return memo[i] = res;
    }
}
