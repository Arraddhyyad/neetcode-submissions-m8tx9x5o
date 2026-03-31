class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        //ArrayList<Integer> soln = new ArrayList<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->freq.get(a)-freq.get(b));

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        for(int val: freq.keySet()){
            minHeap.offer(val);

            if(minHeap.size()>k)
            minHeap.poll();
        }

        int soln[] = new int[k]; int i = 0;
        while(!minHeap.isEmpty()){
            soln[i++] = minHeap.poll();
        }
        
        return soln;

    }
}
