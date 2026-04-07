class Solution {
    List<List<Integer>> soln = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        //boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, 0, target, 0);
        return soln;
    }

    public void backtrack(int[] nums, int sum, int target, int start){
        if(sum == target){
             soln.add(new ArrayList<>(curr));
             return;
        }
           
        if(sum>target)
            return;

        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1])
                continue;

            curr.add(nums[i]);
            
            backtrack(nums, sum+nums[i], target, i+1);

            curr.remove(curr.size()-1);
        }

    }
}
