package day20;

public class KnapSack {
	
	public static int knapSack(int W, int[] weights,int[] values) {
		int n = weights.length;
		int[][] dp = new int[n+1][W+1];
		
		for(int i=1;i<=n;i++) {
			for(int w=0;w<=W;w++){
				if(weights[i-1]<=w){
					dp[i][W]=Math.max(dp[i-1][W], dp[i-1][w-weights[i-1]]+values[i-1]);
				}else {
					dp[i][w]=dp[i-1][w];
			}
		}
	}
		return dp[n][W];
	}

	public static void main(String[] args) {
		int W=50;
		int[] weights = {10,20,30};
		int[] values = {600,1000,225};
		
		int maxValue = knapSack(W,weights,values);
		System.out.println("Maximum value in knapsack = "+ maxValue);
	}
}
