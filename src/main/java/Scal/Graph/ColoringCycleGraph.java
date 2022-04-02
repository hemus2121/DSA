package Scal.Graph;
/*
Coloring a Cycle Graph
Problem Description

Given the number of vertices A in a Cyclic Graph.
Your task is to determine the minimum number of colors required to color the graph so that no two Adjacent vertices have the same color.
 */
public class ColoringCycleGraph {
    private static  int getColorCount(int A){
        // Check if number of vertices
        // is odd or even.
        // If number of vertices is even
        // then color require is 2 otherwise 3
        return (A%2==0) ?2: 3;
    }
    public static void main(String[] args) {
        System.out.println(getColorCount(5));
    }
}
