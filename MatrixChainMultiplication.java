public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] mat = {40, 20, 30, 10, 30};
        int[][] mat2d = get2d(mat);
        int[][] dp = new int[mat.length][mat.length];
        int[][] dp1 = new int[mat.length][mat.length];
        int counts = matmul(mat,1,mat.length-1,dp);
        System.out.println();
        int counts1 = matmul2d(mat2d,0,mat2d.length-1,dp1);
        System.out.println(counts + " " +counts1);
    }
    public static int[][] get2d(int[] arr){
        int[][] tmp = new int[arr.length-1][2];
        for (int i = 1; i <arr.length ; i++) {
            tmp[i-1][0]=arr[i-1];
            tmp[i-1][1]=arr[i];
        }

        return tmp;
    }
    public static int matmul(int[] arr,int i, int j, int[][] dp){
        //assuming that we are partitioning between i position and j position
        //base case is that both position is same then there is not cose of mulitpicaton
        if(i==j) return 0;
        //check if Memoization is having that data
        if (dp[i][j]>0) return dp[i][j];
        //since we need to find minimum value so we can declare with maximum value
        int ans= (int) 10e8;
        //start patritioning from i till j. start with i=k mean almost no partition but it will be handled in base case
        for (int k = i; k < j ; k++) {
            //this is actual calculation that taking
            //first value of first matrix* last value of last matrix * matrix positoin k
            int val=arr[i-1]*arr[k]*arr[j];
            //System.out.println(arr[i-1]+","+arr[k]+","+arr[j]);
            ///main multiplication between 2 big matrix + find indivisual both matrix calculation.
            int count = val + matmul(arr,i,k,dp) + matmul(arr,k+1,j,dp);

            if(count < ans){
                ans=count;
            }
            //ans=Math.min(ans,count);
        }
        dp[i][j]=ans;
        return ans;
    }

    static public int  matmul2d(int[][] arr, int i, int j, int[][] dp){
        int ans= (int) 10e8;
        if(i==j) return 0;
        if(dp[i][j]>0) return dp[i][j];
        for (int k = i; k <j ; k++) {
            int val=arr[i][0] * arr[k][1]*arr[j][1];
            //System.out.println(""+arr[i][0] +","+ arr[k][1]+","+arr[j][1]);
            int count= val  + matmul2d(arr,i,k,dp) + matmul2d(arr,k+1,j,dp);
            if(count<ans) ans=count;
        }
        dp[i][j]=ans;
        return ans;
    }

}
