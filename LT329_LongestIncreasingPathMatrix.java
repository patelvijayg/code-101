import java.util.Arrays;

public class LT329_LongestIncreasingPathMatrix {
    public static void main(String[] args) {
        int[][] matrix= {{9,9,4},{6,6,8},{2,1,1}};
        LT329_LongestIncreasingPathMatrix driver =new LT329_LongestIncreasingPathMatrix();
        int path=driver.longestIncreasingPath(matrix);
        System.out.println(path);
    }
    int[][] dp ;
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        dp=new int[m][n];
        int lip=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr=dfs(matrix,i,j,-1);
                lip=Math.max(lip,curr);
            }
        }
        return lip;
    }
    public int dfs(int[][] matrix, int r, int c, int prevVal){
        int m=matrix.length, n=matrix[0].length;
        //handle the out of bounce or it happens to small than previous value
        if(r<0 || r>=m || c<0 || c>=n || matrix[r][c] <= prevVal  ) return 0;
        //since array contains 0 by default so if cell is not set it mean not visited
        //if it is not zero mean it is visited and we can return the value(it is like cache)
        if(dp[r][c]!=0) return dp[r][c];
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int curr=0;
        for (int[] dir : dirs){
            //make move for all possible direction and get max out of these
            curr = Math.max(curr, dfs(matrix,r+dir[0],c+dir[1],matrix[r][c]));
        }
        //add one to it as it adding one more element in possible direction.
        int path=1+curr;
        dp[r][c]=path;
        return path;
    }
}
