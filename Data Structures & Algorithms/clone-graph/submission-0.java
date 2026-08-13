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
    public Node dfs(Node node , HashMap<Node,Node> map){
        if(node  == null) return null; //  checking if the current node is null;
        if(map.containsKey(node)) return map.get(node); // if node is already present int the map return its clone.
        Node copy = new Node(node.val);// else create a clone of the curr node.
        map.put(node, copy); // add it to the map
        for(Node nei: node.neighbors){
            copy.neighbors.add(dfs(nei, map));// add the clone of it's neighbors to it's clone  
        }
        return copy; // reutrn the deep copy
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>(); // map stores the originals , clones of each node.
        return dfs(node, map);
    }
}