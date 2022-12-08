package WayFair;

public class MaxChunksToMakeSorted {
    public static int solve(int [] A){
        int cnt=0,max=0,i=0;
        for (int a: A){
            max= Math.max(a, max);
            if (max==i){
                cnt++;
            }
            i++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int [] data = {2, 0, 1, 3};
        System.out.println(solve(data));
    }
}
