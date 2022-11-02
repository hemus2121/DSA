package visa.Arrays;

//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

public class WinnerTicTacToe {
    public String tictactoe(int[][] moves) {

        int n = moves.length;
        int [] rows = new int [n];
        int [] cols = new int [n];
        int diag =0, anti_diag=0;

        // Two players having value of 1 and -1, player_1 with value = 1 places first.
        int player = 1;


        for (int [] move : moves){
            int row = move[0];
            int col = move[1];

            rows[row] += player;
            cols[col] += player;

            //update diagona
            if (row==col) diag++;
            if (row+col == n-1) anti_diag++;

            //check for equal cond
            if (Math.abs(rows[row])==n || Math.abs(cols[col])==n||
                Math.abs(diag)==n || Math.abs(anti_diag)==n){
                return player==1? "A":"B";
            }

            //invert the player
            player *= -1;
        }
        // If all moves are completed and there is still no result, we shall check if
        // the grid is full or not. If so, the game ends with draw, otherwise pending.
        return  moves.length == n *n ? "Draw" : "Pending";
    }

}
