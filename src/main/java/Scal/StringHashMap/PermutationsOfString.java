package Scal.StringHashMap;

public class PermutationsOfString {

    private static int getPermuationCount(String A, String B) {
        int n = A.length();
        int m = B.length();
        int hash1[] = new int[26];
        int hash2[] = new int[26];
        int count = 0;
        // count frequency of each char in A
        for (int i = 0; i < n; i += 1) {
            hash1[A.charAt(i) - 'a'] += 1;
        }
        // count frequency of each char in first window of size n in B
        for (int i = 0; i < n; i += 1) {
            hash2[B.charAt(i) - 'a'] += 1;
        }
        count += same(hash1, hash2);
        // move current window 1 step ahead
        for (int i = n, j = 0; i < m; i += 1, j += 1) {
            hash2[B.charAt(j) - 'a'] -= 1;
            hash2[B.charAt(i) - 'a'] += 1;
            count += same(hash1, hash2);
        }
        return count;
    }
    public static int same(int[] hash1, int[] hash2) {
        for (int i = 0; i < 26; i += 1) {
            if (hash1[i] != hash2[i])
                return 0; // not a permutation of A
        }
        return 1; // got a permutation of A in G
    }

    public static void main(String[] args) {
        System.out.println(getPermuationCount("aabc", "aebaca"));
        System.out.println(getPermuationCount("abc","abcbacabc"));
        System.out.println(getPermuationCount("aca","aaca"));
        System.out.println(getPermuationCount("p","pccdpeeooadeocdoacddapacaecb"));
    }
}
