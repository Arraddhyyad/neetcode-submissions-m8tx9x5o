class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> all = new ArrayList<>(Arrays.asList(intervals));
        all.add(newInterval);                                 
        all.sort((a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] current = all.get(0);

        for (int i = 1; i < all.size(); i++) {
            if (all.get(i)[0] <= current[1]) {
                current[1] = Math.max(current[1], all.get(i)[1]); 
            } else {
                merged.add(current);
                current = all.get(i);
            }
        }
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);        
    }
}