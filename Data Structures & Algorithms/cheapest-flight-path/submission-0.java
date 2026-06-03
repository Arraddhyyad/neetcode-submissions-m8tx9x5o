class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        int stops = 0;

        for(int i=0; i<n; i++){
            dist[i]=(i==src)?0: Integer.MAX_VALUE;
        }

        for(int i=0; i<=k; i++){
        int[] temp = dist.clone();
            for(int[] flight: flights){
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<temp[v])
                    temp[v]=dist[u]+w;
            }
        dist = temp;
        }

        if(dist[dst]!=Integer.MAX_VALUE)
            return dist[dst];
        else return -1;
    }
}
