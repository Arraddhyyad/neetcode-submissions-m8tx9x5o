class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;

        int[][] car = new int[n][2];

        for(int i = 0; i<n; i++){
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        Arrays.sort(car, (a,b)->(b[0]-a[0]));
        double prevT = 0;
        int fleet = 0; 

        for(int i =0; i<n; i++){
            double time = (double)(target - car[i][0])/car[i][1];
            if(time>prevT){
                fleet++;
                prevT = time;
            }

        }

        return fleet;

    }
}
