public class LT322_CoinChangeUnbounded {

    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amt=5;
        int result=change(coins,amt);
        System.out.println(result);
    }
    //Unbounded knapsack
    public static int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length+1][amount+1];
        //set default value of basecase.
        dp[0][0]=0;
        //setting first row  default value
        for (int j = 1; j < dp[0].length ; j++) {
            //do not use integer.max becaue if you use it and if you plus +1 into them then
            //it will be overflow and became -(negative) value and output will be wrong.
            //dp[i][j]=Integer.MAX_VALUE;
            dp[0][j]=amount+1;
        }
        //setting first column  default value as previous value
        for (int i = 1; i <dp.length ; i++) {
            dp[i][0]=dp[i-1][0];
        }
        //start with row 1 and column 1
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (j<coins[i-1]){
                    //this is always exclude case
                    dp[i][j]=dp[i-1][j];
                }
                else {
                    int remainingAmout=j-coins[i-1];
                    int exclude=dp[i-1][j];
                    int include = 1 + dp[i][remainingAmout];
                    dp[i][j]=Math.min(include,exclude);
                }
            }
        }
        if(dp[dp.length-1][amount] == amount+1) return -1;
        return dp[dp.length-1][amount];
    }
    //total how many ways
    public static int change(int[] coins, int amount) {
        //this will handle it is bounded or unbounded
        //value 1 mean bounded and value=0 mean unbounded
        int bounded=0;
        int[][] dp=new int[coins.length+1][amount+1];
        int m=dp.length, n=dp[0].length;
        //set default value of basecase.
        dp[0][0]=1;
        //setting first row  default value
        for (int j = 1; j < dp[0].length ; j++) {
            //do not use integer.MAX_VALUE becaue if you use it and if you plus +1 into them then
            //it will be overflow and became -(negative) value and output will be wrong.
            //dp[i][j]=Integer.MAX_VALUE;
            dp[0][j]=0;
        }
        //setting first column  default value as previous value
        for (int i = 1; i <dp.length ; i++) {
            dp[i][0]=dp[i-1][0];
        }
        //start with row 1 and column 1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (j<coins[i-1]){
                    //this is always exclude case
                    dp[i][j]=dp[i-1][j];
                }
                else {
                    int remainingAmoutColumn=j-coins[i-1];
                    int exclude=dp[i-1][j];
                    int include = dp[i][remainingAmoutColumn];
                    //change what you want to do heere
                    //get min from both result or sum or compare true/false etc.
                    dp[i][j]=include+exclude;
                }
            }
        }
        ///if some case has been mentioned then handle it before return result
        //if(dp[dp.length-1][amount] == amount+1) return -1;
        return dp[m-1][n-1];
    }
}
