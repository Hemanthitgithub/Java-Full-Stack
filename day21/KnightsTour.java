package day21;

public class KnightsTour {

    static int N = 8;

    // Utility function to check if (x, y) is a valid move
    static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // Utility function to print the board
    static void printSolution(int[][] board) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.printf("%2d ", board[x][y]);
            }
            System.out.println();
        }
    }

    // Main function to solve the Knight's Tour problem
    static boolean solveKnightsTour() {
        int[][] board = new int[N][N];

        // Initialize the solution matrix
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                board[x][y] = -1;
            }
        }

        // xMove[] and yMove[] define the next move of Knight
        // xMove[] is for next value of x coordinate
        // yMove[] is for next value of y coordinate
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // The Knight is initially at the first block
        board[0][0] = 0;

        // Start from 0,0 and explore all tours using solveKTUtil()
        if (!solveKTUtil(board, 0, 0, 1, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(board);
        }

        return true;
    }

    // A recursive utility function to solve Knight Tour problem
    static boolean solveKTUtil(int[][] board, int x, int y, int moveCount, int[] xMove, int[] yMove) {
        int k, nextX, nextY;
        if (moveCount == N * N)
            return true;

        // Try all next moves from the current coordinate x, y
        for (k = 0; k < 8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKTUtil(board, nextX, nextY, moveCount + 1, xMove, yMove))
                    return true;
                else
                    board[nextX][nextY] = -1; // backtracking
            }
        }

        return false;
    }

    public static void main(String[] args) {
        solveKnightsTour();
    }
}