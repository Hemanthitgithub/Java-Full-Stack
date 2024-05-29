package day19;

import java.util.Arrays;

public class TravelingSalesman {
	
	public static int findMinCost(int[][] graph) {
		int n = graph.length;
		int VISITED_All = (1 << n) - 1;
		int[][] dp = new int[n][1 << n];
		
		for(int[] row : dp) {
			Arrays.fill(row,  -1);
		}
		return ts(graph, 0, 1, dp, VISITED_All);
	}
	private static int ts(int[][] graph, int currentCity,int mask, int[][] dp,int VISITED_ALL) {
		if(mask == VISITED_ALL) {
			return graph[currentCity][0];
		}
		if(dp[currentCity][mask] != -1) {
			return dp[currentCity][mask];
		}
		
		int minCost = Integer.MAX_VALUE;
		
		for(int city = 0; city < graph.length;city++) {
			if((mask &(1 << city)) == 0) {
				int newCost = graph[currentCity][city]+ts(graph,city,mask | (1 << city),dp,VISITED_ALL);
				minCost = Math.min(minCost, newCost);
			}
		}
		
		dp[currentCity][mask] = minCost;
		return minCost;
	}
	
	public static void main(String[] args) {
		int[][] graph = {
				{1,20,15,10},
				{20,1,35,25},
				{25,35,1,30},
				{20,25,30,1}
		};
		
		System.out.println("The minimum cost to visit all cities and return to the starting city is:"+findMinCost(graph));
		}
	}
		
	