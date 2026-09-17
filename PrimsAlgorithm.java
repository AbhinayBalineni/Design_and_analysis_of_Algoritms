import java.util.*;

public class PrimsAlgorithm {

    static void prim(int[][] graph, int vertices) {

        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        boolean[] visited = new boolean[vertices];

        // Initialize all keys to infinity
        Arrays.fill(key, Integer.MAX_VALUE);

        // Start from vertex 0
        key[0] = 0;
        parent[0] = -1;

        int totalCost = 0;

        for (int count = 0; count < vertices; count++) {

            // Find the vertex with minimum key value
            int u = -1;

            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }

            // Mark vertex as visited
            visited[u] = true;

            // Update adjacent vertices
            for (int v = 0; v < vertices; v++) {

                if (graph[u][v] != 0 &&
                    !visited[v] &&
                    graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edges in Minimum Spanning Tree:");

        for (int i = 1; i < vertices; i++) {
            System.out.println(
                parent[i] + " -- " + i + " = " + key[i]
            );

            totalCost += key[i];
        }

        System.out.println("Minimum Cost = " + totalCost);
    }

    public static void main(String[] args) {

        int vertices = 4;

        int[][] graph = {
            {0, 10, 6, 5},
            {10, 0, 0, 15},
            {6, 0, 0, 4},
            {5, 15, 4, 0}
        };

        prim(graph, vertices);
    }
}