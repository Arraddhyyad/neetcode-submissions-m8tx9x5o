class Solution {

    List<List<Integer>> soln = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    //Set<Integer> seen = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums);
        return soln;
    }

    public void backtrack(int start, int[] nums){
        soln.add(new ArrayList<>(curr));

        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1])
                continue;

            curr.add(nums[i]);

            backtrack(i+1, nums);

            curr.remove(curr.size()-1);
        }

    }
}
