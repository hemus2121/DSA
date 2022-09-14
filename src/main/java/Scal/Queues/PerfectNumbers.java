package Scal.Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

/*
Problem Description

Given an integer A, you have to find the Ath Perfect Number.
A Perfect Number has the following properties:
It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.

For example 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 */
public class PerfectNumbers {
    private static  String getNthPerfectNumber(int A){

        Queue<String> que = new LinkedList();

        que.add("1");
        que.add("2");
        List<String> resList = new ArrayList();

        while (resList.size() < A){
            // take from q
            String temp = que.peek();
            resList.add(temp);
            que.remove();

            //generate numbers and append to Q
            que.add(temp+'1');
            que.add(temp+'2');
        }

        //pick from list
        String res = resList.get(A-1);
        StringBuilder sb = new StringBuilder();
        sb.append(res) ;
        return ""+res+sb.reverse();
    }
    public static void main(String[] args) {
        System.out.println(getNthPerfectNumber(1000));
        //System.out.println(getNthPerfectNumber(3));

    }

    }
