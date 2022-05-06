package Scal.Arrays;
/* Majority Element

Problem Description
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.

 */
public class MajorityElement {

    //solving using Boycee Moore Voting Algorithm
    private static int majorityElement(final int [] A){

        int majorEle = A[0];
        int freq = 1;
        int n = A.length;

        for(int i =1;i<n ;i++){
            int x= A[i];
            if (x== majorEle){
                freq++;
            } else if (freq ==0){
                majorEle = x;
                freq =1;
            }else {
                freq--;
            }
        }

        //iterate in original array and get frequency of majority element and try whether its count is > N/2
        int count= 0;
        for (int a : A){
            if (a == majorEle){
                count++;
            }
        }
        return (count > n/2) ? majorEle : -1 ;
    }
    public static void main(String[] args) {
        int [] data = { 2, 1, 2,1,1};
        System.out.println(majorityElement(data));
    }
}