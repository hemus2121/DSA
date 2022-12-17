package WayFair;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList  = new ArrayList<>();
        int [] indegree = new int[numCourses+1];
        buildGraph(numCourses, prerequisites, adjList, indegree);

        return topoSort(numCourses, adjList, indegree);

    }

    static private boolean topoSort(int numCourses, List<List<Integer>> adjList, int[] indegree) {

        Queue<Integer> q = new LinkedList<>();
        for (int i =0;i< numCourses;i++){
            if (indegree[i]==0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int temp = q.poll();
            //visit adj element
            for (int neighbour: adjList.get(temp)){
                indegree[neighbour]--;
                if (indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        for (int ind: indegree){
            if (ind != 0 ) return false;
        }
        return true;
    }

    static void buildGraph (int numCourses, int [][]prerequisites, List<List<Integer>>adjList, int [] indegree){
        for (int i =0;i< numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for (int [] pre : prerequisites){
            adjList.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
    }
    public static void main(String[] args) {
        int [][] pre = {{1,0}};
        int courseCount =2;
        System.out.println((canFinish(courseCount, pre)));
    }
}
