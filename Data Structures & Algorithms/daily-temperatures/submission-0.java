class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] soln = new int[temperatures.length];

        Stack<Integer> st = new Stack<Integer>();
        st.push(0);

        for(int i=1; i<temperatures.length; i++){

            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                soln[st.peek()]=i-st.peek();
                st.pop();
            }

            st.push(i);     
        }

        while(!st.isEmpty()){
             soln[st.peek()]=0;
             st.pop();
        }
           

        return soln;
    }
}
