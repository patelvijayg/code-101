import java.util.*;
import java.util.stream.Collectors;

public class RecursionSamples {


    public static void main(String[] args) {
        RecursionSamples r = new RecursionSamples();
        int nums[] = {1,2,3};

        List<List<Integer>> ls = r.permutewithspace(nums);
        System.out.println(ls);
    }

    public List<List<Integer>> permutewithspace(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] marker = new boolean[nums.length];
        generatePermuteWithSpace(marker,curr,ans,nums);
        return ans;
    }
    private void generatePermuteWithSpace(boolean[] marker,List<Integer> curr, List<List<Integer>> ans ,int[] nums ){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i <nums.length; i++) {
            if(marker[i]==false){
                marker[i]=true;
                curr.add(nums[i]);
                generatePermuteWithSpace(marker,curr,ans,nums);
                curr.remove(curr.size()-1);
                marker[i]=false;
            }
        }

    }

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        generatePermutation(0,ans,nums);
        return ans;
    }
    void generatePermutation(int pos, List<List<Integer>> ans, int[] nums ){
            if(pos== nums.length){
                ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }
        for (int i = pos; i <nums.length ; i++) {
            swap(pos,i,nums);
            //here you pass the next position instead of i because you already swapped the nums array
            //next you just need to reverse the same swap.
            generatePermutation(pos+1,ans,nums);
            swap(pos,i,nums);
        }
    }
    private void swap(int i, int j, int[] arr){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public List<List<String>> palindromPartition(String input){
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        parition(0,curr,ans,input);
        System.out.println(ans);
        return ans;
    }
    private void parition(int start, List<String> curr, List<List<String>> ans, String str ){
        if(start==str.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            String firstPart = str.substring(start,i+1);
            if( isPalindrom(firstPart)){
                curr.add(firstPart);
                //Make sure here you use i and not the start variable because you are trying all
                //option with all partition
                parition(i+1,curr,ans,str);
                curr.remove(curr.size()-1);
            }

        }
    }
    private boolean isPalindrom(String s){
        //if (s.length()==0) return false;
        StringBuilder sb = new StringBuilder(s).reverse();
        return sb.toString().equals(s);
    }


    public static void mainMinPath(String[] args) {
        int[][] grid = {{5,3},{4,0},{2,1}}, moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        int n=grid.length, m=grid[0].length;
        int[][] dp = new int[n][m];
        //int ans = minPathCost(grid,moveCost);
        for (int j = 0; j < m ; j++) {
            int ans1 = minPathRecursion(n-1,j,grid,moveCost,dp);
            System.out.println(ans1);
            System.out.println(Arrays.deepToString(dp));
        }

    }

    ///It is form of multiple start point and multiple end point
    public static int minPathCost(int[][] grid, int[][] moveCost) {

        int n=grid.length, m=grid[0].length;
        int[][] dp = new int[n][m];
        //fill the last row of dp by value it self
        for (int i = 0; i < m; i++) {
            dp[n-1][i]=grid[n-1][i];
        }
        //since it is problem reach bottom so we will start from bottom and reach to 0 row.
        for (int i = n-2; i >=0; i--) {
            for (int j = 0; j < m; j++) {
                //now calculate every i,j combination. here it is possible for all column we need loop to calculate one
                //postion
                int mini = Integer.MAX_VALUE;
                int scrIndex=grid[i][j];
                int[] descCost=moveCost[scrIndex];

                for (int k = 0; k <m ; k++) {
                    int result = descCost[k] + dp[i+1][k]+grid[i][j];
                    mini=Math.min(mini,result);
                }
                dp[i][j]=mini;
            }
        }
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans=Math.min(ans,dp[0][i]);
        }
        return ans;

    }

    //start with f(i,j) where i start with n and reaches 0.
    public static int minPathRecursion(int i, int j, int[][] grid, int[][] moveCost, int[][] dp) {
        //base case when reaches to last row we need to return
        if(i==0){
            return grid[0][j];
        }
        //chcek if dp already contains value
        if(dp[i][j]>0) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        //normally we do not need loops but here j value needs to consider for all hence it require loop
        for (int k = 0; k <grid[0].length ; k++) {
            int scrIndex=grid[i-1][k];
            int[] descCost=moveCost[scrIndex];
            int cst=descCost[j];
            //here we need to calculate one cell and make recursion call for i-1..
            int curr= grid[i][j] +  cst + minPathRecursion(i-1,k,grid,moveCost,dp);
            //System.out.println("cell="+ grid[i][k] + " cost="+cst + "  curr="+curr + " srcind="+scrIndex );
            mini=Math.min(curr,mini);
        }
        dp[i][j]=mini;
        return mini;
    };
}
