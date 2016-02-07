public class BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    if(prices.length<2) {
      return 0;
    }
    int maxProfit = 0, buyPrice=0;
    boolean bought=false;
    for(int i=0; i<prices.length; i++) {
      if(i==prices.length-1) {
        if(bought) {
          maxProfit+=prices[i]-buyPrice;
        }
        return maxProfit;
      }
      if(prices[i+1]>prices[i]) {
        if(!bought) {
          buyPrice = prices[i];
          bought = true;
        }
      } else {
        if(prices[i+1]<prices[i] && bought) {
          bought=false;
          maxProfit+=prices[i]-buyPrice;
          buyPrice=0;
        }
      }
    }

    return maxProfit;
  }
}