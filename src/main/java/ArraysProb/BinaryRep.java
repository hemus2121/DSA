package ArraysProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryRep {

    public static int [] decToBinary(int n){
        List<Integer> data=  new ArrayList();
        // Size of an integer is assumed to be 32 bits
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                data.add(1);
            else
                data.add(0);
        }
        return data.stream().mapToInt(val->val).toArray();
    }

    private  static int[] convertDecimalToBinary(int num){
        Stack<Integer> stack = new Stack<>();
        while(num>0){
            stack.push(num%2);
            num/=2;
        }
        int[] binaryArr = new int[32];
        Stack<Integer> popped = new Stack<>();
        int i = 31;
        while(!stack.isEmpty()){
            popped.push(stack.pop());
        }
        while(!popped.isEmpty()){
            binaryArr[i] = popped.pop();
            i--;
        }

        return binaryArr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decToBinary(7)));
        System.out.println(Arrays.toString(convertDecimalToBinary(7)));
    }
}
