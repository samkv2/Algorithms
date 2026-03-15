import java.util.*;

public class RouteBetweenNodes {
    enum State { Unvisited, Visiting, Visited; }

    static class Node {
        public List<Node> adjacent = new ArrayList<>();
        public String name;
        public State state = State.Unvisited;

        public Node(String name) {
            this.name = name;
        }

        public void addAdjacent(Node x) {
            this.adjacent.add(x);
        }
    }

    static class Graph {
        public List<Node> nodes = new ArrayList<>();

        public void addNode(Node x) {
            this.nodes.add(x);
        }
    }

    public static boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        LinkedList<Node> q = new LinkedList<>();

        for (Node u : g.nodes) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.adjacent) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        g.addNode(a); g.addNode(b); g.addNode(c); g.addNode(d);

        a.addAdjacent(b);
        b.addAdjacent(c);
        c.addAdjacent(a);
        
        System.out.println("Path a to c: " + search(g, a, c)); // Expected: true
        System.out.println("Path a to d: " + search(g, a, d)); // Expected: false
    }
}
