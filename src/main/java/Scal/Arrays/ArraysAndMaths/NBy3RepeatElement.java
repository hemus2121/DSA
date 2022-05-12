package Scal.Arrays.ArraysAndMaths;

/* N/3 Repeat Element
Problem Description
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NBy3RepeatElement {
    //Solving using Boyer Moree Majority Algorithm
    private static int getRepeatElement(final List<Integer> a){

        //Since its N/3 we need 2 buckets and 1 DB concept
        int n = a.size();
        int elem1 = a.get(0);
        int freq1= 1;
        int elem2=0, freq2=0;

        for (int i =1;i< n;i++){
            int x = a.get(i);
            if (x == elem1 ||  x == elem2){
                if (x ==elem1) freq1++ ;
                else freq2++;
            }else if (freq1==0 || freq2==0){
                if (freq1==0){
                    elem1 = x; freq1++;
                }else {
                    elem2 = x; freq2++;
                }
            }else {
                // kind of moving each element from bucket to dustbin
                freq1--;
                freq2--;
            }
        }

        // now iterate array and check majority element
        int count1=0, count2 =0;
        for (int aa : a){
            if (aa == elem1){
                count1++;
            }else if (aa == elem2){
                count2++;
            }
        }

        if (count1  > n/3 ) return elem1;
        else if (count2 > n /3) return elem2;
        return -1;
    }
    public static void main(String[] args) {
        //int [] data = {1, 2, 3 1, 1};
        List<Integer> dataList = new ArrayList<>(
                Arrays.asList(1, 1, 1, 2, 3, 5, 7 ));
        System.out.println(getRepeatElement(dataList));
    }
}
