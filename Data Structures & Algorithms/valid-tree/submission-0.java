class Solution {
    public boolean validTree(int n, int[][] edges) {
        //every node must be reachable, so only one connected component
        //acyclic, so no cycles at all
        //edge count rule so for n nodes, a valid tree must have exactly n-1 edges
        if(edges.length!=n-1) return false;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        //Stack<Integer> st = new Stack<>();

        // for(int i=0; i<n; i++){
        //     if(!visited.contains(i))
        //         if(hasCycle(i, graph, visited, st)) return false;
        // } if we really have to iterate from every node then it might as well have components>1

        if(hasCycle(0, -1, graph, visited)) return false;

        return visited.size()==n;

        }

        public boolean hasCycle(int node, int parent, List<List<Integer>> graph, Set<Integer> visited){
            visited.add(node);
            //st.push(node);

            for(int neighbor: graph.get(node)){
                if(neighbor == parent) continue;

                if(visited.contains(neighbor)) return true;

                if(hasCycle(neighbor, node, graph, visited)) return true;
            }

            return false;
        }
    }

