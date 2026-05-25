class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i=1;i<=n; i++){
            int curr = i;
            int count = 0;
            while(curr!=0){
                curr = curr & (curr-1);
                count++;
            }
            res[i]=count;
        }

        return res;
    }
}
