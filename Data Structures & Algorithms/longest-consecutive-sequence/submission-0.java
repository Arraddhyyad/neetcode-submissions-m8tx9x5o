class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> nm = new HashSet<>();

        for(int num: nums)
            if(!nm.add(num))
                continue;
        
        Iterator<Integer> i = nm.iterator();

        int max = 0; 

        while(i.hasNext()){
            int curr = i.next();
            if(nm.contains(curr-1))
                continue;
            else{
                int counter = 1;
                while(nm.contains(curr+1)){
                    counter++;
                    curr = curr + 1;
                }
                max = Math.max(max, counter);
            }
                
        }

        return max;

    }
}
