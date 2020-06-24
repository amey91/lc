package javasolutions;

public class BestTimeToBuyAndSellStockIII {

  // get profits for i which is [0..i and (i+1)..n] and use max of these profits
  public int maxProfit(int[] prices) {
    if(prices.length<2) {
      return 0;
    }

    int[] left = new int[prices.length];
    int minPrice=Integer.MAX_VALUE;
    int profit=0;
    for(int i=0; i<prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      profit=Math.max(profit, prices[i]-minPrice);
      left[i]=profit;
    }


    // calculate profits backwards
    int[] right = new int[prices.length];
    int maxPrice=prices[prices.length-1];
    right[right.length-1] = 0;
    profit=0;
    for(int i=prices.length-2; i>=0; i--) {
      maxPrice = Math.max(maxPrice, prices[i]);
      profit=Math.max(profit, maxPrice-prices[i]);
      right[i]=profit;
    }

    int maxProfit = 0;
    // for ith position, profit = profit(from 0 to ith number) + profit(i+1 th number to end)
    for(int i=0; i<prices.length-1;i++) {
      maxProfit=Math.max(maxProfit, left[i]+right[i+1]);
    }

    return Math.max(maxProfit, left[left.length-1]);
  }
}