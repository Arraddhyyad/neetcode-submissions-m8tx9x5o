class Solution {
    int count = 0;
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }
        Set<Integer> visited = new HashSet<>();
        //Stack<Integer> path = new Stack<>(); looks like we only need path stack if we 
                                            // want to store sequence of transversal

        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                count++;
                makeChain(i, graph, visited);
            }
               
        }

        return count;
    }

    public void makeChain(int node, List<List<Integer>> graph, Set<Integer> visited){
        visited.add(node);
     //   path.add(node);

        for(int neighbor: graph.get(node)){
            if(!visited.contains(neighbor))
                makeChain(neighbor, graph, visited);
        }

       // path.remove(node);
    }
}
