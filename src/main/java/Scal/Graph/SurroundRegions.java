package Scal.Graph;
/** Surrounded Regions | Replace O’s with X’s

 Problem Statement: Given a matrix mat of size N x M where every element is either ‘O’ or ‘X’.
 Replace all ‘O’ with ‘X’ that is surrounded by ‘X’. An ‘O’ (or a set of ‘O’) is considered to be surrounded by ‘X’ if there are ‘X’ at locations just below, just above just left, and just right of it.
 **/

public class SurroundRegions {

    private static int ROWS = 5;
    private static int COLS = 4;

    int [] dx = {-1, 0 , 1 ,0 };
    int [] dy = {0, 1 , 0 , -1};

    private void dfs (int row,int col, char [][] mat, int [][] visited){
        visited[row][col]=1;
        int n = mat.length;
        int m = mat[0].length;
        // check for 4 directions
        for (int d =0;d<4;d++){
            int nrow = row + dx[d];
            int ncol= col + dy[d];

            //check condition
            if (nrow >=0 && nrow < n && ncol >=0 && ncol <m && visited[nrow][ncol]==0 && mat[nrow][ncol]=='O'){
                dfs(nrow, ncol,mat, visited);
            }
        }
    }

    private char [][] fill (char [][] mat, int rows, int cols){
        int [][] visited = new int [rows][cols];

        // check for unvisited Os in the boundary rows
        //first row
        for (int j=0;j< cols;j++){
            //first row
            if ( visited[0][j] == 0 && mat[0][j]=='O'){
                dfs(0, j, mat, visited);
            }

            //last row
            if (visited[rows-1][j]==0 && mat[rows-1][j] =='O'){
                dfs(rows-1, j, mat, visited);
            }
        }

        //check for unvisited 0s in boundary cols
        for (int i =0;i <rows ;i++){
            //first column
            if (visited[i][0]==0 && mat[i][0] =='O'){
                dfs(i, 0, mat, visited);
            }

            //last column
            if (visited[i][cols-1]==0 && mat [i][cols-1]=='O'){
                dfs (i, cols-1, mat,visited );
            }
        }

        //if unvisited 0 then convert to X
        for (int i =0;i< rows;i++){
            for (int j=0; j< cols;j++){
                if (visited[i][j]==0){
                    mat[i][j]= 'X';
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};
        SurroundRegions surroundRegions = new SurroundRegions();
        char [][] ans = surroundRegions.fill( mat, ROWS, COLS);

        for (int i =0;i< ROWS;i++){
            for (int j=0;j< COLS;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
