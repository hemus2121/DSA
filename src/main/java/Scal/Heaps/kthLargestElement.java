package Scal.Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class kthLargestElement {
    private static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        //using MIN HEAP..i.e because ath minium will be at top if if heapsize is of A size
        PriorityQueue<Integer> pq = new PriorityQueue(A);
        ArrayList<Integer> resList = new ArrayList();

        //Add 1st window size of A elements
        for (int i = 0; i <A; i++) {
            pq.add(B.get(i));
            //if (i!=A-1) resList.add(-1);
            //else resList.add(pq.peek());
            resList.add(-1);
        }

        //reduce size of result by 1 count since extra element is added in result
        resList.remove(resList.size() - 1);
        resList.add(pq.peek());
        //System.out.println ("que size:"+ pq.size() + " resultsize: "+ resList);

        //check with minimum from MIN HEAP for incoming element
        for (int i = A-1 ; i < B.size(); i++) {

            //if incoming element is greater replace minimum element in
            if (pq.peek() < B.get(i)) {
                pq.poll();
                pq.add(B.get(i));
                resList.add(pq.peek());
            } else {
                resList.add(pq.peek());
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);

        System.out.println(solve(4, data));
    }

}
