/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;

        Map<Node, Node> graph = new HashMap<>();
        Queue<Node> que = new LinkedList<>();

        que.offer(node);
        graph.put(node, new Node(node.val));

        while(!que.isEmpty()){
            Node curr = que.poll();
            Node currClone = graph.get(curr);

            for(Node neighbor: curr.neighbors){
                if(!graph.containsKey(neighbor)){
                    graph.put(neighbor, new Node(neighbor.val));
                    que.offer(neighbor);
                }
                currClone.neighbors.add(graph.get(neighbor));
            }
        }

        return graph.get(node);
    }
}