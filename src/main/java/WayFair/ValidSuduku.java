package WayFair;

import java.util.HashSet;
import java.util.Set;

//Reference link - https://leetcode.com/problems/valid-sudoku/solutions/1363615/valid-sudoku/
public class ValidSuduku {
    private static boolean isValid(char [][] board){
        int N=9;
        //use hashset to record the status
        Set<Character>[] rows = new HashSet[N];
        Set<Character>[] cols = new HashSet[N];
        Set<Character>[] boxes = new HashSet[N];

        for (int r=0;r<N;r++){
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }

        for (int r =0;r<9;r++){
            for (int c =0;c< 9;c++){
                char ch = board[r][c];

                if (ch =='.') continue;
                //check in rows if already found
                if (rows[r].contains(ch)) return false;
                rows[r].add(ch);

                //check in cols if already found
                if (cols[c].contains(ch)) return false;
                cols[c].add(ch);

                //check the box
                int idx = r/3 *3 + c/3;
                if (boxes[idx].contains(ch)){
                    return false;
                }
                boxes[idx].add(ch);
            }
        }
        return true;
    }
    public static void main(String[] args) {
     char [][] data =
             {{'5','3','.','.','7','.','.','.','.'},
              {'6','.','.','1','9','5','.','.','.'},
              {'.','9','8','.','.','.','.','6','.'},
              {'8','.','.','.','6','.','.','.','3'},
              {'4','.','.','8','.','3','.','.','1'},
              {'7','.','.','.','2','.','.','.','6'},
              {'.','6','.','.','.','.','2','8','.'},
              {'.','.','.','4','1','9','.','.','5'},
              {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValid(data));
    }
}
