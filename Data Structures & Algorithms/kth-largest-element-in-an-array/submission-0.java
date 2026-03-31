class Solution {
    PriorityQueue<Integer> que = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for(int num: nums){
            que.offer(num);
            if(que.size()>k)
                que.poll();
        }
        return que.poll();
    }
}
