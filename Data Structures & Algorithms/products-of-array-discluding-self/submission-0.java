class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];
        
        int pre = 1, idx1 = 1;
        prefix[0] = 1;
        for(int i = 0; i < nums.length - 1; i++){
            pre = pre * nums[i];
            prefix[idx1++] = pre;
        }

        int suf = 1, idx2 = nums.length - 2;
        suffix[nums.length-1] = 1;
        for(int j = nums.length - 1; j > 0; j--){
            suf = suf * nums[j];
            suffix[idx2--] = suf;
        }

        int soln[] = new int[nums.length];
        for(int i = 0; i < soln.length; i++){
            soln[i] = prefix[i] * suffix[i];
        }

        return soln;
    }
}