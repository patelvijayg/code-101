import java.util.TreeSet;

public class TemplateLIS {
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
}
