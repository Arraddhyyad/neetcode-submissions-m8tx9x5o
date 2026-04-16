class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (hasCycleAndSortDFS(i, graph, visited, recStack, stack)) {
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];
        int ind = 0;
        while (!stack.isEmpty()) {
            res[ind++] = stack.pop();
        }
        
        return res;
    }

    public boolean hasCycleAndSortDFS(int node, List<List<Integer>> graph, Set<Integer> visited, Set<Integer> recStack, Stack<Integer> stack) {
        visited.add(node);
        recStack.add(node);

        for (int neighbor : graph.get(node)) {
            if (recStack.contains(neighbor)) return true;
            if (!visited.contains(neighbor)) {
                if (hasCycleAndSortDFS(neighbor, graph, visited, recStack, stack)) return true;
            }
        }

        recStack.remove(node);
        stack.push(node);
        return false;
    }
}