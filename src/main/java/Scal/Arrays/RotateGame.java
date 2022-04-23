package Scal.Arrays;

/*
Given an integer array A and an integer B, you have to print the same array after rotating it B times towards the right.

NOTE: You can use extra memory.
 */
import java.util.Arrays;
import java.util.Scanner;

public class RotateGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        int rotationCount = Integer.parseInt(in.nextLine());

        //getting integer count
        String [] dataValues = data.split(" " );
        int length = Integer.parseInt(dataValues[0]);

        int [] dataInt = new int[dataValues.length-1];
        for (int i =1;i< dataValues.length;i++){
            dataInt[i-1] = Integer.parseInt(dataValues[i]);
        }

        //carry out rotation
        reverse(dataInt, 0 , length-1); // rotate complete array
        reverse(dataInt, 0, rotationCount-1); // rotate 1st k elements
        reverse(dataInt, rotationCount, length-1); //rotate remaining n-k elements

        System.out.println(Arrays.toString(dataInt));
    }

    private static void reverse(int [] arr, int start, int end){
        while (start< end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]= temp;
            start++;
            end --;
        }
    }
}
