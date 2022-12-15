package Scal.BinarySearch;
/*Problem Description

        Given an array of integers A of size N and an integer B.

        College library has N books,the ith book has A[i] number of pages.
        You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

        A book will be allocated to exactly one student.
        Each student has to be allocated at least one book.
        Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

        Calculate and return that minimum possible number.
 */

public class Allocatebooks {

    private static int allocateBooks(int[] A, int B) {
        //Search space BEST CASE - Maximum value in Array because that is maximum that can be allocated
        //  WORSTCASE = all the books to be allocated for singel student
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int a : A) {
            sum += a;
            if (a > max) {
                max = a;
            }
        }

        //edge case if number of students are greater then number of books return -1
        if (B > A.length) return -1;

        //normal binary search l = max, r = sum
        long l = max, r = sum, ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;

            if (check(A, mid, B)) {
                ans = mid + 1;
                l = mid + 1;
            } else r = mid - 1;
        }
        return (int) (ans == 0 ? l : ans);
    }

    //check if continous books can be allocated to B students
    private static boolean check(int[] A, long mid, int B) {
        long countofStudents = 1;
        long runningsum = 0;
        //iterate over array elements
        for (int a : A) {
            runningsum += a;
            if (runningsum > mid) {
                countofStudents++;
                runningsum = a;
            }
        }
        return (countofStudents > B) ? true : false;
    }

    public static void main(String[] args) {
        int[] data = {12, 34, 67, 90};
        //System.out.println(allocateBooks(data,2));

        //expected is 97
        int[] data1 = {97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24};
        // System.out.println(allocateBooks(data1, 26));

        int[] data2 = {22};
        //System.out.println(allocateBooks(data2,1));

        int[] data3 = {98, 42, 99, 68, 12, 60, 57, 94, 8, 95, 68, 13, 30, 6, 62, 42};
        System.out.println(allocateBooks(data3, 16));
    }

}
