package LeetCode.Graphs;

/**
 * Pacific Atlantic Water Flow
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */

import java.util.*;

public class PacificAtlanticWaterFlow {
    private static List<List<Integer>> pacificAtlanticCompute(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        //we need dp array to compute distance from boundary inwards
        int[][] dp = new int[rows][cols];

        // since we are doing BFS
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // add the FIRST ROW Values - PACIFIC OCEAN
        for (int i = 0; i < cols; i++) {
            visited[0][i] = true;
            queue.add(new int[]{0, i});
            dp[0][i] += 1;
        }

        // add FIRST Column values
        for (int i = 1; i < rows; i++) {
            visited[i][0] = true;
            queue.add(new int[]{i, 0});
            dp[i][0] += 1;
        }

        //INVOKE BFS for pacific ocean
        bfs(heights, visited, queue, dp);

        //RESET visited and que
        visited = new boolean[rows][cols];
        queue = new LinkedList<>();

        // add LAST column - ATLANTIC ocean
        for (int i = 0; i < cols; i++) {
            visited[rows - 1][i] = true;
            queue.add(new int[]{rows - 1, i});
            dp[rows - 1][i] += 1;
        }

        // for LAST row
        for (int i = 0; i < rows - 1; i++) {
            visited[i][cols - 1] = true;
            queue.add(new int[]{i, cols - 1});
            dp[i][cols - 1] += 1;
        }

        //INVOKE BFS for Atlantic ocean
        bfs(heights, visited, queue, dp);

        // Response
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == 2) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public static void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue, int[][] dp) {
        int n = heights.length, m = heights[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : dirs) {
                int dx = x + dir[0], dy = y + dir[1];

                if (dx < 0 || n <= dx || dy < 0 || m <= dy) continue;
                if (visited[dx][dy]) continue;
                if (heights[dx][dy] < heights[x][y]) continue;
                visited[dx][dy] = true;
                dp[dx][dy] += 1;
                queue.offer(new int[]{dx, dy});
            }
        }
    }


    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(pacificAtlanticCompute(heights));
    }
}
