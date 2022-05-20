import java.util.Arrays;

public class LT10_RegularExpressionMatching {
    public static void main(String[] args) {
        LT10_RegularExpressionMatching driver =new LT10_RegularExpressionMatching();
        boolean result = driver.isMatch("ab", ".*");
        System.out.println(result);
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        char[] arrStr = new char[s.length() + 1];
        char[] arrPtr = new char[p.length() + 1];
        System.arraycopy(s.toCharArray(), 0, arrStr, 1, s.length());
        System.arraycopy(p.toCharArray(), 0, arrPtr, 1, p.length());

        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            if (arrPtr[i] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {
                char chStr = arrStr[i];
                char chPtr = arrPtr[j];
                //case 1 where pattern has same char or .
                //here we will get result by truncing both by 1 char
                if (chStr == chPtr || chPtr == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                //case 2 when it is * there are 2 possibilities
                } else if (chPtr == '*') {
                    //possibility one just take the 2 step back in pattern mean we will consider
                    //that by removing * can we match with their previous result of pattern
                    dp[i][j] = dp[i][j - 2];
                    //incase previous to * is either dot(.) or same char of pattern then
                    //take OR of both result and push to dp
                    if (arrPtr[j - 1] == chStr || arrPtr[j - 1] == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }


        return dp[dp.length - 1][dp[0].length - 1];
    }
    public boolean dfs(int i, int j, String s, String p){
        int lens=s.length(),lenp=p.length();

        //This is the case where we completed both string completely
        if(i>=lens && j>=lenp) return true;

        //This case we completed pattern but still string is remains mean it is false
        if(j>=lenp) return false;
        boolean matchOne=false;
        //now check string char by char to match.
        if(i<lens){
           matchOne= s.charAt(i)==p.charAt(j) || p.charAt(j)=='.';
        }
        //This is the case when next char is * in pattern
        //we will have 2 possibilities 1. we can include current char 2. we can move to next char in pattern by jumping 2 position
        if( (j+1) < lenp && p.charAt(j+1)=='*' ){
            boolean excludep = dfs(i,j+2,s,p);
            boolean includep = dfs(i+1,j,s,p); //if we want to include then it must matchone then only we can do it.
            boolean result = (includep && matchOne) || excludep;
            return result;
        }
        //now check if first match then next
        if(matchOne){
            boolean matchNext = dfs(i+1,j+1,s,p);
            return matchNext;
        }

        //finally we will return false if none of above return
        return false;
    }

}
