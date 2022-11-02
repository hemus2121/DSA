package visa.Arrays;

public class BuySellStocks {
    public static int maxProfit(int[] prices) {
        int maxPro=0;
        int minPrice = Integer.MAX_VALUE;
        // iterate array elements and keep updating min and profit values
        for (int  i=0;i< prices.length;i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxPro= Math.max(maxPro, prices[i]-minPrice);
        }
        return  maxPro;
    }

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);
    }

    }
