package Scal.Arrays.Hashing;

/* Valid Sudoku
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    private static int isValidSudoku(final String []A){

        Set<Character> hashSet = new HashSet<>();
        int SIZE = 9;
        //check rows
        for (int rows =0;rows< SIZE;rows++){
            hashSet.clear();
            for (int cols=0;cols< SIZE;cols++){
                char c = A[rows].charAt(cols);
                if( c !='.' && hashSet.contains(c)) return 0;
                hashSet.add(c);
            }
        }

        //check columns
        for (int rows =0;rows< SIZE;rows++){
            hashSet.clear();
            for (int cols =0;cols< SIZE;cols++){
                char c = A[cols].charAt(rows);
                if( c !='.' && hashSet.contains(c)) return 0;
                hashSet.add(c);
            }
        }

        //check for 3 * 3 matrix
        for (int totalSize =0;totalSize<SIZE;totalSize++){
            int x = totalSize / 3;
            int y = totalSize % 3;
            hashSet.clear();
            for (int rows = 3 * x; rows < 3*x+3; rows++){
                for (int cols = 3*y ; cols < 3*y+3; cols++){
                    char c = A[cols].charAt(rows);
                    if( c !='.' && hashSet.contains(c)) return 0;
                    hashSet.add(c);
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        String [] s = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        System.out.println(isValidSudoku(s));
    }
}