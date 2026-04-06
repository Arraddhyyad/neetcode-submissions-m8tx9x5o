class Solution {
    List<List<Integer>> soln = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       backtrack(0, nums);
       return soln;
    }

    public void backtrack(int start, int[] nums){
        soln.add(new ArrayList<>(curr));

        for(int i=start;i<nums.length;i++){

            curr.add(nums[i]);

            backtrack(i+1, nums);

            curr.remove(curr.size()-1);     
        }
    }
}
