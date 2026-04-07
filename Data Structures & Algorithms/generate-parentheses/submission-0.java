class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtrack(0,0, n);
        return res;
    }

    public void backtrack(int open, int close, int n){
        if(sb.length() == 2*n){
                res.add(sb.toString());
                return;
        }

        if(open<n){
            sb.append('(');
            backtrack(open+1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close<open){
            sb.append(')');
            backtrack(open, close+1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
