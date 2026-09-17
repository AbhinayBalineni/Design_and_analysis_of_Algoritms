import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class KruskalAlgorithm {

    // Find the parent of a vertex
    static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    // Union two sets
    static void union(int[] parent, int u, int v) {
        int rootU = find(parent, u);
        int rootV = find(parent, v);

        parent[rootU] = rootV;
    }

    static void kruskal(int vertices, ArrayList<Edge> edges) {

        // Sort edges by weight
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[vertices];

        // Initially, every vertex is its own set
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int mstWeight = 0;
        int edgeCount = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        for (Edge edge : edges) {
            int rootU = find(parent, edge.src);
            int rootV = find(parent, edge.dest);

            // If adding this edge does not create a cycle
            if (rootU != rootV) {
                System.out.println(
                    edge.src + " -- " + edge.dest + " = " + edge.weight
                );

                mstWeight += edge.weight;
                union(parent, rootU, rootV);
                edgeCount++;

                // MST contains V - 1 edges
                if (edgeCount == vertices - 1) {
                    break;
                }
            }
        }

        System.out.println("Minimum Cost = " + mstWeight);
    }

    public static void main(String[] args) {

        int vertices = 4;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        kruskal(vertices, edges);
    }
}