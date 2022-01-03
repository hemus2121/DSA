package Scal.Recursion2.Assi;

import java.util.ArrayList;

public class TowerOfHanoi {
    static ArrayList<ArrayList<Integer>> responseList= new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        int S =1,T=2,D=3;
        compute(A,S,T,D);
        return responseList;

    }

    public static void compute(int N, int S, int T, int D){
        if (N==0) return;
        //move N-1 disks from Source to Temp
        compute (N-1, S, D, T);

        // Move to Nth disk from Source to Destination
        // add the movement to response -- HERE I doing string format way
        //responseList.add((ArrayList<String>) Stream.of(" "+A+" "+S+" "+D).collect(Collectors.toList()));
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(N);
        tempList.add(S);
        tempList.add(D);
        responseList.add(tempList);

        // Move 1st moved N-1 disks from Temp to Destination
        compute (N-1, T, S, D);
    }


    public static void main(String[] args) {
        System.out.println(towerOfHanoi(3));
    }

}
