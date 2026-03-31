class Solution {
    public boolean isValid(String s) {

        if(s.length()%2 != 0)
            return false;
        
        Stack<Character> st = new Stack<>();

        for(char ch:s.toCharArray()){
            switch(ch){
                case '(': st.push(')');
                break;
                case '{': st.push('}');
                break;
                case '[': st.push(']');
                break;
                default: if(st.isEmpty() ||ch != st.pop()) return false;
            }

        }

        return st.isEmpty();
    }
}
