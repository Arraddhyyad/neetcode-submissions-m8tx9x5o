class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        
        for(int val : freq.values())
            if(val>1)
                return true;
        
        return false;
    }
}