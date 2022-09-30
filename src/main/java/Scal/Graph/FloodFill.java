package Scal.Graph;

/** Flood Fill
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

    int[]  dx = { 0, 1, 0, -1};
    int [] dy = {1, 0, -1, 0};

    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // get initial color
        int initColor =image[sr][sc];
        int [][] ans = image; //result matrix
        dfs(sr, sc, ans, image, newColor, initColor);
        return ans;
    }

    private void dfs(int sr, int sc, int[][] ans, int[][] image, int newColor, int initColor) {

        //fill answer will new color
        ans [sr][sc ] = newColor;

        int n = image.length;
        int m = image[0].length;
        //iterate all 4 directions
        for (int d =0;d < 4;d++){
            int nrow = sr + dx[d];
            int ncol = sc + dy[d];

            //check conditions- very important - checking answer not marked yet and new location has same color as before
            if (nrow >=0 && ncol >=0 && nrow <n && ncol <m && image[nrow][ncol] == initColor && ans[nrow][ncol] !=newColor){
                dfs(nrow, ncol, ans, image, newColor, initColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int sr =1, sc =1, newColor = 2;
        FloodFill floodFill = new FloodFill();
        int [][] ans = floodFill.floodFill(image, sr, sc, newColor);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
