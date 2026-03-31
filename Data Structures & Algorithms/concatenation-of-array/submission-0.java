class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ret = new int[nums.length*2];
        for(int i=0; i<ret.length; i++){
            ret[i] = (i>=nums.length)? nums[i-nums.length]:nums[i];
        }
        return ret;
    }
}