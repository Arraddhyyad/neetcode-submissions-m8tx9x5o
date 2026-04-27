class Solution {
    static int[] parent, rank;

    static int find(int x){
        if(parent[x]!=x)
            parent[x]=find(parent[x]);
        return parent[x];
    }

    static boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px==py) return false;

        if(rank[px]<rank[py]) parent[px] = py;
        else if(rank[py]<rank[px]) parent[py] = px;
        else {  parent[py] = px;
        rank[px]++; }

        return true;
    }

    public int minCostConnectPoints(int[][] points) {
       int n = points.length;
       parent = new int[n+1];
       rank = new int[n+1];
       for(int i=0; i<n; i++) parent[i]=i;

       int[][] edges = new int[n*(n-1)/2][3];
       int ind = 0;
       for(int i=0; i<n-1; i++){
        for(int j=i+1; j<n; j++){
            int dist = Math.abs(points[i][0] - points[j][0])
                    + Math.abs(points[i][1] - points[j][1]);
            edges[ind++] = new int[]{dist, i, j};
        }
       }
       Arrays.sort(edges, Comparator.comparingInt(a->a[0]));

       int totalWeight = 0;
       int edgesUsed = 0;

       for(int[] edge: edges){
            int w = edge[0],
                u = edge[1],
                v = edge[2];

            if(union(u,v)){
                totalWeight+=w;
                edgesUsed++;
                if(edgesUsed == n-1) break;
            }
       }

       return edgesUsed == n-1? totalWeight:-1;
       
    }
}
