public class LT121_BestTimeToBuyStock {
    public static void main(String[] args) {
        LT121_BestTimeToBuyStock driver = new LT121_BestTimeToBuyStock();
        int result_expected = 5;
        int[] prices = {7,1,5,3,6,4};
        int result_actual = driver.maxProfitWithMany(prices);
        System.out.println(result_actual);
        System.out.println(result_actual == result_expected);

    }
    public int maxProfit(int[] prices) {
        int profit=0;
        //consider first element is minmum price
        int minPrice=prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currentPrice=prices[i];
            //calculate currentprofit
            int currentProfit=currentPrice-minPrice;
            if(currentPrice > minPrice ){
                // if it is greater than overall profit then update
                profit = Math.max(profit, currentProfit);
            }else {
                minPrice=currentPrice;
            }
        }
        return profit;
    }
    public int maxProfitWithMany(int[] prices) {
        int profit=0;
        int buyIndex=0, sellIndex=0;
        for (int i = 1; i < prices.length; i++) {
            int currentPrice=prices[i];
            int previousPrice=prices[i-1];

            if(currentPrice>=previousPrice){
                sellIndex++;
            }else{
                int currProfit = prices[sellIndex]-prices[buyIndex];
                profit=profit+currProfit;
                buyIndex=sellIndex=i;
            }
        }
        //to handle the last transaction
        profit = profit +prices[sellIndex]-prices[buyIndex];
        return profit;
    }
}
