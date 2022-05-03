import java.util.*;

public class LT354_RussianDollEnvelopesLIS {
    public static void main(String[] args) {
        int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        LT354_RussianDollEnvelopesLIS driver = new LT354_RussianDollEnvelopesLIS();
        int result = driver.maxEnvelopes(envelopes);
        System.out.println(result);
    }

    public int maxEnvelopes(int[][] envelopes) {
        int count=0;
        if(envelopes.length==0) return count;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        Arrays.sort(envelopes,(a,b)-> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<envelopes.length;i++){
            Integer curr = envelopes[i][1];
            Integer higherOrEqual = treeSet.ceiling(curr);
            if(higherOrEqual==null){
                treeSet.add(curr);
            }else {
                treeSet.remove(higherOrEqual);
                treeSet.add(curr);
            }
        }
        return treeSet.size();
    }
}
