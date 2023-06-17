import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class TemplateLIS {
    public static void main(String[] args) {
        TemplateLIS driver = new TemplateLIS();
        //int[] arr = {1,7,8,4,5,6,-1,9};
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int res = driver.LISusingPQ(arr);
        int res2 = driver.lengthOfLIS(arr);
        System.out.println(res);
    }
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
        System.out.println("using tree="+treeSet);
        return treeSet.size();
    }
    public int LISusingPQ(int[] nums){
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if(pq.isEmpty()==false) {
                int higher=pq.peek();
                if(higher>curr){
                    pq.remove();
                }
            }
            pq.add(curr);
        }
        System.out.println("using quue="+pq);
        return pq.size();
    }
}
