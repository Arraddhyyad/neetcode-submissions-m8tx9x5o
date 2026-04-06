class Solution {
    List<List<Integer>> soln = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return soln;
    }

    public void backtrack(int[] nums, boolean used[]){
        if(curr.size() == nums.length){
            soln.add(new ArrayList<>(curr));
            return;
        }
            
        for(int i=0; i<nums.length; i++){
         if(used[i]==true)
            continue;

         curr.add(nums[i]);
         used[i]=true;
         
         backtrack(nums, used);

         curr.remove(curr.size()-1);
         used[i]=false;
        }
    }
}
