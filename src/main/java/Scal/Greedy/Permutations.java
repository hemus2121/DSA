package Scal.Greedy;

/*Problem Description

Given an integer array A of size N denoting collection of numbers , return all possible permutations.
*/


import java.util.ArrayList;

public class Permutations {

    static ArrayList<ArrayList<Integer>> results = new ArrayList<>();

     public static ArrayList<ArrayList<Integer>>  generatePer(ArrayList <Integer> A){
        computePermutaions(0, A.size(), A);
        return results;
    }

    private static void computePermutaions(int index,int n,ArrayList<Integer> A){
         if (index==n){
             results.add(new ArrayList<>(A));
             return;
         }

         //lets iterate from replacing values at 1st index
        for (int l =index;l< n;l++){
            swap(l,index, A);
            computePermutaions(index+1, n, A);
            //revert back changes
            swap (index,l, A);
        }
    }

    private static void swap(int src, int dest, ArrayList<Integer> A){
         int temp = A.get(src);
         A.set(src, A.get(dest));
         A.set(dest, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        System.out.println(generatePer(data));
    }
}
