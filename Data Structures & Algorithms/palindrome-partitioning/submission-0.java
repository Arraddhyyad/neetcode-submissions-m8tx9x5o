class Solution {
    List<List<String>> soln = new ArrayList<>();
    List<String> curr = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
       backtrack(0, s);
       return soln; 
    }

    public void backtrack(int start, String str){
        if(start==str.length()){
            soln.add(new ArrayList<>(curr));
            return;}
        
        for(int end=start; end<str.length(); end++){
            if(isPalindrome(start, end, str)){
                curr.add(str.substring(start, end+1));

                backtrack(end+1, str);

                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(int start, int end, String str){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
