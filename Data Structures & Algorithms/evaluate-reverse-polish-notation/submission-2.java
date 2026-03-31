class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
       // String dig = "0123456789";
        String op = "+-*/";
        for(String str : tokens){
            if(op.indexOf(str)==-1)
            st.push(Integer.parseInt(str));
            else if(op.indexOf(str)!=-1)
            {
                int b = st.pop();
                int a = st.pop();
                int res = 0;
                switch(str){
                    case "+": res = a+b; break;
                    case "-": res = a-b; break;
                    case "*": res = a*b; break;
                    case "/": res = a/b; break;
                }
                st.push(res);
            }

        }

        return st.pop();
    }
}
