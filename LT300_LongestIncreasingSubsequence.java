import java.util.Arrays;
import java.util.TreeSet;

public class LT300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LT300_LongestIncreasingSubsequence driver = new LT300_LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        int lis =driver.lengthOfLIS(nums);
        System.out.println(lis);
    }
    ///Using BST we can do it in nlogn
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer cur = nums[i];
            //we will check if any hiegher value element present than curr
            //if yes then we need to replace with lower value(curr) so we will get longest increse sequence.
            //incase there is no higer value then anyway we need to add current value.
            Integer higherOrEqualValue = treeSet.ceiling(cur);
            if(higherOrEqualValue != null){
                treeSet.remove(higherOrEqualValue);
            }
            treeSet.add(cur);
        }
        return treeSet.size();
    }


    public int lengthOfLIS2(int[] nums) {
        int len=nums.length;
        int[] dp = new int[len];
        //Fill default value of lis as 1 since any single element is lis itself
        Arrays.fill(dp,1);

        for(int right=1; right<len; right++){
            //left pointer start from beggining till right pointer
            for(int left=0; left<right; left++){
                //Right value should be bigger than left value
                boolean isBigValue= nums[right]>nums[left];
                //Right LIS should be lesser or equal to left lis
                boolean isBigLIS = dp[right]<=dp[left];
                if(isBigValue && isBigLIS){
                    dp[right] = dp[left]+1;
                }
            }

        }
        int longest=dp[0];
        for(int i=1; i<dp.length;i++){
            if(dp[i]>longest) longest=dp[i];
        }
        ///Print Longest Increasing SubSequence
        int lastLongest=longest;
        int[] displayLIS = new int[lastLongest];
        for(int j=len-1; j>=0 && lastLongest>0; j--){
            if(dp[j]==lastLongest){
                displayLIS[lastLongest-1]=nums[j];
                lastLongest--;
            }
        }
        System.out.println(Arrays.toString(displayLIS));
        return longest;
    }
}
