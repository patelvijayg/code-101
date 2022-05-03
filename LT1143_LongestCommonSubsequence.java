import java.util.ArrayList;
import java.util.List;

public class LT1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        LT1143_LongestCommonSubsequence driver = new LT1143_LongestCommonSubsequence();
        String text1="abcde", text2="ace";
        int count=driver.longestCommonSubsequence(text1,text2);
        System.out.println("LCS="+count);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int result=0;
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        List<Character> output = new ArrayList();
        for (int i = 1; i <dp.length ; i++) {

            for (int j = 1; j < dp[i].length; j++) {
                ///Make sure you start picking up from first char of string
                //in this case we need to start i-1 which happens to 0 for first.
                char c1 = text1.charAt(i-1);
                char c2 = text2.charAt(j-1);
                //if char are then 1 + remain string which mean prevoius of both.
                // abc acc => 1 + (bc,cc) and bc,cc you already have calculated.
                if(c1 == c2 ){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    output.add(c1);
                }else{
                    int skip1 = dp[i-1][j];
                    int skip2 = dp[i][j-1];
                    dp[i][j]= Math.max(skip1,skip2);
                }
            }
        }
        result = dp[dp.length-1][dp[0].length-1];
        System.out.println(output);
        return result;
    }


//   -  a  c  e
//-  0  0  0  0
//    \
//a  0  1  1  1
//   __|
//b  0  1  1  1
//c  0  1  2  2
//d  0  1  2  2
//e  0  1  2  3
// if both char match.. take diagonal + 1, else max of previous row,col
}
