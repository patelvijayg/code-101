import java.util.ArrayDeque;

public class LT1438_LongestSubArraywithKDiffMinMax {
    public static int longestSubarray(int[] nums, int limit) {
        int ans=0;
        ArrayDeque<Integer> minStack = new ArrayDeque();
        ArrayDeque<Integer> maxStack = new ArrayDeque();

        int n=nums.length,left=0,right=0;
        while (right<n){
            int curr=nums[right];
            //Removing index which already smaller than left index
            //as it should not consider in that window size.
            //Make sure you remove from front because that is place which we refering
            //when peek the element
            while (minStack.size()>0 &&  minStack.peekFirst()<left){
                minStack.removeFirst();
            }
            while (maxStack.size()>0 &&  maxStack.peekFirst()<left){
                maxStack.removeFirst();
            }

            //for minstak please remove element greater than current one
            while (minStack.size()>0 && (nums[minStack.peekLast()]>curr ) ){
                minStack.removeLast();
            }
            minStack.add(right);
            //for maxstak please remove element lesser than current one
            while (maxStack.size()>0 && nums[maxStack.peekLast()]<curr ){
                maxStack.removeLast();
            }
            maxStack.add(right);

            int absDiff=0, maxLen=1;
            //In anycase you will have to increase right or left pointer
            if(maxStack.size()>0 && minStack.size()>0){
                //find the actual indexes from both stack from FRONT.
                int firstIndex=minStack.peekFirst();
                int lastIndex=maxStack.peekFirst();

                absDiff=Math.abs(nums[lastIndex]-nums[firstIndex]);
                //Calculate window size by using diff of right and left pointer
                maxLen=right-left+1;
                if(absDiff<=limit){
                    ans=Math.max(ans,maxLen);
                    right++;
                }else {
                    left++;
                }
            }
        }
        return ans;
    }
}
