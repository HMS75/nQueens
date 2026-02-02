/* Problem Statement - 
Place N queens on an NxN chessboard such that no 2 queens attack each other.
A queen can attack another in the same row/column/diagonal. */


/* Idea - 
We place queens row by row i.e., for each row - 
1) Try every column
2) Check if placing a queen there is safe
3) If safe -> place it -> move to next row [recursion!]
4) Else -> remove queen [backtrack!] -> try next column */

/* in the board, 
0 = empty, 1 = queen */

public class nQueens {
    private int N;
    private int[][] board;

    // constructor
    public nQueens(int N) {
        this.N = N;
        board = new int[N][N];
    }
    
    // function to check if its safe to place queen
    private boolean isSafe(int row, int col) {

        // check col
        for (int i=0; i<row; i++)
        {   if (board[i][col] == 1) return false; } 
    
        // check upper left diagonal
        for (int i=row - 1, j = col - 1; i>=0 && j>=0; i--, j--) 
        {   if (board[i][j] == 1) return false; }
        
        // check upper right diagonal
        for (int i=row - 1, j = col + 1; i>=0 && j < N; i--, j++)
        {   if (board[i][j] == 1) return false; }

        return true;    }

     // recursive function to solve
    private boolean solve(int row) {
        if (row == N) 
        {   printBoard();
            return true; }
        
        boolean foundSol = false;

        for(int col=0; col<N; col++) 
        {   if (isSafe(row,col)) 
            {   // place queen
                board[row][col] = 1;
                
                foundSol = solve(row+1) || foundSol;

                //backtrack
                board[row][col] = 0;    } }
            
            return foundSol; }
            
    // print board
    private void printBoard() {
        System.out.println("\nSolution:");
        for (int i=0; i<N; i++)
        {   for (int j=0; j<N; j++)
            {   System.out.print(board[i][j] == 1 ? "Q" : ". "); }
            System.out.println(); } }

    public static void main(String[] args) {
        int n = 8;
        nQueens nq = new nQueens(n);
        nq.solve(0);
    }   }