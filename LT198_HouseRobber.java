public class LT198_HouseRobber {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        int res = rob(nums);
        System.out.println("result="+res);
    }
    //Using include/exclude traversal
    public static int rob(int[] nums) {
        int n=nums.length;
        int[] include=new int[n+1];
        int[] exclude=new int[n+1];
        //base case with 0 0 initialisation.
        include[0]=0;
        exclude[0]=0;
        //traversal start from first element of array and use previos elements value.
        //include-array must include current element and exclude-array must exclude current

        for(int i=1;i<=n; i++){
            //add curr element in previously excluded value.
            include[i] = nums[i-1] + exclude[i-1];
            //in exclude we can have option to choose both previous value because
            //you dont have restriction as per rule.
            exclude[i] =  Math.max(include[i-1], exclude[i-1]);
        }
        //In anycase you will both option and choose the best one from these two
        return Math.max(include[n], exclude[n]);
    }

    public int robByDP(int[] nums) {
        int[] dp = new int[nums.length];
        //trival base case.
        if(nums.length==1) return nums[0];
        //if only 2 elements
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        //set base case value in dp
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        //start from house 3
        for(int i=2; i<nums.length;i++){
            //include mean we can add value and we can only take value of previous to previous house mean i-2
            int includeCurrentHouse=nums[i] + dp[i-2];
            //exclude mean we can take previous value and do not add anything.
            int excludeCurrentHouse=dp[i-1];
            //at current dp we can take max from both this
            dp[i]=Math.max(includeCurrentHouse, excludeCurrentHouse);
        }
        return dp[dp.length-1];

    }
}
