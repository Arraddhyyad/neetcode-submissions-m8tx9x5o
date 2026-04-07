class Solution {
    List<List<Integer>> soln = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
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
            curr.add(nums[i]);
            backtrack(nums, sum+nums[i], target, i);
            curr.remove(curr.size()-1);
        }

    }
}
