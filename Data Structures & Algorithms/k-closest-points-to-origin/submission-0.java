class Solution {

    PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
        int distA = a[0]*a[0]+a[1]*a[1];
        int distB = b[0]*b[0]+b[1]*b[1];
        return distB - distA;
    });

    public int[][] kClosest(int[][] points, int k) {
        
        for(int[] pt: points){
            que.offer(pt);
            if(que.size()>k)
                que.poll();
        }


        int[][] soln = new int[k][2];
        for(int i=0;i<k; i++){
            soln[i] = que.poll();
        }

        return soln;
    }
}

