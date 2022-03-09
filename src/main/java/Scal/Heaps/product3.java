package Scal.Heaps;

import java.lang.reflect.Array;
import java.util.*;

public class product3 {
    private  static ArrayList<Integer> getProduct(List<Integer> A){
        PriorityQueue<Integer> pq = new PriorityQueue();
        ArrayList <Integer> resList = new ArrayList();
        final int LIMIT = 3;

        for (int i =0;i<LIMIT;i++){
            pq.add(A.get(i));
            if(i!=LIMIT-1){
                resList.add(-1);
            }
        }
        //compute for first window
        computeProduct(pq, resList);

        for (int i = LIMIT;i< A.size();i++){
            //remove min element
            if (A.get(i) < pq.peek()){
                computeProduct(pq,resList);
            } else{
                pq.remove();
                pq.add(A.get(i));
                computeProduct(pq,resList);
            }
        }
        return resList;
    }
    static void computeProduct(PriorityQueue pq, ArrayList<Integer> resList){
        Iterator<Integer> it = pq.iterator();
        int product =1;
        while (it.hasNext()){
            product = product * it.next();
        }
        resList.add(product);
    }
    public static void main(String[] args) {
        List<Integer> data =  Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(getProduct(data));

        List<Integer> data1 =  Arrays.asList(10, 2, 13, 4);
        System.out.println(getProduct(data1));

        List<Integer> data2 = Arrays.asList(11, 5, 6, 2, 8, 10 );
        System.out.println(getProduct(data2));
    }
}
