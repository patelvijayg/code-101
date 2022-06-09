public class LT132_PalindromePartitioning {
    public static void main(String[] args) {

    }
    //Front Partition / forward partition method
    public int minCut(String s) {
        //Memoization result
        int[] memo = new int[s.length()];
        //Memoization for palindrom because it will be call again and again
        Boolean[][] cache = new Boolean[s.length()][s.length()];
        //-1 because you are travelling till last item and last item also permform on partition
        return findMinCut(s,0,memo,cache)-1;
    }

    public int findMinCut(String s, int start, int[] memo, Boolean[][] cache){
        int n=s.length();

        if(start==n) return 0;
        if(memo[start]>0) return memo[start];
        //Start with max value so you will compare with minimum
        int overAllMin=n;
        for (int i = start; i <n; i++) {
            //check if first partition is palindrom then only it make sense to make for remaining
            boolean firstPart = isPalindrome(s,start,i,cache);
            if(firstPart){
                ///1 for first partition, call remaning to get partition
                int currmin= 1 + findMinCut(s,i+1,memo,cache);
                //check if currmin is beats overall min then update accordingly
                if(currmin<overAllMin){
                    overAllMin=currmin;
                }
            }

        }
        //Memo the value for this input so it will be use for future call
        memo[start]=overAllMin;
        return overAllMin;
    }

    public boolean isPalindrome(String s , int start, int end, Boolean[][] cache){
        if(start==end) return true;
        if(cache[start][end] != null) return cache[start][end];
        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                cache[start][end]=false;
                return false;
            }
            start++;
            end--;
        }
        cache[start][end]=true;
        return true;
    }

}
