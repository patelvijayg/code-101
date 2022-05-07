import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LT496_NextGreaterElementMonotonicStack {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Monotonic stack
        //first fill the stack with previous element will in stack and
        //get compare with current elememnt and it small then remove and
        //put it into map for mapping of current element's next greater element
        //In short stack should have bigger element and remove smaller than current
        Map<Integer, Integer> map = new HashMap();
        Stack<Integer> st = new Stack();

        for(int i=0; i<nums2.length; i++){
            //Remove all element which smaller than current
            while(st.size()>0 && st.peek()<nums2[i]){
                map.put(st.pop(),nums2[i]);
            }
            //NOTE: We must add current to stak
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0; i<ans.length;i++){
            ans[i]=map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}
