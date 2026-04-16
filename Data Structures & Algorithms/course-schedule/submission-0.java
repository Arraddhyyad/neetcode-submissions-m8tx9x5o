class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for(int i=0; i<numCourses; i++){
            if(!visited.contains(i)){
                if(hasCycle(i, graph, visited, recStack))
                    return false;
            }
        }

        return true;
    }
    public boolean hasCycle(int node, List<List<Integer>> graph, Set<Integer> visited, Set<Integer> recStack){
        visited.add(node);
        recStack.add(node);
        for(int neighbor:graph.get(node)){
            if(recStack.contains(neighbor)) return true;
            if(!visited.contains(neighbor))
                if(hasCycle(neighbor, graph, visited, recStack)) return true;
        }
        recStack.remove(node);
        return false;
    }
}
