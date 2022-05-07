import java.util.*;
public class LT456_Pattern132 {

    public boolean find132pattern(int[] nums) {
        int len=nums.length;
        int[] min = new int[len];
        //prepare the array of min sofar for each element
        min[0]=nums[0];
        for(int i=1; i<len; i++){
            min[i]=Math.min(min[i-1],nums[i]);
        }
        //create monotonic stack to find max element
        //and find min element from min array and
        //compare current element with both min<cur<stack.peek()
        Stack<Integer> st = new Stack();
        for(int j=len-1; j>=0; j--){
            if(nums[j]>min[j]){
                while(st.size()>0 && st.peek()<=min[j]){
                    st.pop();
                }
                if(st.size()>0 && st.peek()<nums[j] ){
                    return true;
                }
                st.push(nums[j]);
            }

        }
        return false;
    }
}
