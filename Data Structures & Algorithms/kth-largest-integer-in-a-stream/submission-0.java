class KthLargest {

    PriorityQueue<Integer> que;
    int max; 

    public KthLargest(int k, int[] nums) {
      que = new PriorityQueue<>((a,b)-> a-b);
      max = k;
      for(int val: nums){
        add(val);
      }
    }
    
    public int add(int val) {
        que.offer(val);
        if(que.size()>max)
            que.poll();
        return que.peek();
    }
}
