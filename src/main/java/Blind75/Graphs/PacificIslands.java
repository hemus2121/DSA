package Blind75.Graphs;

/** Pacific Atlantic Water Flow -https://leetcode.com/problems/pacific-atlantic-water-flow/
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 */

import java.util.*;

public class PacificIslands {
    static int rows, cols;
    static int [][] landHeights;
    static int [][] dirs = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        // set to visited points for both pacific and atlantic seas
        boolean [][] at = new boolean[rows][cols];
        boolean [][] pa = new boolean[rows][cols];
        landHeights = heights; // reference of original heights

        //ROWS - iterare 1st an last row
        for (int c =0;c < cols;c++){
            dfs (0, c, pa, heights[0][c]) ;
            dfs (rows-1,c, at, heights[rows-1][c]);
        }

        //COLS - iterate 1st and last cols
        for (int r =0;r < rows;r++){
            dfs (r, 0, pa, heights[r][0]);
            dfs (r, cols-1, at, heights[r][cols-1]);
        }

        //Iterate and check whether coordinates are found in at AND pt matrix
        List<List<Integer>> resultList = new ArrayList();
        for (int r =0; r<rows;r++){
            for (int c =0; c < cols;c++){
                if (at[r][c] && pa[r][c]){
                    List tempList = new ArrayList();
                    tempList.add(r);
                    tempList.add(c);
                    resultList.add(tempList);
                }
            }
        }
        return resultList;
    }

    // DFS method
    static void  dfs(int row, int col, boolean [][]  visited, int prevHeight){
        // BASE CASE -- checking water flow from sea to location
        if (row <0 || col <0 || row==rows || col==cols || landHeights[row][col] < prevHeight || visited[row][col])   {
            return ;
        }

        //mark it as visited
        visited[row][col]= true;

        // MAIN LOGIC - iteration in 4 directions
        for (int[] dir: dirs){
            int new_r = row+ dir[0];
            int new_c = col+ dir[1];
            //recursive calls
            dfs(new_r,new_c, visited, landHeights[row][col]);
        }
    }

    public static void main(String[] args) {
        int [][] data = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        System.out.println((pacificAtlantic(data))); //expected [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
    }
}
