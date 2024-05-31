package day22;

public class RatInMaze {
	final int N = 6;
	
	void printSolution(int sol[][]) {
		for(int i=0;i<N;i++) {
			for(int j=00;j<N;j++) {
				System.out.print(" "+ sol[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	boolean isSafe(int maze[][],int x, int y) {
		return(x>=0 && x < N && y >=0 && maze[x][y] == 1);
	}
	boolean solveMazeUtil(int maze[][],int x, int y,int sol[][]) {
		if(x == N - 1 && y == N - 1 && maze[x][y] == 1) {
			sol[x][y] =1;
			return true;
		}
		
		if(isSafe(maze,x,y)){
			sol[x][y] = 1;
			if(solveMazeUtil(maze,x+1,y,sol)) {
				return true;
			}
			
			if(solveMazeUtil(maze,x,y+1,sol)) {
				return true;
			}
			
			sol[x][y] = 0;
			return false;
		}
		return false;
	}
	boolean solveMaze(int maze[][]) {
		int sol[][] = new int[N][N];
		
		if(!solveMazeUtil(maze,0,0,sol)) {
			System.out.println("Solution does not exist");
			return false;
		}
		printSolution(sol);
		return true;
	}
	
			
	public static void main(String[] args) {
		
		RatInMaze rat = new RatInMaze();
		int maze[][] = {
				{1,0,0,0,0,0},
				{1,1,0,1,1,1},
				{0,1,0,1,0,0},
				{1,1,1,1,0,1},
				{0,0,0,1,1,1},
				{0,0,0,0,0,1},
		};
		rat.solveMaze(maze);
	}
}
