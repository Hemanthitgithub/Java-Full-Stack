package day15;

import java.util.*;

public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            int minDist = INF;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[minIndex][j] != 0 && dist[minIndex] != INF &&
                        dist[minIndex] + graph[minIndex][j] < dist[j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                }
            }
        }

        printSolution(dist, start);
    }

    private static void printSolution(int[] dist, int start) {
        System.out.println("Shortest Path from node " + start + " to:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Node " + i + ": Distance = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {5, 0, 0, 9, 0, 10, 7, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {6, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0);
    }
}