package WayFair;

import java.util.*;

public class CourseSchedule2 {
    static public int[] findOrder(int numCourses, int[][] prerequisites) {
        List <List<Integer>> adjList = new ArrayList<>();
        int [] indegree = new int [numCourses+1];
        buildGraph(numCourses, prerequisites, adjList, indegree);

        List<Integer> resList = new ArrayList<>();
        return topoSort(numCourses,adjList, indegree, resList);
    }

    static int [] topoSort (int num, List<List<Integer>> adjList , int [] ind, List<Integer> resList){
        Queue <Integer> q = new LinkedList<>();

        // add nodes whole indegree is zero
        //add nodes whose indegree is 0
        for (int i=0;i< num;i++){
            if (ind[i]==0){
                q.add(i);
            }
        }

        // pop out from q
        while (!q.isEmpty()){
            int temp = q.poll();
            resList.add(temp);
            //iterate adj nodes
            for (int  neighbour : adjList.get(temp)){
                ind[neighbour]--;
                if (ind[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        //check if every node is covered or not
        for(int degree: ind) {
            if(degree != 0)
                return new int[]{};
        }
        return resList.stream().mapToInt(val -> val).toArray();
    }

    static void buildGraph(int numCourse, int [][]preq, List<List<Integer>>adjList , int [] indegree){
        for (int i=0;i<= numCourse;i++){
            adjList.add(new ArrayList<>());
        }

        //add edges for adjList
        for (int [] pre : preq){
            adjList.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
    }
    public static void main(String[] args) {
        int [][] pre = {{1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        int courseCount =4;
        System.out.println(Arrays.toString(findOrder(courseCount, pre)));
    }
}
