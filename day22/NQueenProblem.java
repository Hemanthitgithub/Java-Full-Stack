package day22;

public class NQueenProblem {
	final int N = 8;
	void printSolution(int board[][]) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++){
				System.out.print(" " + board[i][j]+" ");
			}
			System.out.println();
		}
	}
	boolean isSafe(int board[][],int row,int col,boolean[] rows,boolean[] d1,boolean[] d2) {
		return !rows[row] && !d1[row - col + N - 1] && !d2[row + col];
	}
	
	
	boolean solveNQUtil(int board[][],int col,boolean[] rows,boolean[] d1,boolean[] d2) {
		if(col >= N) {
			return true;
		}
		for(int i=0;i<N;i++) {
			if(isSafe(board,i,col,rows,d1,d2)) {
				board[i][col] = 1;
				rows[i] = true;
				d1[i - col + N - 1] = true;
				d2[i + col] = true;
				
				if(solveNQUtil(board,col+1,rows,d1,d2)) {
					return true;
				}
				board[i][col] = 0;
				rows[i] = false;
				d1[i-col + N - 1] = false;
				d2[i+col] = false;
			}
		}
		return false;
	}
	boolean solveNQ() {
		int board[][] = new int[N][N];
		boolean[] rows = new boolean[N];
		boolean[] d1 = new boolean[2*N-1];
		boolean[] d2 = new boolean[2*N-1];
		
		if(!solveNQUtil(board,0,rows,d1,d2)) {
			System.out.print("Solution does not exist");
			return false;
		}
		printSolution(board);
		return true;
	}
	
	public static void main(String[] args) {
		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNQ();
	}

}
