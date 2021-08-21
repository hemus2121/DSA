package ArraysProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer>  spiralTraverse(int [][] array){
        // Lets define place holder for response
        List <Integer> response = new ArrayList<>();

        //lets define pointers for pointing to specific locations
        int startRow =0;
        int startCol=0;
        int endRow = array.length-1;
        int endColumn= array[0].length-1;

        // ensuring within boundary
        while (startRow <= endRow && startCol <= endColumn){

            // 1st row
            for (int col = startCol; col <=endColumn;col++){
                response.add(array[startRow][col]);
            }

            //iterate last column
            for (int row =startRow+1 ; row <=endRow; row++){
                response.add(array[row][endColumn]);
            }

            //iterate last row
            for (int col = endColumn-1 ; col >=startCol; col-- ){
                if(startRow == endRow) break;
                response.add(array[endRow][col]);
            }
            //iterate 1st column
            for (int row = endRow-1; row > startRow; row--){
                if (startCol== endColumn) break;
                response.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endColumn--;
        }
        return  response;
    }

    public static void main(String[] args) {
        int [] [] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralTraverse(data));
    }
}
