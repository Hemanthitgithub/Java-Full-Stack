package day15;

import java.util.*;

public class GraphCycleDetection {
    private int vertices;
    private List<Edge> edges;

    public GraphCycleDetection(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));
    }

    public boolean hasCycle() {
        UnionFind unionFind = new UnionFind(vertices);

        for (Edge edge : edges) {
            if (!unionFind.union(edge.src, edge.dest)) {
                return true; // Cycle detected
            }
        }

        return false;
    }

    private static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }

        public boolean union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 == root2) {
                return false; // Cycle detected
            }

            // Union by rank
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        GraphCycleDetection graph = new GraphCycleDetection(4);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        if (graph.hasCycle()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}