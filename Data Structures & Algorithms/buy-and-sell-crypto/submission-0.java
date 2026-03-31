class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buy = 0, sell = 1;
        while(sell<prices.length){
            int sp = prices[sell];
            int cp = prices[buy];
            if(sp<cp)
                buy = sell;
            else{
                int profit = prices[sell]-prices[buy];
            maxprofit = Math.max(profit, maxprofit);
            }
            sell++;
        }

        return maxprofit;
    }
}
